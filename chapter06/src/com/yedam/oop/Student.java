package com.yedam.oop;

public class Student {
	
	//정보 - 학생이름, 학번, 국어, 영어, 수학 점수
	//기본 생성자, 모든 데이터를 초기화할 수 있는 생성자
	//학생의 정보를 출력해주는 getInfo()
	//sum()
	/*
	 * 이름 : 김또치
	 * 학번 : 20230201
	 * 총점 : 200
	 * 평균 : 68.xx
	 */
	
	
	//필드
	String name;
	int studentID;
	int kor;
	int eng;
	int math;
	
	
	//생성자
	// 1) 기본 생성자
	public Student() {	
	}
	// 2) 모든 데이터를 초기화할 수 있는 생성자
	public Student(String name, int studentID, int kor, int eng, int math) {
		this.name = name;
		this.studentID = studentID;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	
	//메소드
	int sum() {
		return kor + eng + math;
	}
	
	double avg() {
		return sum() / 3.0;
	}
	

	void getInfo() {
		System.out.println("이름 : " + name);
		System.out.println("학번 : " + studentID);
		System.out.println("총점 : " + sum());
		System.out.printf("평균 : %1.2f ", avg());

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
