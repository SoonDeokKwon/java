package com.yedam.exe;

import java.util.Scanner;

import com.yedam.service.ChargingService;
import com.yedam.service.MemberService;

public class ExeApp {
	
	MemberService ms = new MemberService();
	ChargingService cs = new ChargingService();
	Scanner sc = new Scanner(System.in);
	
	String menu = "";
	boolean run = true;
	
	public ExeApp() { 
		run();
	}
	
	
	private void run() {

		while(run) {
			if(MemberService.memberInfo != null) {
				//로그인 메뉴
				if(MemberService.host == 1) {
					adminmenu();
				}else if(MemberService.host == 2) {
					loginMenu();		
				}
			}else if(MemberService.memberInfo == null) {
				//로그아웃 메뉴
				logoutMenu();
			}
		}
	}
	
	
	public void loginMenu() {
		//내 정보 전체 조회 | 게시판 점수 조회 | 비밀번호 수정 | 차량번호 수정
		System.out.println("====================================================================");
		System.out.println("| 1. 회원 정보 | 2. 전기차 충전(회원) | 3. 게시판 | 4. 쪽지함 | 5. 로그아웃 |");
		System.out.println("====================================================================");
		System.out.println("입력>");
		menu = sc.nextLine();
		
		switch(menu) {
		case "1":
			//회원 정보
			memberInfo();
			break;
		case "2":
			//전기차 충전(회원)
			memberChargingMenu();
			loginMenu();
			break;
		case "3":
			//게시판
			
			break;
		case "4":
			//쪽지함
			
			break;
		case "5":
			//로그아웃
			logoutMenu();
			break;
		}
		
	}
	
	public void memberInfo() {
		System.out.println("==========================================================================================================");
		System.out.println("| 1. 회원 정보 조회 | 2. 게시판 점수 조회 | 3. 비밀번호 수정 | 4. 차량번호 수정 | 5. 회원 탈퇴 |  7. 로그인 메인 메뉴  |");
		System.out.println("==========================================================================================================");
		System.out.println("입력>");
		menu = sc.nextLine();
		
		switch(menu) {
		case "1":
			//회원 정보 조회
			ms.getMember();
			memberInfo();
			break;
		case "2":
			//회원 게시판 점수 조회
			
			break;
		case "3":
			//비밀번호 수정
			ms.modifyMember1();
			memberInfo();
			break;
		case "4":
			//차량정보 수정
			ms.modifyMember2();
			memberInfo();
			break;
		case "5":
			//회원 탈퇴
			ms.deleteMember();
			memberInfo();
			break;
		case "6":
			//로그인 메인 메뉴
			logoutMenu();
			break;
		}
		
	}
	
	
	public void adminmenu() {
		System.out.println("======================================================================================================");
		System.out.println("| 1. 전체 회원 조회 | 2. 게시판 점수 조회 | 3. 할인 제외 회원 조회 | 4. 쪽지 보내기 | 5. 회원 강제 탈퇴 | 6. 로그아웃 |  ");
		System.out.println("======================================================================================================");
		System.out.println("입력>");
		menu = sc.nextLine();
		
		switch(menu) {
		case "1":
			//전체 회원 조회
			ms.getMemberList();
			adminmenu();
			break;
		case "2":
			//전체 회원 게시판 점수 조회
			ms.getNoticeScore();
			adminmenu();
			break;
		case "3":
			//할인 제외 회원 조회
			ms.exceptDiscount();
			adminmenu();
			break;
		case "4":
			//쪽지 보내기
			
			break;
		case "5":
			//회원 강제 탈퇴
			ms.deleteMember();
			adminmenu();
			break;
		case "6":
			//로그아웃
			logoutMenu();
			break;
		}
		
	}

	
	public void logoutMenu() {
		//| 1. 로그인 | 2.회원가입 | 3.전기차 충전 |
		System.out.println("| 1. 로그인 | 2.회원가입 | 3.전기차 충전(비회원) | 4. 프로그램 종료 |");
		System.out.println("입력>");
		menu = sc.nextLine();
		
		switch(menu) {
		case "1":
			//회원 정보 조회
			ms.loginAdmin();
			break;
		case "2":
			//회원 가입
			ms.insertMember();
			break;
		case "3":
			//충전
			chargingMenu();
			break;
		case "4":
			//종료
			run = false;
			System.out.println("프로그램 종료");
			break;
		}
	}
	
	
	public void chargingMenu() {
		System.out.println("============================================================");
		System.out.println("| 1. 빈자리 조회 | 2. 충전 등록 | 3. 결제 및 등록해제 | 4. 초기화면 |");
		System.out.println("============================================================");
		System.out.println("입력>");
		menu = sc.nextLine();
		
		switch(menu) {
		case "1":
			//빈자리 조회
			cs.emptyCheck();
			break;
		case "2":
			//충전 등록
			cs.regisCharging();
			break;
		case "3":
			//결제
			cs.payCharging();
			cs.deletCharging();
			chargingMenu();
			break;
		case "4":
			//초기화면
			logoutMenu();
			break;
		}
	}
	
	
	
	public void memberChargingMenu() {
		System.out.println("============================================================");
		System.out.println("| 1. 빈자리 조회 | 2. 충전 등록 | 3. 결제 및 등록해제 | 4. 초기화면 |");
		System.out.println("============================================================");
		System.out.println("입력>");
		menu = sc.nextLine();
		
		switch(menu) {
		case "1":
			//빈자리 조회
			cs.emptyCheck();
			break;
		case "2":
			//회원용 충전 등록
			cs.memRegisCharging();
			memberChargingMenu();
			break;
		case "3":
			//회원용 결제 및 등록해제
			cs.memPayCharging();
			cs.deletCharging();
			memberChargingMenu();
			break;
		case "4":
			//초기화면
			logoutMenu();
			break;
		}
	}
	
	public void chargingClear() {
		System.out.println("====================================================");
		System.out.println("| 1. 빈자리 조회 | 2. 충전 등록 | 3. 등록해제 | 4. 초기화면 |");
		System.out.println("====================================================");
		System.out.println("입력>");
		menu = sc.nextLine();
	}
	
	
}
