package com.yedam.array;

import java.util.Scanner;

public class Exam03 {

	public static void main(String[] args) {
		
		//한 학생의 국영수 성적을 보관하는 배열
		Scanner sc = new Scanner(System.in);
		//배열 생성
		int[] point = new int[3];
		
		//첫번째 : 국어
		System.out.println("국어점수>");
		point[0] = Integer.parseInt(sc.nextLine());
		//두번째 : 영어
		System.out.println("영어점수>");
		point[1] = Integer.parseInt(sc.nextLine());
		//세번째 : 수학
		System.out.println("수학점수>");
		point[2] = Integer.parseInt(sc.nextLine());
		
		//점수의 총 합계
		int sum = 0;
		for(int i = 0; i < point.length; i++) {
			sum += point[i];
		}
		
		//향상된 for문
		//for(int var : point) {
		//	sum += var;
		//}
		
		System.out.println("점수의 총 합계 : " + sum);
		
		//점수의 평균(실수)
		double avg = 0;
		avg = (double) sum /point.length;
		System.out.println("점수의 평균 : " + avg);
		System.out.printf("점수의 평균 : %1.2f", avg);
		System.out.println();
		
		//최대값 구하기
		int max = 0;
		for(int i=0; i < point.length; i++) {
			if(point[i]> max) {
				max = point[i];
			}
		}
		System.out.println( "최대값 : " + max);
		
		//최소값 구하기
		int min = point[0];
		for(int i=0; i < point.length; i++) {
			if(point[i]<min) {
				min = point[i];
			}
		}
		System.out.println("최소값 : " + min);
		
	
		
	}

}
