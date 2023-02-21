package com.yedam.somoim;

import java.util.Date;

public class Somoim {
//	MEMBER_ID   NOT NULL NUMBER(12)   
//	MEMBER_NAME NOT NULL VARCHAR2(30) 
//	JOIN_DATE            DATE         
//	EMAIL                VARCHAR2(30) 
//	MEMBER_AGE           NUMBER(2) 
	
	private String memberId;
	private String memberName;
	private Date joinDate;
	private String email;
	private int memberAge;
	
	
	
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
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getMemberAge() {
		return memberAge;
	}
	public void setMemberAge(int memberAge) {
		this.memberAge = memberAge;
	}
	
	@Override
	public String toString() {
		return "Somoim [memberId=" + memberId + ", memberName=" + memberName + ", joinDate=" + joinDate + ", email="
				+ email + ", memberAge=" + memberAge + "]";
	}
	
	
	
	
	
}
