package com.test.patterns.gof.creational.factory.wizard;

public class DataConverterMain {

	public static void main(String[] args) {
		DataConverter conv1 = DataConverterFactory.getDataConverter(ContentType.JSON);
		StringBuilder string1 = conv1.convert(null, StringBuilder.class, StringBuilder.class).append("JSON");
		System.out.println(string1);

		DataConverter conv2 = DataConverterFactory.getDataConverter(ContentType.XML);
		StringBuilder string2 = conv2.convert(null, StringBuilder.class, StringBuilder.class).append("XML");
		System.out.println(string2);
	}
}
