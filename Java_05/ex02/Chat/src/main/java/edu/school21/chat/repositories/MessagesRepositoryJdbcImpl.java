package edu.school21.chat.repositories;

import edu.school21.chat.repositories.MessagesRepository;

import edu.school21.chat.models.Chatroom;
import edu.school21.chat.models.Message;
import edu.school21.chat.models.User;
import edu.school21.chat.repositories.MessagesRepository;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.Optional;

public class MessagesRepositoryJdbcImpl implements MessagesRepository {

	class NotSavedSubEntityException extends RuntimeException {
		public NotSavedSubEntityException(){
			super("NotSavedSubEntityException");
		}
	}



	private final DataSource dataSource;

	public MessagesRepositoryJdbcImpl(DataSource dataSource) {
		this.dataSource = dataSource;
	}


	@Override
	public boolean save(Message message) throws NotSavedSubEntityException {
		String SQL_INSERT_MESSAGE = "INSERT INTO chat.message (author, chatroom, text, messageDateTime)" + "VALUES (?, ?, ?, ?)";

		try (Connection connection = dataSource.getConnection();
			 PreparedStatement statement = connection.prepareStatement(SQL_INSERT_MESSAGE, Statement.RETURN_GENERATED_KEYS)) {
			statement.setLong(1, message.getAuthor().getId());
			statement.setLong(2, message.getChatroom().getId());
			statement.setString(3, message.getText());
			statement.setTimestamp(4, Timestamp.valueOf(message.getMessageDateTime()));
			statement.execute();

			ResultSet key = statement.getGeneratedKeys();
			key.next();
			message.setId(key.getLong(1));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new NotSavedSubEntityException();
		}
		return true;
	}
	@Override
	public Optional<Message> findById(Long messageId) {
		Optional<Message> optionalMessage;
		try {
			Connection connection = dataSource.getConnection();
			Statement statement = connection.createStatement();
			String query = "SELECT * FROM chat.message WHERE chat.message.id = " + messageId;
			ResultSet resultSet = statement.executeQuery(query);

			if (!resultSet.next())
				return Optional.empty();

			optionalMessage = Optional.of(new Message(messageId,
					getMessageAuthor(connection, resultSet.getLong(2)),
					getMessageChatRoom(connection, resultSet.getLong(3)),
					resultSet.getString(4)));

			if (optionalMessage == null)
				return Optional.empty();
			return optionalMessage;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Optional.empty();
	}

	private User getMessageAuthor(Connection connection, Long userId) {
		User user = null;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT chat.users.login, chat.users.password FROM chat.users WHERE id = " + userId);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next() == false)
				return null;
			String login = resultSet.getString(1);
			String password = resultSet.getString(2);
			user = new User(userId, login, password, null, null);
			resultSet.close();
			preparedStatement.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return user;
	}

	private Chatroom getMessageChatRoom(Connection connection, Long roomId) {
		Chatroom chatroom = null;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT name FROM chat.chatroom WHERE id = " + roomId);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next() == false)
				return null;
			String name = resultSet.getString(1);
			chatroom = new Chatroom(roomId, name, null, null);
			resultSet.close();
			preparedStatement.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return chatroom;
	}
}
