package com.yedam.abs;

public abstract class Animal {
	public String kind;
	
	public void breathe() {
		System.out.println("숨을 쉰다.");
	}
	
	//추상메소드
	public abstract void sound();
	
	
}
