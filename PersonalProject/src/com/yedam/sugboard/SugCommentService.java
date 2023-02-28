package com.yedam.sugboard;

import java.util.List;
import java.util.Scanner;

import com.yedam.service.MemberService;

public class SugCommentService {
	Scanner sc = new Scanner(System.in);
	private static int inputNo2 = 0;
	private static int inputNo4= 0;

	
	//댓글 보이게 하기 
	public void listSugComment() {
		List<SugComment> list = SugCommentDAO.getInstance().listSugComment(SuggestionBoardService.inputNo);
		System.out.println("<댓글>");
		for(int i=0; i< list.size(); i++){
			System.out.println(list.get(i).getSugCommentId() + "번" + "   ㄴ(" + list.get(i).getMemberName() + ")" + list.get(i).getSugComment());
			System.out.println("──────────────────────────────────────────────────────────────────────");
		}
	}
	
	//댓글 입력
	public void insertSugComment() {
		SugComment sCom = new SugComment();
		System.out.println("============================================================");
		sCom.setSugBoardId(SuggestionBoardService.inputNo);
		
		sCom.setMemberId(MemberService.memberInfo.getMemberId());
		sCom.setMemberName(MemberService.memberInfo.getMemberName());
		System.out.println("댓글 입력>");
		sCom.setSugComment(sc.nextLine());
		
		int result = SugCommentDAO.getInstance().insertSugComment(sCom);
		if(result>0) {
			System.out.println("댓글 등록 완료");
		}else {
			System.out.println("댓글 등록 실패");
		}
		
		
	}
	
	//댓글 수정
	public void modifySugComment() {
		SugComment sCom = new SugComment();
		System.out.println("============================================================");
		System.out.println("수정하고자 하는 댓글 번호 입력>");
		sCom.setSugCommentId(Integer.parseInt(sc.nextLine()));
		System.out.println("수정내용 입력>");
		sCom.setSugComment(sc.nextLine());
		sCom.setMemberId(MemberService.memberInfo.getMemberId());
		
		int result = SugCommentDAO.getInstance().modifySugComment(sCom);
		
		if(result > 0) {
			System.out.println("댓글 수정 완료");
		}else {
			System.out.println("댓글 수정 실패");
			System.out.println("본인이 작성한 댓글만 수정 가능합니다!");
		}
		
	}
	
	//댓글 삭제
	public void deleteSugComment() {
		SugComment sCom = new SugComment();
		System.out.println("============================================================");
		System.out.println("삭제하고자 하는 댓글 번호 입력>");
		inputNo4 = Integer.parseInt(sc.nextLine());
		sCom.setSugCommentId(inputNo4);
		sCom.setMemberId(MemberService.memberInfo.getMemberId());
		
		int result = SugCommentDAO.getInstance().deleteSugComment(sCom);
		
		if(result > 0) {
			System.out.println("댓글 삭제 완료");
		}else {
			System.out.println("댓글 삭제 실패");
			System.out.println("본인이 작성한 댓글만 삭제 가능합니다!");
		}
		
	}
	
	//댓글 삭제(관리자)
	public void adminDeleteSugComment() {
		SugComment sCom = new SugComment();
		System.out.println("============================================================");
		System.out.println("삭제하고자 하는 댓글 번호 입력>");
		inputNo2 = Integer.parseInt(sc.nextLine());
		sCom.setSugCommentId(inputNo2);
		
		int result = SugCommentDAO.getInstance().adminDeleteSugComment(sCom);
		
		if(result > 0) {
			System.out.println("댓글 삭제 완료");
		}else {
			System.out.println("댓글 삭제 실패");
		}
		
	}
	
	
	//댓글번호 재정렬(회원)
	public void SugComReordering() {
		SugComment sCom = new SugComment();
		sCom.setMemberId(MemberService.memberInfo.getMemberId());
		sCom.setSugCommentId(inputNo2);
		
		SugCommentDAO.getInstance().SugComReordering(sCom);
	}
	
	//댓글번호 재정렬(관리자용)
		public void SugComReordering2() {
			SugComment sCom = new SugComment();
			sCom.setMemberId(MemberService.memberInfo.getMemberId());
			sCom.setSugCommentId(inputNo4);
			
			SugCommentDAO.getInstance().SugComReordering(sCom);
		}
	
	
	
	
}
