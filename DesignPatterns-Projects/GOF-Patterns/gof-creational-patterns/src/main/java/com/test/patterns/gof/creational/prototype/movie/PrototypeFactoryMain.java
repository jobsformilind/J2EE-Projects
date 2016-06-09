package com.test.patterns.gof.creational.prototype.movie;

public class PrototypeFactoryMain {
	public static void main(String[] args) throws Exception {
		String moviePrototype = PrototypeFactory.getInstance(ModelType.MOVIE).toString();
		System.out.println(moviePrototype);

		String showPrototype = PrototypeFactory.getInstance(ModelType.SHOW).toString();
		System.out.println(showPrototype);
	}
}
