package com.yedam.service;

public class Member {
//	MEMBER_ID       NOT NULL VARCHAR2(20) 
//	MEMBER_PW       NOT NULL VARCHAR2(20) 
//	MEMBER_NAME     NOT NULL VARCHAR2(30) 
//	CAR_NUMBER               VARCHAR2(20) 
//	MEMBER_DISCOUNT          NUMBER(2,2)  
//	NOTICE_SCORE             NUMBER(10) 
	
	//필드
	private String memberId;
	private String memberPw;
	private String memberName;
	private String carNo;
	private double memberDisc;
	private int noiceScore;
	
	
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberPw() {
		return memberPw;
	}
	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getCarNo() {
		return carNo;
	}
	public void setCarNo(String carNo) {
		this.carNo = carNo;
	}
	public double getMemberDisc() {
		return memberDisc;
	}
	public void setMemberDisc(double memberDisc) {
		this.memberDisc = memberDisc;
	}
	public int getNoiceScore() {
		return noiceScore;
	}
	public void setNoiceScore(int noiceScore) {
		this.noiceScore = noiceScore;
	}
	
	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", memberPw=" + memberPw + ", memberName=" + memberName + ", carNo="
				+ carNo + ", memberDisc=" + memberDisc + ", noiceScore=" + noiceScore + "]";
	}
	
	
	
	
	
	
}
