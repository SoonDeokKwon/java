package com.yedam.array;

import java.util.Scanner;

public class Exam02 {

	public static void main(String[] args) {
		
		//array.length
		Scanner sc = new Scanner(System.in);
		
		int [] ary = new int[6];
		System.out.println("ary 배열 크기 : " + ary.length);
		
		
		int[] ary2;
		
		System.out.println("배열의 크기>");
		int no = Integer.parseInt(sc.nextLine());
		
		
		ary2 = new int[no];
		System.out.println("ary2 배열 크기 : " + ary2.length);
		
		for(int i=0; i < ary2.length; i++) {
			System.out.println("입력>");
			ary2[i] = Integer.parseInt(sc.nextLine());
		}
		
		//js -> forOf랑 비슷, java에서는 향상된 for문이라 함.
		for(int var : ary2) {
			System.out.println(var);
		}
		
		
		
	}

}
