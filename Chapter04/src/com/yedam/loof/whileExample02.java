package com.yedam.loof;

import java.util.Scanner;

public class whileExample02 {

	public static void main(String[] args) {
		
		//오락실
		//투입한 구입만큼 반복문을 진행
		//while문
		//투입한 금액 대비 게임을 몇 번 할 수 있을까?
		//예시) 10,000ㅇ -> 20번, 5,000 -> 10번
		
		int money;
		System.out.println("====insert Coin====");
		Scanner sc = new Scanner(System.in);
		money = Integer.parseInt(sc.nextLine());
		
		//money/500 > 0  vs  money > 0
		
		while(money/500 > 0) {
			//한판에 500원
			System.out.println((money/500) + "판 남음.");
			System.out.println("1. 가위바위보 | 2. Up & Down | 3. 종료");
			//야구 게임(4개의 무작위 번호 맞추기), 베스킨 등등...
			
			System.out.println("입력>");
			int gameNo = Integer.parseInt(sc.nextLine());
			
			switch(gameNo) {
			case 1:
				System.out.println("가위바위보 실행~");
				money -= 500;
				break;
			case 2: 
				System.out.println("Up & Down 실행~");
				money -= 500;
				break;
			case 3:
				System.out.println("종료~");
				money=0; //money/500 >0
				break;
			}
			
		}
		
		
		
	}

}
