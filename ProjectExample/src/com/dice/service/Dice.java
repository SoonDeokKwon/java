package com.dice.service;

import java.util.Scanner;

public class Dice {

	//필드
	Scanner sc = new Scanner(System.in);
	int size = 0;
	int[] dice = null;
	String selectNo = null;
	
	// 내용 정리 -> 실행
	public Dice() {
		run();
	}

	private void run() {
		
		boolean run = true;

		while (run) {
			
			//메뉴
			menu();

			switch (selectNo) {
			case "1":
				diceSize();
				break;
			case "2":
				diceSetting();
				break;
			case "3":
				diceResult();
				break;
			case "4":
				diceMax();
				break;
			case "5":
				System.out.println("프로그램 종료");
				run = false;
			}
		}
	}
	
	//4번 기능
	private void diceMax() {
		int max = dice[0];
		int index = 0;
		for (int i = 0; i < dice.length; i++) {
			if (max < dice[i]) {
				max = dice[i];
				index = i;
			}
		}
		System.out.println("가장 많이 나온 수는 " + (index + 1) + "입니다.");
	}

	//3번 기능
	private void diceResult() {
		for (int i = 0; i < dice.length; i++) {
			System.out.println((i + 1) + "은 " + dice[i] + "번 나왔습니다.");
		}
	}

	//2번 기능
	private void diceSetting() {
		// 주사위 크기 설정
		// 5가 나올때 까지 반복문을 진행 -> while
		// 랜덤값을 활용해서 숫자를 뽑아낸다.
		// 5가 등장하면 반복문을 종료.
		dice = new int[size];
		// 총 주사위를 몇번 굴렸는지 확인.
		int count = 0;
		// 5가 나올때까지 반복하는 반복문
		while (true) {
			// 랜덤값 추출
			int random = (int) (Math.random() * size) + 1;
			System.out.println(random);
			// 각 숫자를 배열에 저장
			// 랜덤으로 나온 숫자 -> 배열에서 인덱스로 적용
			// 3 -> 배열에서 인덱스 2
			dice[random - 1] = dice[random - 1] + 1;
			count++;
			// 숫자 5가 등장하면 반복문 종료(숫자를 그만 가지고 나와야한다)
			if (random == 5) {
				break;
			}
		}
		System.out.println("5가 나올때 까지 주사위를 " + count + "번 굴렸습니다.");
	}

	//1번 기능
	private void diceSize() {
		System.out.println("주사위 크기 >");
		size = Integer.parseInt(sc.nextLine());
		// 7 -> 배열 크기(사이즈) = 7
		// 배열 입장 -> 0~6 -> 주사위 비유 -> 1~7
		// if문 활용 -> 경고창
		if (size < 5 || size > 10) {
			System.out.println("5~10 사이의 수를 입력하세요.");
		}
	}

	private void menu() {
		System.out.println("1. 주사위 크기 2. 주사위 굴리기 3. 결과 보기 4. 가장 많이 나온 수 5. 종료");
		System.out.println("메뉴 >");
		selectNo = sc.nextLine();
	}
}