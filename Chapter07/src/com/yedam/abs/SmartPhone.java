package com.yedam.abs;

public class SmartPhone extends Phone{
	public SmartPhone(String owner) {
		super(owner);
	}
	
	
	public void internetSearch() {
		System.out.println("폰을 검색합니다.");
	}


	@Override
	public void turnOff() {
		System.out.println("반드시 구현한 turnOff 메소드");
		
	}
	
	
	
	
}
