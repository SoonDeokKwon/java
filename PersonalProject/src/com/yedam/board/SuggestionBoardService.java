package com.yedam.board;

import java.util.List;
import java.util.Scanner;

import com.yedam.service.MemberService;

public class SuggestionBoardService {
	
	public static SuggestionBoard suggestInfo = null;
	
	Scanner sc = new Scanner(System.in);
	
	
	//게시 제목 페이지
	public void listSuggestBoard() {
		List<SuggestionBoard> list = SuggestionBoardDAO.getInstance().listSuggestBoard();
		
		for(int i =0; i < list.size(); i++) {
			System.out.println("============================================================");
			System.out.println(list.get(i).getSugBoardId() + list.get(i).getSugSubject());
			
			
			
			
		}
	}
	
	
	//게시 내용 보기
	public void viewSuggestBoard() {
		SuggestionBoard sug = new SuggestionBoard();
		System.out.println("==========================================================");
		
		System.out.println("열람할 게시글의 게시번호 입력>");
		sug.setSugBoardId(Integer.parseInt(sc.nextLine()));
		
		sug = SuggestionBoardDAO.getInstance().viewSuggestBoard();
		
		System.out.println("게시번호 : " + sug.getSugBoardId());
		System.out.println("회원 ID : " + sug.getMemberId());
		System.out.println("회원 이름 : " + sug.getMemberName());
		System.out.println("제목 : " + sug.getSugSubject());
		System.out.println(sug.getSugContents());
		System.out.println();
		
	}
	
	
	//게시글 작성
	public void insertSuggestion() {
		SuggestionBoard sug = new SuggestionBoard();
		System.out.println("==========================================================");
		
		System.out.println("제목 입력>");
		sug.setSugSubject(sc.nextLine());
		System.out.println("내용 입력>");
		sug.setSugContents(sc.nextLine());
		sug.setMemberId(MemberService.memberInfo.getMemberId());
		sug.setMemberName(MemberService.memberInfo.getMemberName());
		
		int result = SuggestionBoardDAO.getInstance().insertSuggestion(sug);
		
		if(result>0) {
			System.out.println("글쓰기 등록 완료");
		}else {
			System.out.println("글쓰기 등록 실패");
		}
		
	}
	
	
	//관리자용 게시글 수정
	public void adminUpdateSuggest() {
		
	}
	
	
	//회원용 게시글 수정
	public void memUpdateSuggest() {
		
	}
	
	
	//관리자용 게시글 삭제
	public void adminDeleteSuggest() {
		
	}
	
	
	//회원용 게시글 삭제
	public void memDeleteSuggest() {
		
	}
	
	
	
}
