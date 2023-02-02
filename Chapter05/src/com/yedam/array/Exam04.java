package com.yedam.array;

import java.util.Scanner;

public class Exam04 {

	public static void main(String[] args) {
		
		boolean run =true;
		int studentNum = 0;
			int [] scores = null;
		Scanner scanner = new Scanner(System.in);
		
		while(run) {
			System.out.println("-----------------------------------------------");
			System.out.println("1.학생수 | 2.점수입력 | 3.점수 리스트 | 4.분석 | 5.종료");
			System.out.println("-----------------------------------------------");
			System.out.print("선택> ");
			int selectNo = Integer.parseInt(scanner.nextLine());
			
			if(selectNo == 1) {	
				studentNum = Integer.parseInt(scanner.nextLine());
				scores = new int [studentNum];
				System.out.print("학생수> ");
				System.out.println(scores.length);
			} else if(selectNo == 2) {
				//1번 메유를 변경하고 싶을 때 혹시나 상황을 대비해서
//				scores = new int[studentNum];
				
				for(int i =0; i < scores.length; i++) {
					System.out.print("scores[" + i +"]>");
					scores[i] = Integer.parseInt(scanner.nextLine());
				}
			} else if(selectNo == 3) {
				for(int i =0; i < scores.length; i++) {
					System.out.println("scores[" + i +"]>" + scores[i]);
				}
			} else if(selectNo == 4) {
				int max = scores[0];
				for(int i =0; i < scores.length; i++) {
					if(scores[i] > max) {
						max = scores[i];
					}
				}
				System.out.println("최고 점수:" + max);
				int sum = 0;
				double avg = 0;
				for(int i =0; i < scores.length; i++) {
						sum += scores[i];
				}
				avg = (double) sum / scores.length ;
				System.out.println("평균 점수:" + avg);
			} else if(selectNo == 5) {
				run = false;
			}
			
		}
		
		System.out.println("프로그램 종료");
		
		
	}

}
