package com.yedam.service;

import java.util.Scanner;

public class ChargingService {
	
	ChargingService cs = new ChargingService();
	Scanner sc = new Scanner(System.in);
	
	//빈자리 조회 
	public void emptyCheck() {
		ChargingStation charg = null;
		System.out.println("==========빈자리 조회==========");
		System.out.println("자리 번호 입력>");
		int locationId = sc.nextLine();
		
		charg = ChargingStationDAO.getInstance().emptyCheck(locationId);
		
//		switch() {
//		case "1":
//			//1번 자리 충전중
//			
//			break;
//		case "2":
//			//2번 자리 충전중
//			
//			break;
//		case "3":
//			//3번 자리 충전중
//			
//			break;
//		case "4":
//			//4번 자리 충전중
//			
//			break;
//		case "5":
//			//5번 자리 충전중
//			
//			break;
//		case "6":
//			//6번 자리 충전중
//			
//			break;
//		case "7":
//			//7번 자리 충전중
//			
//			break;
//		case "8":
//			//8번 자리 충전중
//			
//			break;
//		}
	}
	
	
	//충전 등록 
	public void regisCharging() {
		
	}
	
	
	
	//비회원 결제 
	public void payCharging() {
		
	}
	
	
}
