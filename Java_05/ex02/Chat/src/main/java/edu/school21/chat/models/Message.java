package edu.school21.chat.models;

import java.time.LocalDateTime;
import java.util.Objects;

public class Message {

	private Long id;
	private User author;
	private Chatroom chatroom;
	private String text;
	private LocalDateTime messageDateTime;

	public LocalDateTime getMessageDateTime() {
		return messageDateTime;
	}

	public void setMessageDateTime(LocalDateTime messageDateTime) {
		this.messageDateTime = messageDateTime;
	}

	public Message(Long id, User author, Chatroom chatroom, String text) {
		this.id = id;
		this.author = author;
		this.chatroom = chatroom;
		this.text = text;
		this.messagxeDateTime = LocalDateTime.now();
	}

	public Message(Long id, User author, Chatroom chatroom, String text, LocalDateTime time) {
		this.id = id;
		this.author = author;
		this.chatroom = chatroom;
		this.text = text;
		this.messageDateTime = time;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public Chatroom getChatroom() {
		return chatroom;
	}

	public void setChatroom(Chatroom chatroom) {
		this.chatroom = chatroom;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Message message = (Message) o;
		return id == message.id && author.equals(message.author) && chatroom.equals(message.chatroom) && text.equals(message.text) && messageDateTime.equals(message.messageDateTime);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, author, chatroom, text, messageDateTime);
	}

	@Override
	public String toString() {
		return "Message{" +
				"id=" + id +
				", author=" + author +
				", chatroom=" + chatroom +
				", text='" + text + '\'' +
				", messageDateTime=" + messageDateTime +
				'}';
	}
}
