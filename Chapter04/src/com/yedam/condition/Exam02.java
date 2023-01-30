package com.yedam.condition;

import java.util.Scanner;

public class Exam02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("성적입력>");
		//입력한 문자열 변수에 저장
		String point = sc.nextLine();
		//문자열을  int형으로 형 변환 하는 과정
		int scores = Integer.parseInt(point);
		
		String pass = "";
		//1단계
		//90 이상은 A
		//89~80 B
		//79~70 C
		//69~60 D
		
		//2단계
		//100점도 A학점을 받을 수 있게끔 추가 -> 한줄만
		
		//switch문 부등호 사용 못함.
		//효율적으로 코딩(-> 1~100 해당되는 case문 만들지 말라)
		
		//       /(나누기 연산자)
		// 99~90 / 10 = 9
		// 89~80 / 10 = 8
		switch(scores/10) {
		case 10: 
		case 9:
			pass ="A";
			break;
		case 8: 
			pass = "B";
			break;
		case 7: 
			pass = "C";
			break;
		default:
			pass = "D";
			break;
		}
		System.out.println(pass);
		
		
	}

}
