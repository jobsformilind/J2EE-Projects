package com.test.patterns.gof.creational.builder.computer;

public class ComputerBuilderMain {
	public static void main(String[] args) {
		Computer comp1 = new Computer.ComputerBuilder("500 GB", "2 GB").setBluetoothEnabled(true).setGraphicsCardEnabled(true).build();
		System.out.println(comp1);

		Computer comp2 = new Computer.ComputerBuilder("200 GB", "1 GB").setGraphicsCardEnabled(true).build();
		System.out.println(comp2);
	}
}
