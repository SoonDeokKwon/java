package com.yedam.oop;

public class Application03 {
	public static void main(String[] args) {
		Bycle bycle = new Bycle();
		//일꾼
		bycle.setGas(5); //Bycle로 생성한 객체 필드값(gas) 데이터 입력
		
		boolean gasState = bycle.isLeftGas();
		if(gasState) {
			System.out.println("출발합니다.");	
			bycle.run();
		}
		
		if(bycle.isLeftGas()) {
			System.out.println("gas를 주입할 필요 없음");
		} else {
			System.out.println("gas를 주입 해야 함");
		}
		
		
		
		
		
	}
}
