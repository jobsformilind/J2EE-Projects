package com.test.struts2.hello.world;

public class MessageStore {

	private String message;

	public MessageStore() {
		setMessage("Hello Struts-2 User");
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
