package com.test.patterns.gof.creational.prototype.movie;

public interface PrototypeCapable extends Cloneable {
	public PrototypeCapable clone() throws CloneNotSupportedException;
}
