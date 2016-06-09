package com.test.patterns.gof.creational.factory.computer;

public class ComputerFactory {

	public static Computer getComputer(ComputerType type) {
		Computer computer = null;
		switch (type) {
			case PC:
				computer = new PC("2 GB", "500 GB", "2.4 GHz");
				break;
			case SERVER:
				computer = new Server("16 GB", "1 TB", "2.9 GHz");
				break;
			default:
				throw new RuntimeException("Invalid computer type");
		}
		return computer;
	}
}
