package com.yedam.example;

public class WashingExample {
	public static void main(String[] args) {
		
		LGWashingMachine LGws = new LGWashingMachine();
		LGws.startBtn();
		LGws.stopBtn();
		System.out.println("세탁기 속도: " + LGws.speedChange(2));
		LGws.endBtn();
		LGws.dryBtn();
		
		
	}
}
