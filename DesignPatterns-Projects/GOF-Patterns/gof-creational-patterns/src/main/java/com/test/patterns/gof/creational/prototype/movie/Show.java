package com.test.patterns.gof.creational.prototype.movie;

public class Show implements PrototypeCapable {
	private String name = null;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Show clone() throws CloneNotSupportedException {
		System.out.println("Cloning Show object..");
		return (Show) super.clone();
	}

	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Show [name=");
		builder.append(name);
		builder.append("]");
		return builder.toString();
	}

}
