package edu.school21.chat.app;

import edu.school21.chat.models.*;
import edu.school21.chat.repositories.*;

import java.sql.SQLException;

import com.zaxxer.hikari.HikariDataSource;
import edu.school21.chat.models.Message;
import edu.school21.chat.repositories.MessagesRepository;
import edu.school21.chat.repositories.MessagesRepositoryJdbcImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;


public class Program {


	public static void main(String[] args) throws SQLException{
		HikariDataSource hikariDataSource = new HikariDataSource();

		hikariDataSource.setJdbcUrl("jdbc:postgresql://localhost:5432/hdale");
		hikariDataSource.setUsername("postgres");
		hikariDataSource.setPassword("");
		MessagesRepository messageRep = new MessagesRepositoryJdbcImpl(hikariDataSource);

		User author = new User(1L, "Misha", "pass123", new ArrayList<>(), new ArrayList<>());
		Chatroom room = new Chatroom(1L, "Libft", author, new ArrayList<>());
		Message message = new Message(null, author, room, "message", LocalDateTime.now());
		try {
			messageRep.save(message);
			System.out.println(message.getId());
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
}