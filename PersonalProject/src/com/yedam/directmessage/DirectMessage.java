package com.yedam.directmessage;

import java.sql.Date;

public class DirectMessage {   
//	RECEIVER_ID            VARCHAR2(20)  
//	RECEIVER_NAME          VARCHAR2(30)  
//	SENDER_ID              VARCHAR2(20)  
//	SENDER_NAME            VARCHAR2(30)  
//	DM_CONTENTS            VARCHAR2(300) 
//	DM_DATE                DATE     
	
	private String receiverId;
	private String receiverName;
	private String senderId;
	private String SenderName;
	private String dmContents;
	private Date dmDate;
	
	
	public String getReceiverId() {
		return receiverId;
	}
	public void setReceiverId(String receiverId) {
		this.receiverId = receiverId;
	}
	public String getReceiverName() {
		return receiverName;
	}
	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}
	public String getSenderId() {
		return senderId;
	}
	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}
	public String getSenderName() {
		return SenderName;
	}
	public void setSenderName(String senderName) {
		SenderName = senderName;
	}
	public String getDmContents() {
		return dmContents;
	}
	public void setDmContents(String dmContents) {
		this.dmContents = dmContents;
	}
	public Date getDmDate() {
		return dmDate;
	}
	public void setDmDate(Date dmDate) {
		this.dmDate = dmDate;
	}
	
}
