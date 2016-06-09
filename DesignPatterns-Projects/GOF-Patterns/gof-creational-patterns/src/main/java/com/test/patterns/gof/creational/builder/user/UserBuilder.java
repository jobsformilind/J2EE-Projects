package com.test.patterns.gof.creational.builder.user;

public class UserBuilder {
	private final String firstName;
	private final String lastName;
	private int age;
	private String phone;
	private String address;

	public UserBuilder(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public UserBuilder age(int age) {
		this.age = age;
		return this;
	}

	public UserBuilder phone(String phone) {
		this.phone = phone;
		return this;
	}

	public UserBuilder address(String address) {
		this.address = address;
		return this;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public int getAge() {
		return age;
	}

	public String getPhone() {
		return phone;
	}

	public String getAddress() {
		return address;
	}

	// Return the finally consrcuted User object
	public User build() {
		User user = new User(this);
		validateUserObject(user);
		return user;
	}

	private void validateUserObject(User user) {
		// Do some basic validations to check
		// if user object does not break any assumption of system
	}
}
