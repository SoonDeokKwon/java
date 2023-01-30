package com.yedam.loof;

import java.util.Scanner;

public class DoWhileExample {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in); 
		//사용자가 입력한 월 출력
		int month;
		//최초 1회 실행한 후 조건을 비교
		do {
			System.out.println("올바른 월을 입력하시오[1~12]");
			month = sc.nextInt();
		} while(month <1 || month >12);
		System.out.println("사용자가 입력한 월은 " + month);
	}

}
