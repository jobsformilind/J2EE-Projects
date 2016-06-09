package com.test.patterns.gof.creational.factory.computer;

public class ComputerFactoryMain {

	public static void main(String[] args) {
		Computer comp1 = ComputerFactory.getComputer(ComputerType.PC);
		System.out.println(comp1);
		comp1.boot();

		Computer comp2 = ComputerFactory.getComputer(ComputerType.SERVER);
		System.out.println(comp2);
		comp2.boot();
	}

}
