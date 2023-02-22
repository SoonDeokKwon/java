package com.yedam.exe;

import java.util.Scanner;

import com.yedam.somoim.SomoimService;

public class ExeApp {
	
	SomoimService ss = new SomoimService();
	Scanner sc = new Scanner(System.in);
	
	String menu = "";
	boolean run = true;
	
	public ExeApp() {
		run();
	}
	
	private void run() {
		String menu = "";
		while(run) {
			if(SomoimService.somoimInfo != null) {
				loginMenu();
			}else if(SomoimService.somoimInfo == null){
				logoutMenu();
			}
		}
	}
	
	private void loginMenu() {
		System.out.println("=============================================================================================================");
		System.out.println("| 1. 새 회원 등록  |  2. 전체 회원 조회  |  3. 회원 조회  |  4. 이메일 변경  |  5. 소모임 인원 강제 탈퇴  |  6. 프로그램 종료 |");
		System.out.println("=============================================================================================================");
		System.out.println("입력>");
		menu = sc.nextLine();
		
		switch(menu){
		case "1":
			//새 회원 등록
			ss.insertMember();
			break;
		case "2":
			//전체 회원 조회
			ss.getMemberList();
			break;
		case "3":
			// 회원 조회
			ss.getMember();
			break;
		case "4":
			// 이메일 변경
			ss.updateEamil();
			break;
		case "5":
			//소모임 인원 강제 탈퇴
			ss.deleteMember();
			break;
		case "6":
			//프로그램 종료
			System.out.println("프로그램 종료");
			
			break;
		}
		
	}
	

	private void logoutMenu() {
		System.out.println("1. 로그인 | 2. 종료");
		System.out.println("입력>");
		menu = sc.nextLine();
		if (menu.equals("1")) {
			ss.login();
		} else if (menu.equals("2")) {
			run = false;
			System.out.println("프로그램 종료");
		}

	}
	
	
}
