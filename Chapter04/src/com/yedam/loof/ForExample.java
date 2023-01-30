package com.yedam.loof;

public class ForExample {
	public static void main(String[] args) {
		
		//반복문
		//일정한 행동을 계속 반복
		//반복을 할 때 어떠한 규칙에 따라 행동을 반복
		//규칙 찾는 것이 중요.
		
		//1~5까지 누적 합
		int sum =0;
		
//		sum = sum + 1;
//		sum = sum + 2;
//		sum = sum + 3;
//		sum = sum + 4;
//		sum = sum + 5;		
		
		//for문
		for(int i = 1; i<=5; i++) {
			sum += 1;
		}		
		
		System.out.println("누적 합 : " + sum);
		
		
		//1~100 사이에서 짝수 구하는 반복문
		//1~100 -> 1~100까지 반복
		//2 % 2, , 4 % 2,, 6 % 2,,,
		for(int i = 1; i<=100; i++) {
			if(i % 2 == 0) {
				System.out.print(i + "\t");
			}
		}
		//1~100 사이에서 홀수 구하는 반복문
		//1~100 -> 1~100까지 반복
		// 1 2 3 4 5 6 7 8....
		// 1 3 5 7 9 11 13 15 .....
		// 1 % 2 == 1, 3 % 2 == 1,,,,,
		for(int i =1; i<=100; i++) {
			if(i % 2 == 1)
				System.out.print(i + "\t");
		}
		
		//1~100 사이에서 2의 배수 또는(OR) 3의 배수 찾기
		//2의 배수 => 어떤 값을 2로 나우었을 때 0인 숫자
		//3의 배수 => 어떤 값을 3로 나우었을 때 0인 숫자
		for(int i=1; i<=100; i++) {
			if(i % 2 == 0 || i % 3 == 0) {
				System.out.println("2 또는 3의 배수 : " + i);
			}
		}
		
		System.out.println("===================================");

		
		//구구단 출력하기
		for(int i = 1; i<10; i++) {
				System.out.println("2 X " + i + " = " + (2*i));
		}
		
		System.out.println("===================================");

		
		//중첩 for문
		//반복문 안에 반복문이 들어가는 형태
		//for(){
		//	for(){
		//		for{
		//		}
		//	}
		//}
		
		//2단 -> 2*1, 2*2, 2*3...
		//3단 -> 3*1, 3*2, 3*3...
		//4단 -> 4*1, 4*2, 4*3...
		
		//2단 ~ 9단까지 출력하는 반복문
		//i = 2~9
		for(int i=2; i<=9; i++) {
			//j= 1~9
			for(int j=1; j<=9; j++) {
				System.out.print(i +"X" + j + "=" + i*j + "\n");
			}
		}
		
		System.out.println("===================================");
		
		//구구단 세로 찍기
		//줄 주를 의미하는 for문
		for(int i=1; i<=9; i++) {
			//해당 줄 수 에서 한 칸씩 들어나느 for문
			for(int j=2; j<=5; j++) {
				System.out.print(j +"X" + i + "=" + j*i +"\t");
			}
			System.out.print("\n");
		}
		
		System.out.println("===================================");

		//공포의 별 찍기
		//*****
		//*****
		//*****
		//*****
		//*****
		
		//한 칸씩 내려 갈 때 쓰는 반복문
		for(int i=1; i<=5; i++) {
			//별 출력할 때 쓰는 반복문
			String star = "";
			for(int j=1; j<=5; j++) {
				//+ 연산자를 활용해서 ***** 만듦
				//star = star = "*"
				star += "*";
			}
			System.out.println(star);
		}
		System.out.println("===================================");

		
		//*
		//**
		//***
		//****
		//*****
		for(int i=1; i<=5; i++) {
			String star = "";
			for(int j=1; j<=i; j++) {
				star += "*";
			}
			System.out.println(star);
		}
		
		System.out.println("===================================");

		
		//*****
		//****
		//***
		//**
		//*
		for(int i=5; i>=1; i--) {
			String star = "";
			for(int j=1; j>0; j++) {
				star += "*";
			}
			System.out.println(star);
		}
		
		System.out.println("===================================");

		
		//    *
		//   **
		//  ***
		// ****
		//*****
		
		for(int i=5; i>0; i--) {
			for(int j=1; j<=5; j++) {
				if(i>j) {
					System.out.print(" ");
				}else {
					System.out.print("*");
				}
			}
			System.out.println();
		}
		
		
	
		
		
		
		
	}
}
