package com.yedam.sugboard;

import java.util.List;
import java.util.Scanner;

import com.yedam.service.MemberService;

public class SuggestionBoardService {
	
	public static SuggestionBoard suggestInfo = null;
	public static int inputNo = 0;
	private static int page = 1;
	private static int totalpage = 0;
	
	Scanner sc = new Scanner(System.in);
	
	
	//게시 제목 페이지
	public void listSuggestBoard() {
		List<SuggestionBoard> list = SuggestionBoardDAO.getInstance().listSuggestBoard();
		
		
		for(int i =0; i < list.size(); i++) {
			
			
			System.out.println("============================================================");
			System.out.println(list.get(i).getSugBoardId() + "번 \t" + "작성자:" + list.get(i).getMemberName() + "\t" + list.get(i).getSugSubject() );

			
		}
	}
	
	
	//게시글 내용 보기
	public void viewSuggestBoard() {	
		System.out.println("열람할 게시글의 게시번호 입력>");
		inputNo = Integer.parseInt(sc.nextLine());
		SuggestionBoard sug = SuggestionBoardDAO.getInstance().viewSuggestBoard(inputNo);
		
		System.out.println("───────────────────────────────────────────────────────────────────────");
		System.out.print("게시번호 : " + sug.getSugBoardId() + "\t");
		System.out.print("ID : " + sug.getMemberId() + "\t");
		System.out.print("이름 : " + sug.getMemberName() + "\t");
		System.out.println("작성 날짜 : " + sug.getSugDate());
		System.out.println("제목 : " + sug.getSugSubject());
		System.out.println(sug.getSugContents());
		System.out.println("───────────────────────────────────────────────────────────────────────");

	}
	
	public void viewSuggestBoard2() {	
		
		SuggestionBoard sug = SuggestionBoardDAO.getInstance().viewSuggestBoard(inputNo);
		
		System.out.println("───────────────────────────────────────────────────────────────────────");
		System.out.print("게시번호 : " + sug.getSugBoardId() + "\t");
		System.out.print("회원 ID : " + sug.getMemberId() + "\t");
		System.out.print("회원 이름 : " + sug.getMemberName() + "\t");
		System.out.println("작성 날짜 : " + sug.getSugDate());
		System.out.println("제목 : " + sug.getSugSubject());
		System.out.println(sug.getSugContents());
		System.out.println("───────────────────────────────────────────────────────────────────────");

	}
	
	
	//게시글 작성
	public void insertSuggestion() {
		SuggestionBoard sug = new SuggestionBoard();
		System.out.println("==========================================================");
		sug.setMemberId(MemberService.memberInfo.getMemberId());
		sug.setMemberName(MemberService.memberInfo.getMemberName());
		System.out.println("제목 입력>");
		sug.setSugSubject(sc.nextLine());
		System.out.println("내용 입력>");
		sug.setSugContents(sc.nextLine());

		
		int result = SuggestionBoardDAO.getInstance().insertSuggestion(sug);
		
		if(result>0) {
			System.out.println("글쓰기 등록 완료");
		}else {
			System.out.println("글쓰기 등록 실패");
		}
		
	}
	
	
	//관리자용 게시글 수정
	public void adminUpdateSuggest() {
		SuggestionBoard sug = new SuggestionBoard();
		System.out.println("수정할 게시글 번호 입력>");
		sug.setSugBoardId(Integer.parseInt(sc.nextLine()));
		System.out.println("제목 입력>");
		sug.setSugSubject(sc.nextLine());
		System.out.println("내용 입력>");
		sug.setSugContents(sc.nextLine());
		
		int result = SuggestionBoardDAO.getInstance().adminUpdateSuggest(sug);
		if(result > 0) {
			System.out.println("게시글 수정 완료");
		}else {
			System.out.println("게시글 수정 실패");
		}
		
	}
	
	
	//회원용 게시글 수정
	public void memUpdateSuggest() {
		SuggestionBoard sug = new SuggestionBoard();
		sug.setMemberId(MemberService.memberInfo.getMemberId());
		sug.setSugBoardId(inputNo);
		System.out.println("제목 입력>");
		sug.setSugSubject(sc.nextLine());
		System.out.println("내용 입력>");
		sug.setSugContents(sc.nextLine());
		
		int result = SuggestionBoardDAO.getInstance().memUpdateSuggest(sug);
		
		if(result > 0) {
			System.out.println("게시글 수정 완료");
		}else {
			System.out.println("게시글 수정 실패");
			System.out.println("본인이 작성한 게시글만 수정 가능합니다!");
		}
		
	}
	
	
	//관리자용 게시글 삭제
	public void adminDeleteSuggest() {
		SuggestionBoard sug = new SuggestionBoard();
		System.out.println("삭제할 게시글 번호 입력>");
		sug.setSugBoardId(Integer.parseInt(sc.nextLine()));
		
		int result = SuggestionBoardDAO.getInstance().adminDeleteSuggest(sug);
		if(result > 0) {
			System.out.println("게시글 삭제 완료");
		}else {
			System.out.println("게시글 삭제 실패");
		}
	}
	
	
	//회원용 게시글 삭제
	public void memDeleteSuggest() {
		SuggestionBoard sug = new SuggestionBoard();
		sug.setMemberId(MemberService.memberInfo.getMemberId());
		sug.setSugBoardId(inputNo);
		
		int result = SuggestionBoardDAO.getInstance().memDeleteSuggest(sug);
		if(result > 0) {
			System.out.println("게시글 삭제 완료");
		}else {
			System.out.println("게시글 삭제 실패");
			System.out.println("본인이 작성한 게시글만 삭제 가능합니다!");
		}
	}
	
	//삭제 후 재정렬
	public void reordering() {
		SuggestionBoard sug = new SuggestionBoard();
		sug.setSugBoardId(inputNo);
		
		SuggestionBoardDAO.getInstance().reordering(sug);
	}
	
	
}
