package com.yedam.inheri;

public class Compute extends Calculator{
	
	//자식 클래스
	//메소드 재정의(오버라이딩)
	
	@Override //@ -> 어노테이션 : 소스를 컴파일 할때 오버라이딩 된 메소드가 존재한다.
	//                         컴파일러에게 알려주기 위한 용도.
	double areaCircle(double r) {
		System.out.println("Compute 객채의 areaCircle()");
		return Math.PI * r*r; 
	}
	
}
