package com.test.patterns.gof.creational.builder.user;

public class User {
	// All final attributes
	private final String firstName; // required
	private final String lastName; // required
	private final int age; // optional
	private final String phone; // optional
	private final String address; // optional

	public User(UserBuilder builder) {
		this.firstName = builder.getFirstName();
		this.lastName = builder.getLastName();
		this.age = builder.getAge();
		this.phone = builder.getPhone();
		this.address = builder.getAddress();
	}

	// All getter, and NO setter to provde immutability
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

	public String toString() {
		return "User: " + this.firstName + ", " + this.lastName + ", " + this.age + ", " + this.phone + ", " + this.address;
	}
}
