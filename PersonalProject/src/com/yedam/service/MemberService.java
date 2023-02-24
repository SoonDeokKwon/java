package com.yedam.service;

import java.util.List;
import java.util.Scanner;

public class MemberService {

	public static Member memberInfo = null;
	public static int host = 0;
	
	Scanner sc = new Scanner(System.in);
	
	
	//로그인
	public void loginAdmin() {
		Member mem = null;
		System.out.println("====================로그인======================");
		System.out.println("ID 입력>");
		String memberID = sc.nextLine();
		System.out.println("PW 입력>");
		String memberPW = sc.nextLine();
		
		mem = MemberDAO.getInstance().login(memberID);
		
		if(mem != null) {
			if(mem.getMemberPw().equals(memberPW)) {
				
				if(mem.getMemberId().equals("admin01")) {
					System.out.println("관리자로 정상 로그인 되었습니다.");
					memberInfo = mem;		
					host = 1;
					System.out.println(memberInfo.getMemberName() + "님 환영합니다!✨✨");
				}else{
					System.out.println("정상 로그인 되었습니다.");
					memberInfo = mem;	
					host = 2;
					System.out.println(memberInfo.getMemberName() + "님 환영합니다!✨✨");
				}
			}else {
				System.out.println("비밀번호가 틀립니다.");
			}
		}else {
			System.out.println("해당 아이디가 존재하지 않습니다.");
		}
	}
	
	//전체 회원 조회
	public void getMemberList() {
		List<Member> list = MemberDAO.getInstance().getMemberList();

		for(int i=0; i<list.size(); i++) {
			System.out.println("===============================================");
			System.out.println("회원 ID : " + list.get(i).getMemberId());
			System.out.println("회원 PW : " + list.get(i).getMemberPw());
			System.out.println("회원이름 : " + list.get(i).getMemberName());
			System.out.println("차량번호 : " + list.get(i).getCarNo());
			System.out.println("회원 할인율 : " + list.get(i).getMemberDisc());
			System.out.println("회원 게시판 점수 : " + list.get(i).getNoiceScore());
			System.out.println("===============================================");
		}
	}
	
	
	//전체 회원 게시판 점수 조회
	public void getNoticeScore() {
		List<Member> list = MemberDAO.getInstance().getNoticeScore();
		for(int i=0; i<list.size();i++) {
			System.out.println("===============================================");
			System.out.println("회원 이름 : " + list.get(i).getMemberName());
			System.out.println("회원 ID" + list.get(i).getMemberId());
			System.out.println("게시판 점수 : " + list.get(i).getNoiceScore());
			System.out.println("===============================================");
		}
	}
	
	
	//회원정보 조회
	public void getMember() {
		Member mem = MemberDAO.getInstance().getMember();
		System.out.println("회원 ID : " + mem.getMemberId());
		System.out.println("회원 PW : " + mem.getMemberPw());
		System.out.println("회원이름 : " + mem.getMemberName());
		System.out.println("차량번호 : " + mem.getCarNo());
		System.out.println("회원 할인율 : " + mem.getMemberDisc());
		System.out.println("회원 게시판 점수 : " + mem.getNoiceScore());
	}
	
	
	//회원 등록
	public void insertMember() {
		Member mem = new Member();
		System.out.println("=========================================");

		System.out.println("회원 ID>");
		mem.setMemberId(sc.nextLine());
		System.out.println("회원 PW>");
		mem.setMemberPw(sc.nextLine());
		System.out.println("회원 이름>");
		mem.setMemberName(sc.nextLine());
		System.out.println("차량 번호>");
		mem.setCarNo(sc.nextLine());
		
		int result = MemberDAO.getInstance().doubleCheck(mem);

			if(result==2) {
					System.out.println("중복된 아이디입니다.");
					insertMember();
			}else if(result==1) {
					System.out.println("회원 가입 완료");
					
			}else {
				System.out.println("회원 가입 실패");
			}
	}
	
	
	
	//비밀번호 정보 수정
	public void modifyMember1() {
		Member mem = new Member();
		
		System.out.println("수정할 비밀번호>");
		mem.setMemberPw(sc.nextLine());
		System.out.println("ID>");
		mem.setMemberId(sc.nextLine());
		
		int result = MemberDAO.getInstance().modifyMember1(mem);
		
		if(result > 0) {
			System.out.println("회원 정보 수정 완료");
		}else {
			System.out.println("회원 정보 수정 실패");
		}		
	}
	
	
	//차량번호 정보 수정
	public void modifyMember2() {
		Member mem = new Member();
		
		
		System.out.println("수정할 차량 번호>");
		mem.setCarNo(sc.nextLine());
		mem.setMemberId(MemberService.memberInfo.getMemberId());
		
		int result = MemberDAO.getInstance().modifyMember2(mem);
		
		if(result > 0) {
			System.out.println("회원 정보 수정 완료");
		}else {
			System.out.println("회원 정보 수정 실패");
		}	
	}
	
	
	//회원 정보 삭제
	public void deleteMember() {
		System.out.println("회원 ID>");
		int result = MemberDAO.getInstance().deleteMember(sc.nextLine());
		
		if(result > 0) {
			System.out.println("회원 ID 삭제 완료");
		} else {
			System.out.println("회원 ID 삭제 실패");
		}
	}
	
	
	
	//할인 제외 회원 조회
	public void exceptDiscount() {
		List<Member> list = MemberDAO.getInstance().exceptDiscount();
		for(int i = 0; i < list.size(); i++) {
			System.out.println("===============================================");
			System.out.println("회원 이름 : " + list.get(i).getMemberName());
			System.out.println("회원 ID : " + list.get(i).getMemberId());
			System.out.println("게시판 점수 : " + list.get(i).getNoiceScore());
			System.out.println("===============================================");
			
		}
	}
	
	
	

}
