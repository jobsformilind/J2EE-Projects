package com.test.mongo.sample1;

public class Person {
	private String id;
	private String firstName;
	private int age;

	public Person(String firstName, int age) {
		super();
		this.firstName = firstName;
		this.age = age;
	}

	public String getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public int getAge() {
		return age;
	}

	public String toString() {
		return "Person [ID=" + id + ", FirstName=" + firstName + ", Age=" + age + "]";
	}
}
