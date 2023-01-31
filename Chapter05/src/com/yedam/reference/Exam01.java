package com.yedam.reference;

public class Exam01 {

	public static void main(String[] args) {
		
		int intVal = 10;
		int[] array = {1,2,3};
		int[] array2 = {1,2,3};
		int[] array3 = null;
		int a;
		
		System.out.println(intVal);
		System.out.println(array); // 스택영역에 참조타입이 머무르고 있는 주소(번지) 값이 있음 
		System.out.println(array2); // 스택영역에 참조타입이 머무르고 있는 주소(번지) 값이 있음
		System.out.println(array[0] == array2[0]); 
		
		//System.out.println(array3.length);
		
		
		//<참고>
		//memory leak -> 메모리 누수, 메모리 부족 
		//반복문을 무한으로 돌릴 때 변수가 계속 만들어지다 보면 변수를 저장할 수 있는 공간이 부족해짐
		//garbage collector가 주기적으로 안쓰는 변수들을 제거해줌
		//garbage collector 주로 힙 영역에서 활동
		
		
		
		
	}

}
