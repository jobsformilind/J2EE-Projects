package com.test.patterns.gof.creational.factory.computer;

public abstract class Computer {
	private String ram;
	private String hdd;
	private String cpu;

	public Computer(String ram, String hdd, String cpu) {
		this.ram = ram;
		this.hdd = hdd;
		this.cpu = cpu;
	}

	public String getRAM() {
		return this.ram;
	}

	public String getHDD() {
		return this.hdd;
	}

	public String getCPU() {
		return this.cpu;
	}

	public abstract void boot();

	public String toString() {
		return "RAM= " + this.getRAM() + ", HDD=" + this.getHDD() + ", CPU=" + this.getCPU();
	}
}
