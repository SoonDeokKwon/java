package com.yedam.oop;

public class Application09 {
	public static void main(String[] args) {
		Person p1 = new Person("111111-211111", "김또치");
		//개명
		
		System.out.println(p1.nation);
		System.out.println(p1.ssn);
		System.out.println(p1.name);
		
		
		
		//지구의 반지름
		System.out.println("지구의 반지름 : " + StaticCal.PI);
		//지구의 표면적(pi*r*r)
		System.out.println("지구의 표면적 : " + StaticCal.PI*StaticCal.EARTH_RADIUS*StaticCal.EARTH_RADIUS);
		
		//StaticCal.PI = 100; -> 오류: PI는 static final이라 바꿀 수 없음.
		
		
		
		
		
		
		
		
		
		
		
	}
}
