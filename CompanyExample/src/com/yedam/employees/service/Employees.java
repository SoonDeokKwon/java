package com.yedam.employees.service;

import java.sql.Date;

public class Employees {
	private int employeeId;
	private String lastName;
	private String email;
	private Date hireDate;
	//java.sql.Date : 연월일
	//java.util.Date : 연월일시분초
	//사용하는 방식이 조금 다름.
	private int salary;
	private int jobId;
	
	
	
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getHireDate() {
		return hireDate;
	}
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public int getJobId() {
		return jobId;
	}
	public void setJobId(int jobId) {
		this.jobId = jobId;
	}
	
	//toString
	@Override
	public String toString() {
		return "Employees [사번=" + employeeId + ",\t이름=" + lastName + ",\t이메일=" + email + ",\t입사일="
				+ hireDate + ",\t직책=" + jobId + "]";
	}
	
	
	
	
}
