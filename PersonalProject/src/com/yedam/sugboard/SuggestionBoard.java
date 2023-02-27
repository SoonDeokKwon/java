package com.yedam.sugboard;

import java.sql.Date;

public class SuggestionBoard {
//	SUGBOARD_ID       NOT NULL NUMBER(20)     
//	MEMBER_ID                  VARCHAR2(20)   
//	MEMBER_NAME                VARCHAR2(30)   
//	SUGBOARD_SUBJECT           VARCHAR2(100)  
//	SUGBOARD_CONTENTS          VARCHAR2(1000) 
//	SUGBOARD_DATE              DATE
	
	//필드
	private int sugBoardId;
	private String memberId;
	private String memberName;
	private String sugSubject;
	private String sugContents;
	private Date sugDate;
	
	
	public int getSugBoardId() {
		return sugBoardId;
	}
	public void setSugBoardId(int sugBoardId) {
		this.sugBoardId = sugBoardId;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getSugSubject() {
		return sugSubject;
	}
	public void setSugSubject(String sugSubject) {
		this.sugSubject = sugSubject;
	}
	public String getSugContents() {
		return sugContents;
	}
	public void setSugContents(String sugContents) {
		this.sugContents = sugContents;
	}
	public Date getSugDate() {
		return sugDate;
	}
	public void setSugDate(Date sugDate) {
		this.sugDate = sugDate;
	}
	
	

	
	

	
	
}
