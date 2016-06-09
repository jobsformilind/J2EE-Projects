package com.test.patterns.gof.creational.factory.wizard;

public class DataConverterFactory {

	public static DataConverter getDataConverter(ContentType type) {
		DataConverter conv = null;
		switch (type) {
			case JSON:
				conv = new JSONDataConverter();
				break;
			case XML:
				conv = new XMLDataConverter();
				break;
			default:
				throw new RuntimeException();
		}
		return conv;
	}
}
