package com.yedam.oop;

public class Application02 {
	public static void main(String[] args) {
		Calculator cal = new Calculator();
		
		cal.sum(10, 20);
		int result = cal.sum2(10, 30);
		System.out.println(result);
		
		cal.sum3(new int[] {1,2,3,4,5,6});
		cal.sum4(1,2,3,4,5,6);
		
		
		//크래스 외부에서 avg 메소드 호출
		cal.avg();
		//클래스 외부에서 필드
		//cal.필드;
		
		
		
		
		
		
		
		
	}
}
