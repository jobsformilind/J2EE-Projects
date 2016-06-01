package com.test.struts1.hello.world;

import org.apache.struts.action.ActionForm;

public class HelloWorldActionForm extends ActionForm {
	private static final long serialVersionUID = 1L;

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("HelloWorldActionForm [message=");
		builder.append(message);
		builder.append("]");
		return builder.toString();
	}
}
