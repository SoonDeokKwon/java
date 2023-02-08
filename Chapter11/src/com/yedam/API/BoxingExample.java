package com.yedam.API;

public class BoxingExample {
	public static void main(String[] args) {
		
		//Boxing : 기본 타입 -> 객체로 포장
		//사용은 할 수 있지만, 되도록 권장하지 않는다.
		Integer obj1 = new Integer(100);
		Integer obj2 = new Integer("100");
		
		Integer obj3 = Integer.valueOf(100);
		Integer obj4 = Integer.valueOf("400");
		
		
		//UnBoxing
		int value1 = obj1.intValue();
		int value2 = obj2.intValue();
		int value3 = obj3.intValue();
		int value4 = obj4.intValue();
		
		System.out.println(value1);
		System.out.println(value2);
		System.out.println(value3);
		System.out.println(value4);
		
		
		//자동 박싱
		Integer obj5 = 100;
		System.out.println("value : " + obj5.intValue());
		
		//대입 시 자동 언박싱
		int value5 = obj5;
		System.out.println("value : " + value5);
			
		//연산 시 자동 언박싱
		int value6 = obj5 + 500;
		System.out.println("value : " + value6);
		
		
		//포장 값 비교(포장된 박스가 같은 지 비교)
		//비교할 수 있는 범위 존재 
		//-> 범위 내에서는 == 비교 가능
		//-> 범위 밖에서는 == 비교 불가
		//intValue() 사용해서 비교 (== 비교 권장X)
		Integer obj6 = 100;
		Integer obj7 = 200;
		System.out.println(obj6 == obj7);
		System.out.println(obj6.intValue() == obj7.intValue());
		
		Double value7 = Double.parseDouble("3.14");
		System.out.println(value7);
		
		
		
	}
}
