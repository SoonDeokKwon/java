package com.yedam.somoim;

import java.util.Scanner;
import java.util.List;

public class SomoimService {
	//member의 정보를 자바 전역에 공유하기 위해서 static
	//1. memberInfo -> null이 아니다. null이다.
	//null -> O 로그인이 안된 상태
	//null -> x 로그인이 되어 있는 상태
	
	public static Somoim somoimInfo = null;
	Scanner sc = new Scanner(System.in);
	
	//로그인
	public void login() {
		Somoim somo = null;
		System.out.println("ID>");
		String memberID = sc.nextLine();
		
		somo = SomoimDAO.getInstance().login(memberID);
		
		if(somo != null) {
			System.out.println("정상 로그인 되었습니다.");
			System.out.println(somo.getMemberId() + "님 환영합니다!🎉🎉");
		}else {
			System.out.println("관리자 아이디가 아닙니다.");
		}
		
	}
	
	//새 회원 등록
	public void insertMember() {
		System.out.println("회원 ID>");
		String memID = sc.nextLine();
		
		Somoim somo = new Somoim();
		somo.setMemberId(memID);
		
		int result = SomoimDAO.getInstance().insertMember(somo);
		
		if(result > 0) {
			System.out.println("회원 ID 등록 완료");
		}else {
			System.out.println("회원 ID 등록 실패");
		}
		
	}
	
	//모든 회원 조회 -> 가입 날자 순서대로 조회
	public void getMemberList() {
		List<Somoim> list = SomoimDAO.getInstance().getMemberList();
		System.out.println("==========================================");
		
		for(int i=0; i < list.size(); i++) {
			System.out.println("회원 ID : " + list.get(i).getMemberId());
			System.out.println("회원 이름 : " + list.get(i).getMemberName());
			System.out.println("가입 날짜 : " + list.get(i).getJoinDate());
			System.out.println("회원 이메일 : " + list.get(i).getEmail());
			System.out.println("회원 나이 : " + list.get(i).getMemberAge());
		}
		
	}
	
	//아이디로 회원 조회
	public void getMember() {
		Somoim somo = SomoimDAO.getInstance().getMember();
		System.out.println(somo.toString());
	}
	
	//이메일 변경
	public void updateEamil() {
		Somoim somo = new Somoim();
		System.out.println("회원 ID>");
		somo.setMemberId(sc.nextLine());
		System.out.println("Email 변경사항>");
		somo.setEmail(sc.nextLine());
		
		int result= SomoimDAO.getInstance().updateEmail(somo);
		
		if(result > 0) {
			System.out.println("Email 수정 완료");
		}else {
			System.out.println("Email 수정 실패");
		}
		
	}
	
	//소모임 인원 강제 탈퇴
	public void deleteMember() {
		System.out.println("회원 ID>");
		int result = SomoimDAO.getInstance().deleteMember(sc.nextLine());
		
		if(result > 0) {
			System.out.println("회원 강제 탈퇴 완료");
		}else {
			System.out.println("회원 강제 탈퇴 완료");
		}
		
	}
	

	
}
