package com.chat.domain;

import java.time.LocalDateTime;

public class Message {
	private int id;
	private UsersLocal from;
	private UsersLocal to;
	private LocalDateTime date;
	private String content;
	
	public Message(int id, UsersLocal from, UsersLocal to, String content, LocalDateTime date) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.date = date;
		this.content = content;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public UsersLocal getFrom() {
		return from;
	}
	public void setFrom(UsersLocal from) {
		this.from = from;
	}
	public UsersLocal getTo() {
		return to;
	}
	public void setTo(UsersLocal to) {
		this.to = to;
	}
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}


	@Override
	public String toString() {
		return "{\"id\":" + id + ", \"from\":" + from + ", \"to\":" + to + ", \"date\": \"" + date + "\", \"content\" :\"" + content + "\"}";
	}


}
