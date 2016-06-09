package com.test.patterns.gof.creational.factory.computer;

public class PC extends Computer {

	public PC(String ram, String hdd, String cpu) {
		super(ram, hdd, cpu);
	}

	public void boot() {
		System.out.println("Booting PC...");
	}
}
