package com.yedam.directmessage;

import java.util.Scanner;

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
		List<DirectMessage> list = DirectMessageDAO.getInstance().reciveDMlist();
	}
	
	
	//받은 쪽지함 비우기
	public void receiveDelete() {
		
	}
	
	
	//보낸 쪽지함 보기
	public void sendDMlist() {
		
	}
	
	
	//보낸 쪽지함 비우기
	public void sendDelete() {
		
	}
	
	
	
	
	
}
