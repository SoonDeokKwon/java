package com.yedam.service;

import java.util.List;
import java.util.Scanner;

public class ChargingService {
	
//	ChargingService cs = new ChargingService();
	Scanner sc = new Scanner(System.in);
	
	//빈자리 조회 
	public void emptyCheck() {
		List<ChargingStation>list = ChargingStationDAO.getInstance().emptyCheck();
		System.out.println("===============================사용중인 자리 조회===============================");
		System.out.print("현재 사용중인 자리는 ");
		for(int i=0; i<list.size(); i++) {
			
			System.out.print(list.get(i).getLocationId() + "번 ");

			}
		System.out.println("입니다!");
			
	}
	
	
	//비회원 충전 등록 
	public void regisCharging() {
		System.out.println("======================충전 등록========================");
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

		if(result == 2) {
			System.out.println("해당 자리에는 충전 중인 차량이 있습니다.");
		}else if(result == 1) {
			System.out.println("충전 등록 완료");
		}else {
			System.out.println("충전 등록 실패");
		}
		
	}
	
	
	//회원용 충전 등록 
	public void memRegisCharging() {
		System.out.println("==============충전 등록================");
		System.out.println("충전할 자리 번호>");
		int locationNO = Integer.parseInt(sc.nextLine());
		System.out.println("충전 타입>");
		String chargType = sc.nextLine();
		System.out.println("배터리 잔량>");
		int batteryRemain = Integer.parseInt(sc.nextLine());
		
		String carNo = MemberService.memberInfo.getCarNo();
		ChargingStation charg = new ChargingStation();
		
		charg.setLocationId(locationNO);
		charg.setCarNo(carNo);
		charg.setChargType(chargType);
		charg.setBatterRemain(batteryRemain);
		
		int result = ChargingStationDAO.getInstance().regisCharging(charg);
		int except = MemberService.memberInfo.getNoiceScore();
		
		if(except < 0) {
			System.out.println("무분별한 게시판 및 충전소 이용으로 인해서 할인 적용 대상에서 제외되었습니다.");
			System.out.println("게시판 점수가 0점 미만인 회원은 매달 일괄 0점으로 변경되므로 다음달부터 할인 적용을 받으실 수 있습니다.");
			
			if(result == 2) {
				System.out.println("해당 자리에는 충전 중인 차량이 있습니다.");
			}else if(result == 1) {
				System.out.println("충전 등록 완료");
			}else {
				System.out.println("충전 등록 실패");
			}
		}
		
				
	}
	
	
	//비회원 결제 
	public void payCharging() {
		System.out.println("충전 자리 번호>");
		int locationNo = Integer.parseInt(sc.nextLine());
	
		ChargingStation charg = ChargingStationDAO.getInstance().payCharging(locationNo);
		
		if(charg.getChargType().equals("완속")) {
			System.out.println("결제금액 : " + 100*(100-charg.getBatterRemain()) + "원");
		} else if(charg.getChargType().equals("급속")) {
			System.out.println("결제금액 : " + 200*(100-charg.getBatterRemain()) + "원");
		} else if(charg.getChargType().equals("초급속")) {
			System.out.println("결제금액 : " + 350*(100-charg.getBatterRemain()) + "원");
		}		
	}
	
	
	
	//회원 결제
	public void memPayCharging() {
		System.out.println("충전 결제를 도와드리겠습니다. 충전하신 자리의 번호를 입력해주세요.");
		System.out.println("충전 자리 번호>");
		int locationNo = Integer.parseInt(sc.nextLine());
	
		ChargingStation charg = ChargingStationDAO.getInstance().payCharging(locationNo);
		double d = MemberService.memberInfo.getMemberDisc();
		
		if(charg.getChargType().equals("완속")) {
			System.out.println("결제금액 : " + 100*(100-charg.getBatterRemain())*(1-d) + "원" );
		} else if(charg.getChargType().equals("급속")) {
			System.out.println("결제금액 : " + 200*(100-charg.getBatterRemain())*(1-d) + "원");
		} else if(charg.getChargType().equals("초급속")) {
			System.out.println("결제금액 : " + 350*(100-charg.getBatterRemain())*(1-d) + "원");
		}		
	}
	
	
	//충전 등록 해제
	public void deletCharging () {
		System.out.println("충전 등록 해제를 도와드리겠습니다. 충전하신 자리의 번호를 입력해주세요.");
		System.out.println("충전 자리 번호>");
		int result = ChargingStationDAO.getInstance().deletCharging(Integer.parseInt(sc.nextLine()));
		
		if(result > 0) {
			System.out.println("충전 등록이 해제되었습니다.");
		}else {
			System.out.println("충전 등록 해제에 실패했습니다.");
		}
		
	}
	
	
	
	
}
