package com.yedam.inter2;

public class CarExample {
	public static void main(String[] args) {
		Car myCar = new Car();
		
		myCar.run();
		
		myCar.frt = new HankookTire();
		myCar.brt = new HankookTire();
		
		myCar.run();
	}
}
