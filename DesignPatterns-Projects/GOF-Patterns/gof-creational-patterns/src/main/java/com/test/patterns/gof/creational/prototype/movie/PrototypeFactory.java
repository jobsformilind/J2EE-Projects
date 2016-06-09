package com.test.patterns.gof.creational.prototype.movie;

import java.util.HashMap;
import java.util.Map;

public class PrototypeFactory {
	private static Map<ModelType, PrototypeCapable> prototypes = new HashMap<ModelType, PrototypeCapable>();

	static {
		prototypes.put(ModelType.MOVIE, new Movie());
		prototypes.put(ModelType.SHOW, new Show());
	}

	public static PrototypeCapable getInstance(final ModelType type) throws CloneNotSupportedException {
		return ((PrototypeCapable) prototypes.get(type)).clone();
	}
}
