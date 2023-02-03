package com.yedam.inheri;

public class Child extends Parent{
	
	//필드
	//lastName,bloodType, age, hobby, 
	private String lastName;
	private char bloodType;
	private int age;
	private String hobby;


	
	
	//생성자
	
	
	//메소드
	@Override
	public void getInfo() {
		super.getInfo();
		System.out.println("내이름 : " + lastName);
	}
	
	
	
	
	
	
	
	
//	VIPPerson vip = new VIPPerson();
//	vip.memberInfo();

	
	
	
	
	
}
