package com.test.patterns.gof.creational.factory.wizard;

public class JSONDataConverter implements DataConverter {
	public <T> T convert(Object source, Class<T> rawType, Class<?> actualType) {
		try {
			return rawType.newInstance();
		} catch (Exception e) {
			throw new RuntimeException("Can't instantiate class : " + rawType);
		}
	}

}
