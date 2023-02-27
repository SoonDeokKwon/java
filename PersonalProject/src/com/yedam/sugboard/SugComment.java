package com.yedam.sugboard;

import java.sql.Date;

public class SugComment {
//	SUGCOMMENT_ID       NOT NULL NUMBER(20)    
//	SUGBOARD_ID                  NUMBER(20)    
//	MEMBER_ID                    VARCHAR2(20)  
//	MEMBER_NAME                  VARCHAR2(30)  
//	SUGCOMMENT_CONTENTS          VARCHAR2(300) 
//	SUGCOMMENT_DATE              DATE  
	
	//필드
	private int sugCommentId;
	private int sugBoardId;
	private String memberId;
	private String memberName;
	private String sugComment;
	private Date sugCommentDate;
	
	
	public int getSugCommentId() {
		return sugCommentId;
	}
	public void setSugCommentId(int sugCommentId) {
		this.sugCommentId = sugCommentId;
	}
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
	public String getSugComment() {
		return sugComment;
	}
	public void setSugComment(String sugComment) {
		this.sugComment = sugComment;
	}
	public Date getSugCommentDate() {
		return sugCommentDate;
	}
	public void setSugCommentDate(Date sugCommentDate) {
		this.sugCommentDate = sugCommentDate;
	}
	
	
}
