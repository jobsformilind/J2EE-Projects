package com.test.patterns.gof.creational.factory.wizard;

public interface DataConverter {
	public <T> T convert (Object source, Class<T> rawType, Class<?> actualType);
}
