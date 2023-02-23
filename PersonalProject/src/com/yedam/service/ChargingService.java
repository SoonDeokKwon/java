package com.yedam.service;

import java.util.List;
import java.util.Scanner;

public class ChargingService {
	
//	ChargingService cs = new ChargingService();
	Scanner sc = new Scanner(System.in);
	
	//빈자리 조회 
	public void emptyCheck() {
		
		List<ChargingStation>list = ChargingStationDAO.getInstance().emptyCheck();
		
		
	
		System.out.println("==========빈자리 조회==========");
		
		for(int i=0; i<list.size(); i++) {
			
			System.out.println(list.get(i).getLocationId());
//			switch(check) {
//				case "1":
//					//1번 자리 충전중
//					System.out.println("1번 충전중");
//					break;
//				case "2":
//					//2번 자리 충전중
//					System.out.println("2번 충전중");
//					break;
//				case "3":
//					//3번 자리 충전중
//					System.out.println("3번 충전중");
//					break;
//				case "4":
//					//4번 자리 충전중
//					System.out.println("4번 충전중");
//					break;
//				case "5":
//					//5번 자리 충전중
//					System.out.println("5번 충전중");
//					break;
//				case "6":
//					//6번 자리 충전중
//					System.out.println("6번 충전중");
//					break;
//				case "7":
//					//7번 자리 충전중
//					System.out.println("7번 충전중");
//					break;
//				case "8":
//					//8번 자리 충전중
//					System.out.println("8번");
//					break;
//				default:
//					System.out.println("충전중인 차량 없음");
//				}
			}

			
	}
	
	
	//충전 등록 
	public void regisCharging() {
		System.out.println("==============충전 등록================");
		System.out.println("충전할 자리 번호>");
		int locationNO = Integer.parseInt(sc.nextLine());
		System.out.println("차량 번호>");
		String carNo = sc.nextLine();
		System.out.println("충전 타입>");
		String chargType = sc.nextLine();
		System.out.println("배터리 잔량>");
		int batteryRemain = Integer.parseInt(sc.nextLine());
		
		ChargingStation charg = new ChargingStation();
		
		charg.setLocationId(locationNO);
		charg.setCarNo(carNo);
		charg.setChargType(chargType);
		charg.setBatterRemain(batteryRemain);
		
		int result = ChargingStationDAO.getInstance().regisCharging(charg);
		
		if(result > 0) {
			System.out.println("충전 등록 완료");
		}else {
			System.out.println("충전 등록 실패");
		}
				
	}
	
	
	
	//비회원 결제 
	public void payCharging() {
		System.out.println("충전 자리 번호>");
		int locationNo = Integer.parseInt(sc.nextLine());
	
		ChargingStation charg = ChargingStationDAO.getInstance().payCharging(locationNo);
		
		if(charg.getChargType().equals("완속")) {
			System.out.println("결제금액 : " + 100*(100-charg.getBatterRemain()));
		} else if(charg.getChargType().equals("급속")) {
			System.out.println("결제금액 : " + 200*(100-charg.getBatterRemain()));
		} else if(charg.getChargType().equals("초급속")) {
			System.out.println("결제금액 : " + 350*(100-charg.getBatterRemain()));
		}

		
	}
	
	
}
