package com.yedam.directmessage;

import java.util.List;
import java.util.Scanner;

import com.yedam.service.MemberDAO;
import com.yedam.service.MemberService;

public class DirectMessageService {
	
	Scanner sc = new Scanner(System.in);
	
	//쪽지 보내기
	public void sendDM() {
		DirectMessage DM = new DirectMessage();
		System.out.println("받는 사람 ID>");
		DM.setReceiverId(sc.nextLine());
		System.out.println("받는 사람 이름>");
		DM.setReceiverName(sc.nextLine());
		System.out.println("쪽지 내용>");
		DM.setDmContents(sc.nextLine());
		DM.setSenderId(MemberService.memberInfo.getMemberId());
		DM.setSenderName(MemberService.memberInfo.getMemberName());
		
		int result = DirectMessageDAO.getInstance().sendDM(DM);
		
		if(result>0) {
			System.out.println("성공적으로 쪽지를 보냈습니다.");
		}else {
			System.out.println("쪽지를 보내는 데 실패했습니다.");
		}
	}
	
	
	//받은 쪽지함 보기
	public void reciveDMlist() {
		String input = MemberService.memberInfo.getMemberId();
		List<DirectMessage> list = DirectMessageDAO.getInstance().reciveDMlist(input);
		System.out.println("=====================================쪽지함=====================================");
		
		if(list.size() == 0) {
			System.out.println("받은 쪽지가 없습니다.");
		}else if(list.size() != 0) {
			for(int i =0; i< list.size(); i++) {
				System.out.print("보낸사람 ID : " + list.get(i).getSenderId() + "\t");
				System.out.print("보낸사람 이름 : " + list.get(i).getSenderName() + "\t");
				System.out.println("보낸 날짜 : " + list.get(i).getDmDate());
				System.out.println("📩 받은 쪽지 내용");
				System.out.println("✒... " + list.get(i).getDmContents());
				System.out.println("─────────────────────────────────────────────────────────────────────────────────");
			}
		}
		
		
	}
	
	
	//받은 쪽지함 비우기
	public void receiveDelete() {
		DirectMessage DM = new DirectMessage();
		DM.setReceiverId(MemberService.memberInfo.getMemberId());
		
		int result = DirectMessageDAO.getInstance().receiveDelete(DM);
		
		if(result>0) {
			System.out.println("받은 쪽지함이 비워졌습니다.");
		}else {
			System.out.println("받은 쪽지함을 비우는데 실패했습니다.");
		}
		
	}
	
	
	//보낸 쪽지함 보기
	public void sendDMlist() {
		String input = MemberService.memberInfo.getMemberId();
		List<DirectMessage> list = DirectMessageDAO.getInstance().sendDMlist(input);
		System.out.println("=======================================쪽지함=======================================");
		
		if(list.size() == 0) {
			System.out.println("보낸 쪽지가 없습니다.");
		}else if(list.size() != 0) {
			for(int i =0; i< list.size(); i++) {
				System.out.print("받는사람 ID : " + list.get(i).getReceiverId() + "\t");
				System.out.print("받는사람 이름 : " + list.get(i).getReceiverName() + "\t");
				System.out.println("보낸 날짜 : " + list.get(i).getDmDate());
				System.out.println("📨 보낸 쪽지 내용");
				System.out.println("✒... " + list.get(i).getDmContents());
				System.out.println("─────────────────────────────────────────────────────────────────────────────────");
			}
		}
		
	}
	
	
	//보낸 쪽지함 비우기
	public void sendDelete() {
		DirectMessage DM = new DirectMessage();
		DM.setSenderId(MemberService.memberInfo.getMemberId());
		
		int result = DirectMessageDAO.getInstance().sendDelete(DM);
		
		if(result>0) {
			System.out.println("보낸 쪽지함이 비워졌습니다.");
		}else {
			System.out.println("보낸 쪽지함을 비우는데 실패했습니다.");
		}
	}
	
	
	
	
	
}
