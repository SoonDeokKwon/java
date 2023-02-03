package com.yedam.access;

public class Student {
	//다음 조건을 만족하는 Student 클래스 작성
	//이름, 학과, 학년, 과목별 점수
	//과목 설정
	//programing, database, OS
	//필드들은 모두 private
	//setter를 통해 필드 초기화
	//getter를 통해 데이터 reading
	//getInfo() 학생의 정보를 출력하는 기능
	
	//필드
	private String stdName;
	private String major;
	private String stdGrade;
	private int programing;
	private int database;
	private int os;
	
	//생성자
	
	//메소드
	public void setStdName(String stdName) {
		this.stdName = stdName;
	}
	public String getStdName() {
		return stdName;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getStdGrade() {
		return stdGrade;
	}
	public void setStdGrade(String stdGrade) {
		this.stdGrade = stdGrade;
	}
	public int getPrograming() {
		return programing;
	}
	//
	//
	public void setPrograming(int programing) {
//		if(programing <= 0) {
//		this.programing = 0;
//		return;
//		}
		this.programing = (programing <= 0) ? 0 : programing;
	}
	public int getDatabase() {
		return database;
	}
	public void setDatabase(int database) {
		this.database = database;
	}
	public int getOs() {
		return os;
	}
	public void setOs(int os) {
		this.os = os;
	}

}
