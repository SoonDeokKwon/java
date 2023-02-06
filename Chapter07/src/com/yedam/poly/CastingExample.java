package com.yedam.poly;

public class CastingExample {
	
	//매개변수의 다형성을 활용
	public static void method1(Parent parent) {
		if(parent instanceof Child) {
			Child child = (Child)parent;
			System.out.println("Casting 성공");
		}else {
			System.out.println("Casting 실패");
		}
	}
	
	
	public static void method2(Parent parent) {
		Child child = (Child)parent;
		System.out.println("Casting 성공22222");
	}
	
	

	public static void main(String[] args) {
			
		//Child 클래스로 만들어진 객체
		Parent p1 = new Child();
		//Child child = (Child) p1
		
		//Child02로 만들어진 객체
		Parent p2 = new Child02();
		//Child02 child02 = (Child02) p2;
		
		method2(p1);
		method1(p1);
		//Child02 만들어진 객체
		method1(p2);
		
		
		
		
	}
	
	
	
}
