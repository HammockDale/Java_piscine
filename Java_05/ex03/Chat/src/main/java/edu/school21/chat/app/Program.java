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

		MessagesRepository messagesRepository = new MessagesRepositoryJdbcImpl(hikariDataSource);
		Optional<Message> messageOptional = messagesRepository.findById(1L);
		try {

			if (messageOptional.isPresent()) {
				Message message = messageOptional.get();
				message.setText("Bye");
				message.setMessageDateTime(null);
				messagesRepository.update(message);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
}