package com.yedam.notiboard;

import java.util.List;
import java.util.Scanner;

public class NoticeBoardService {
	
	Scanner sc = new Scanner(System.in);
	public static int inputNo3 = 0;
	
	//게시 제목 리스트
	public void listNoticeBoard() {
		List<NoticeBoard> list = NoticeBoardDAO.getInstance().listNoticeBoard();
		
		for(int i=0; i<list.size(); i++) {
			System.out.println("============================================================");
			System.out.println(list.get(i).getNoticeId() + "번 \t" + " | 작성자: "  + list.get(i).getMemberName() + "|\t" + list.get(i).getNotiSubject());
		}
	}
	
	//게시물 내용 보기
	public void viewNotiBoard() {
		System.out.println("열람할 게시글의 게시번호 입력>");
		inputNo3 = Integer.parseInt(sc.nextLine());
		NoticeBoard noti = NoticeBoardDAO.getInstance().viewNotiBoard(inputNo3);
		
		System.out.println("───────────────────────────────────────────────────────────────────────");
		System.out.print("게시번호 : " + noti.getNoticeId() + "\t");
		System.out.print("작성자 : " + noti.getMemberName()+ "\t");
		System.out.println("작성 날짜 : " + noti.getNotiBoardDate() + "\t");
		System.out.println("제목 : " + noti.getNotiSubject());
		System.out.println();
		System.out.println(noti.getNotiContents());
		System.out.println();
		System.out.println("───────────────────────────────────────────────────────────────────────");

	}
	
	public void viewNotiBoard2() {
		NoticeBoard noti = NoticeBoardDAO.getInstance().viewNotiBoard(inputNo3);
		
		System.out.println("───────────────────────────────────────────────────────────────────────");
		System.out.print("게시번호 : " + noti.getNoticeId() + "\t");
		System.out.print("작성자 : " + noti.getMemberName()+ "\t");
		System.out.println("작성 날짜 : " + noti.getNotiBoardDate() + "\t");
		System.out.println("제목 : " + noti.getNotiSubject());
		System.out.println();
		System.out.println(noti.getNotiContents());
		System.out.println();
		System.out.println("───────────────────────────────────────────────────────────────────────");

	}
	
	
	//게시물 작성
	public void insertNotiBoard(){
		NoticeBoard noti = new NoticeBoard();
		System.out.println("==========================================================");
		System.out.println("제목 입력>");
		noti.setNotiContents(sc.nextLine());
		System.out.println("내용 입력>");
		noti.setNotiContents(sc.nextLine());
		
		int result = NoticeBoardDAO.getInstance().insertNotiBoard(noti);
		
		if(result>0) {
			System.out.println("글쓰기 등록 완료");
		}else {
			System.out.println("글쓰기 등록 실패");
		}
		
	}
	
	
	//게시물 수정
	public void modifyNoticeBoard() {
		NoticeBoard noti = new NoticeBoard();
		System.out.println("수정할 게시글 번호 입력>");
		noti.setNoticeId(Integer.parseInt(sc.nextLine()));
		System.out.println("제목 입력>");
		noti.setNotiSubject(sc.nextLine());
		System.out.println("내용 입력>");
		noti.setNotiContents(sc.nextLine());
		
		int result = NoticeBoardDAO.getInstance().modifyNoticeBoard(noti);
		
		if(result > 0) {
			System.out.println("게시글 수정 완료");
		}else {
			System.out.println("게시글 수정 실패");
		}
	}
	
	
	//게시물 삭제
	public void deleteNotiBoard() {
		NoticeBoard noti = new NoticeBoard();
		noti.setNoticeId(inputNo3);
		int result = NoticeBoardDAO.getInstance().deleteNotiBoard(noti);
		
		if(result > 0) {
			System.out.println("게시글 삭제 완료");
		}else {
			System.out.println("게시글 삭제 실패");
		}
	}
	
	
	//게시물 삭제 후 게시번호 재정렬
	public void notiReordering() {
		NoticeBoard noti = new NoticeBoard();
		noti.setNoticeId(inputNo3);
		
		NoticeBoardDAO.getInstance().notiReordering(noti);
		
	}
	
}
