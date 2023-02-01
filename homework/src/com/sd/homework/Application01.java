package com.sd.homework;

import java.util.Scanner;

public class Application01 {
	public static void main(String[] args) {
		// 문제1) 다음은 키보드로부터 상품 수와 상품 가격을 입력받아서
		// 최고 가격을 가지는 제품과 해당 제품을 제외한 제품들의 총 합을 구하는 프로그램을 작성하세요.
		// 1) 메뉴는 다음과 같이 구성하세요.
		// 1.상품 수 | 2.상품 및 가격입력 | 3.제품별 가격 | 4.분석 | 5.종료
		// 2) 입력한 상품 수만큼 상품명과 해당 가격을 입력받을 수 있도록 구현하세요.
		// 3) 제품별 가격을 출력하세요.
		//	출력예시, "상품명 : 가격"
		// 4) 분석기능은 최고 가격을 가지는 제품과 해당 제품을 제외한 제품들의 총합을 구합니다.
		// 5) 종료 시에는 프로그램을 종료한다고 메세지를 출력하도록 구현하세요.
		
		
		
		// 1) 메뉴는 다음과 같이 구성하세요.
		//제품 수 입력 받는 용도
		Scanner sc = new Scanner(System.in);
		
		//제품 정보 입력받는 변수
		int pdutCount = 0;
		
		//제품의 정보를 보관하는 배열 생성
		Product [] pductArr = null;
		
		// 1.상품 수 | 2.상품 및 가격입력 | 3.제품별 가격 | 4.분석 | 5.종료
		while (true) {
			System.out.println("1.상품 수 | 2.상품 및 가격입력 | 3.제품별 가격 | 4.분석 | 5.종료");
			System.out.println("입력>");
			
			int selectNo = Integer.parseInt(sc.nextLine());
			
			// 2) 입력한 상품 수만큼 상품명과 해당 가격을 입력받을 수 있도록 구현하세요.
			if(selectNo == 1) {
				System.out.println("상품 수 입력>");
				pdutCount = Integer.parseInt(sc.nextLine());								
			} else if(selectNo == 2) {
				//배열의 크기(제품 데이터를 넣을 수 있는 크기 설정)
				pductArr = new Product[pdutCount];
				for(int i=0; i < pductArr.length; i++) {
					pductArr[i] = new Product();
					
					System.out.println("제품명>");
					String productName = sc.nextLine();
					pductArr[i].productName = productName;
					
					System.out.println("가격>");
					int price = Integer.parseInt(sc.nextLine());
					pductArr[i].price = price;
				}
				
			// 3) 제품별 가격을 출력하세요.
			//	출력예시, "상품명 : 가격"
			} else if(selectNo == 3) {
				for(int i=0; i < pductArr.length; i++) {
					System.out.println(pductArr[i].productName + " : " + pductArr[i].price + "원");
				}
			// 4) 분석기능은 최고 가격을 가지는 제품과 해당 제품을 제외한 제품들의 총합을 구합니다.
			} else if(selectNo == 4) {
				int maxPrice = pductArr[0].price;
				String maxProduct = pductArr[0].productName;
				for(int i=0; i < pductArr.length; i++) {
					if(pductArr[i].price > maxPrice) {
						maxPrice = pductArr[i].price;
						maxProduct = pductArr[i].productName;
					}
				}
				int sumPrice = 0;
				for(int i=0; i < pductArr.length; i++) {
					sumPrice += pductArr[i].price;
				}
				System.out.println("최고 가격 제품 : " + maxProduct);
				System.out.println("최고 가격 제품을 제외한 제품들의 가격 총합 : " + sumPrice + "원");
				
			// 5) 종료 시에는 프로그램을 종료한다고 메세지를 출력하도록 구현하세요.	
			} else if(selectNo == 5) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
			
			
		}
		
		
		
		
		
		
		
		
		
		
		
	}
}
