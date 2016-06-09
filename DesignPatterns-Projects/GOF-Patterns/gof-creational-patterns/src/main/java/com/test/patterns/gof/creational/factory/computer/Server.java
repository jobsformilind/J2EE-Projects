package com.test.patterns.gof.creational.factory.computer;

public class Server extends Computer {

	public Server(String ram, String hdd, String cpu) {
		super(ram, hdd, cpu);
	}

	public void boot() {
		System.out.println("Booting Server...");
	}
}
