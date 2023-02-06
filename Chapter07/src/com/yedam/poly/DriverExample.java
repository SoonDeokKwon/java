package com.yedam.poly;

public class DriverExample {
	public static void main(String[] args) {
		Driver driver = new Driver();
		
		Bus bus = new Bus();
		Taxi taxi = new Taxi();
		
		driver.drive(bus); //driver.drive(new Bus());
		driver.drive(taxi); //driver.drive(new Taxi());
		
	}
}
