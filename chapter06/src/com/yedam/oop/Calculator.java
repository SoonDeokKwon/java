package com.yedam.oop;

public class Calculator {
	//필드
	
	//생성자
	
	
	//메소드
	//덧셈,뺄셈....
	//리턴타입(리턴문)이 없는 메소드
	void sum(int x, int y) {
		int result = x + y;
		System.out.println(x + " + " + y + " = " + result);
	}
	void sum(double x, double y) {
		
	}
	void sum(char x, char y) {
		
	}
	void sum(int x, int y, int z) {
		
	}
	//리턴타이(리턴문)이 존재하는 메소드
	int sum2 (int x, int y) {
		int result = x + y;
		return result;
	}
	
	//매개변수의 개수를 모를 경우
	//1) 배열 활용
	void sum3(int[] intAry) {
		int result = 0;
		for(int i = 0; i < intAry.length; i++) {
			result += intAry[i];
		}
		System.out.println("총 합계 : " + result);
	}
	//2)... 활용
	void sum4(int ...intAry) {
		int result = 0;
		for(int i = 0; i < intAry.length; i++) {
			result += intAry[i];
		}
		System.out.println("총 합계 : " + result);
	}
	
	void avg() {
		int result  = sum2(10,20);
		System.out.println("평균 : " + (result/2));
	}
	
	
	
	
	
	
	
	
	
	
}
