package com.yedam.student;

import java.util.List;
import java.util.Scanner;

public class StudentService {

	Scanner sc = new Scanner(System.in);

	// 전체 학생 정보 조회
	public void getStudentList() {
		List<Student> list = StudentDAO.getInstance().getStudentList();
		System.out.println("========================================");
		
		for(int i =0; i<list.size(); i++) {
			System.out.println("학생 ID : " + list.get(i).getStdId());
			System.out.println("학생 이름 : " + list.get(i).getStdName());
			System.out.println("학생 전공 : " + list.get(i).getStdMajor());
			System.out.println("학생 학점 : " + list.get(i).getStdPoint());
			System.out.println("========================================");
		}

	}
	
	//학번 조회
	public void getStudent() {
		System.out.println("========================================");
		System.out.println("학생 ID>");
		int stdID = Integer.parseInt(sc.nextLine());
		Student std = StudentDAO.getInstance().getStudent(stdID);
		System.out.println("조회 결과>");
		if(std == null) {
			System.out.println("조회된 결과 없음.");
		}else {
			System.out.println("학생 ID : " + std.getStdId());
			System.out.println("학생 이름 : " + std.getStdName());
			System.out.println("학생 전공 : " + std.getStdMajor());
			System.out.println("학생 학점 : " + std.getStdPoint());
		}
		System.out.println("========================================");
		
	}
	

	//학생 등록
	public void insertStd() {
		System.out.println("========================================");
		System.out.println("학생 ID");
		int stdID = Integer.parseInt(sc.nextLine());
		System.out.println("학생 이름");
		String stdName = sc.nextLine();
		System.out.println("학생 전공");
		String stdMajor = sc.nextLine();
		System.out.println("학생 점수");
		Double stdPoint = Double.parseDouble(sc.nextLine());
		
		Student std = new Student();
		
		std.setStdId(stdID);
		std.setStdName(stdName);
		std.setStdMajor(stdMajor);
		std.setStdPoint(stdPoint);
		
		int result = StudentDAO.getInstance().insertStd(std);
		
		if(result > 0) {
			System.out.println("학생 정보 등록 완료");
		}else {
			System.out.println("학생 정보 등록 실패");
		}
		
	}
	

	//학생 제적
	public void deleteStd() {
		System.out.println("========================================");
		System.out.println("삭제할 학생 ID>");
		int stdID = Integer.parseInt(sc.nextLine());
		
		Student std = new Student();
		std.setStdId(stdID);
		
		int result = StudentDAO.getInstance().deleteStd(stdID);
		
		if(result > 0) {
			System.out.println("학생 정보 삭제 완료");
		}else {
			System.out.println("학생 정보 삭제 실패");
		}
		
	}
	
	
	//학생 전공 변경
	public void updateStd() {
		Student std = new Student();
		System.out.println("학번 입력>");
		std.setStdId(Integer.parseInt(sc.nextLine()));
		System.out.println("변경할 전공 입력>");
		std.setStdMajor(sc.nextLine());
		
		int result = StudentDAO.getInstance().updateStd(std);
		
		if(result > 0) {
			System.out.println("학생 정보 수정 완료");
		} else {
			System.out.println("학생 정보 수정 실패");
		}
		
	}
	
	//전공별 성적 합계, 성적 평균
	public void getAnalyze() {
		List<Student> list = 
		StudentDAO.getInstance().getAnalyze();
		
		for(int i=0; i < list.size(); i++) {
			System.out.println("전공명 : " + list.get(i).getStdMajor());
			System.out.println("합 계 : " + list.get(i).getStdSum());
			System.out.println("평 균 : " + list.get(i).getStdAvg());
			System.out.println("================================");
			
		}
		
	}
	
	
}
