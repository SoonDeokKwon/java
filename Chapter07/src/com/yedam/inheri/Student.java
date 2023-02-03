package com.yedam.inheri;

public class Student extends People {
	//자식 클래스
	//필드
	public int stdNo;
	
	//생성자
	public Student(String name, String ssn, int stdNo) {
		//부모 클래스의 생성자 호출 -> 부모 객체 생성
		super(name, ssn);
		this.stdNo = stdNo;
	}
		
	//메소드
	
}
