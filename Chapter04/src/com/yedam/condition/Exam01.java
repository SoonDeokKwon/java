package com.yedam.condition;

import java.util.Scanner;

public class Exam01 {

	public static void main(String[] args) {
		//Math.random() -> 0<= Math.random() < 1    ....1~45
		//(int)Math.random() *45) +1
		//0<= Random <1
		//0<= Random <60
		//40<= Random <100
		
		int score = (int)(Math.random()*60)+40; //40~100
		
		if(score >= 50) {
			System.out.println("점수 : " + score);
		}else {
			System.out.println("낮은 점수 : " + score);
		}
		
		//삼항 연산자
		String str = (score >= 50)? "점수 : " + score : "낮은 점수 : " + score;
		System.out.println(str);
		
		
		//if ~ else
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("성적입력>");
		//입력한 문자열 변수에 저장
		String point = sc.nextLine();
		//문자열을  int형으로 형 변환 하는 과정
		int scores = Integer.parseInt(point);
		
		String pass = "";
		if(scores >=90) {
			pass ="A";
		}else if(scores >=80) {
			pass = "B";
		}else if(scores >=70) {
			pass = "C";
		}else {
			pass = "D";
		}
		
//		if(scores <=70) {
//			pass ="D";
//		}else if(scores <=80) {
//			pass = "C";
//		}else if(scores <=90) {
//			pass = "B";
//		}else {
//			pass = "A";
//		}
//		
		System.out.println("학점 : " + pass + "입니다.");
		
		//중첩 if문
		//if문 안에 if문 들어가는 형태
		//if문 안에 if문 안에 if문 ... 내가 원하는 만큼
		
		if(scores >= 90) {
			pass ="A";
		}else {
			if(scores >=80) {
				pass = "C";
			}else {
				if(scores >=70) {
					pass = "C";
				}else {
					pass = "D";
				}
			}
		}
		
		
		//주사위 번호 뽑기
		//1에서 6까지의 숫자를 랜덥으로 추출하여 그에 대한 결과를 출력
		//1) 랜덤 값
		//2) 조건문을 통한 출력값
		
		int num = (int)(Math.random()*6)+1;
		
		if(num == 1) {
			System.out.println("1번 등장");
		} else if(num == 2){
			System.out.println("2번 등장");
		} else if(num == 3){
			System.out.println("3번 등장");
		} else if(num == 4){
			System.out.println("4번 등장");
		} else if(num == 5){
			System.out.println("5번 등장");
		} else if(num == 6){
			System.out.println("6번 등장");
		}
		
		
		//switch문
		switch(num) {
		case 1: 
			System.out.println("스위치 1번");
			break;
		case 2:
			System.out.println("스위치 2번");
			break;
		case 3:
			System.out.println("스위치 3번");
			break;
		case 4:
			System.out.println("스위치 4번");
			break;
		case 5:
			System.out.println("스위치 5번");
			break;
		default:
			System.out.println("스위치 6번");
			break;
		}
		
		//int형이 아닌 char으로 switch
		char grade = 'B';
		switch(grade) {
		case 'A':
			System.out.println("훌륭함");
			break;
		case 'B':
			System.out.println("우수함");
			break;
		case 'C':
			System.out.println("노력필요");
			break;
		case 'D':
			System.out.println("분발필요");
			break;
		}
		
		//문자열을 활용한 switch문
		String position = "과장" ;
		
		switch(position) {
		case "부장":
			System.out.println("700만원");
			break;
		case "과장":	
			System.out.println("600만원");
			break;
		case "차장":	
			System.out.println("500만원");
			break;
		default:	
			System.out.println("300만원");
			break;
		}
		
		//break문이 없는 switch문
		int time = (int)(Math.random()*4)+ 8;
		System.out.println(time + "시간");
		
		switch(time) {
		case 8:
			System.out.println("출근을 합니다.");
		case 9:
			System.out.println("회의를 합니다.");
		case 10:
			System.out.println("업무를 합니다.");
		default:
			System.out.println("외근을 합니다.");
		}
		
		
		
		
		
		
		
		
		
		
		
	}

}
