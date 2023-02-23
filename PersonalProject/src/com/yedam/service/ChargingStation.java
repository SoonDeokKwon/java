package com.yedam.service;

import java.sql.Date;

public class ChargingStation {
	
	//필드
//	location_id NUMBER(2) PRIMARY KEY,
//	car_no VARCHAR2(30) ,
//	charg_type VARCHAR(10),
//	charg_time DATE,
//	reg_no VARCHAR2(10)
	
	private int locationId;
	private String carNo;
	private String chargType;
	private Date chargTime;
	private int batterRemain;
	
	
	
	public int getLocationId() {
		return locationId;
	}
	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}
	public String getCarNo() {
		return carNo;
	}
	public void setCarNo(String carNo) {
		this.carNo = carNo;
	}
	public String getChargType() {
		return chargType;
	}
	public void setChargType(String chargType) {
		this.chargType = chargType;
	}
	public Date getChargTime() {
		return chargTime;
	}
	public void setChargTime(Date chargTime) {
		this.chargTime = chargTime;
	}
	public int getBatterRemain() {
		return batterRemain;
	}
	public void setBatterRemain(int batterRemain) {
		this.batterRemain = batterRemain;
	}
	
	
	
}
