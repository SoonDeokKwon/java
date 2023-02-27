package com.yedam.notiboard;

import java.sql.Date;

public class NoticeBoard {
//	NOTIBOARD_ID       NOT NULL NUMBER(20)     
//	MEMBER_ID                   VARCHAR2(20)   
//	MEMBER_NAME                 VARCHAR2(30)   
//	NOTIBOARD_SUBJECT           VARCHAR2(100)  
//	NOTIBOARD_CONTENTS          VARCHAR2(1000) 
//	NOTIBOARD_DATE              DATE  
	
	private int noticeId;
	private String memberId;
	private String memberName;
	private String notiSubject;
	private String notiContents;
	private Date notiBoardDate;
	
	
	public int getNoticeId() {
		return noticeId;
	}
	public void setNoticeId(int noticeId) {
		this.noticeId = noticeId;
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
	public String getNotiSubject() {
		return notiSubject;
	}
	public void setNotiSubject(String notiSubject) {
		this.notiSubject = notiSubject;
	}
	public String getNotiContents() {
		return notiContents;
	}
	public void setNotiContents(String notiContents) {
		this.notiContents = notiContents;
	}
	public Date getNotiBoardDate() {
		return notiBoardDate;
	}
	public void setNotiBoardDate(Date notiBoardDate) {
		this.notiBoardDate = notiBoardDate;
	}
	
	
	
	
	
}
