);package com.yedam.departments.service;

import java.util.List;
import java.util.Scanner;

public class DepartmentsService {
	
	Scanner sc = new Scanner(System.in);
	
	//
	public void getDepartmentsList(){
		List<Departments> list = DepartmentsDAO.getInstance().getDepartmentsList();
		System.out.println("==============================");
		for(int i=0; i<list.size(); i++) {
			System.out.println("부서 ID : " + list.get(i).getDepartmentId());
			System.out.println("부서 이름 : " + list.get(i).getDepartmentName());
			System.out.println("관리자 번호 : " + list.get(i).getManagerId());
			System.out.println("지역 번호 : " + list.get(i).getLocationId());
			System.out.println("==============================");
		}
		
	}
	
	//
	public void getDepartment() {
		System.out.println("부서 번호>");
		int deptNo = Integer.parseInt(sc.nextLine());
		Departments dept = DepartmentsDAO.getInstance().getDepartment(deptNo);
		System.out.println("=====================================");
		if(dept == null) {
			System.out.println("조회된 결과 없음.");
		} else {
			System.out.println("부서 번호 : " + dept.getDepartmentId() );
			System.out.println("부서 이름 : " + dept.getDepartmentName());
			System.out.println("관리자 번호 : " + dept.getManagerId());
			System.out.println("지역 번호 : " + dept.getLocationId());
		}
		System.out.println("==============================");
		
	}
	
	// 등록
	public void insertDept() {
		System.out.println("============부서 생성============");
		System.out.println("부서 번호>");
		int deptNo = Integer.parseInt(sc.nextLine());
		System.out.println("부서 이름>");
		String deptName = sc.nextLine();
		System.out.println("관리자 번호>");
		int locNo = Integer.parseInt(sc.nextLine());
		System.out.println("지역 번호>");
		int mgrNo = Integer.parseInt(sc.nextLine());
		
		Departments dept = new Departments();
		
		dept.setDepartmentId(deptNo);
		dept.setDepartmentName(deptName);
		dept.setManagerId(locNo);
		dept.setLocationId(locNo);
		
		int result = DepartmentsDAO.getInstance().insertDept(dept);
		
		if(result > 0) {
			System.out.println("부서 등록 완료");
		}else {
			System.out.println("부서 등록 실패");
		}
		
	}
	
	//수정
	public void modifyDept() {
		System.out.println();
		System.out.println("수정 부서 번호>");
		int deptNo = Integer.parseInt(sc.nextLine());
		System.out.println("바꿀 관리자 번호>");
		int mgrNo = Integer.parseInt(sc.nextLine());
		
		Departments dept = new Departments();
		dept.setDepartmentId(deptNo);
		dept.setManagerId(mgrNo);
		
		int result = DepartmentsDAO.getInstance().modifyDept(dept);
		
		if(result > 0) {
			System.out.println("부서 수정 완료");
		}else {
			System.out.println("부서 수정 실패");
		}
	}
	
	
	//삭제
	public void deleteDept() {
		System.out.println();
		System.out.println("삭제 부서 번호>");
		int deptNo = Integer.parseInt(sc.nextLine());
		
		Departments dept = new Departments();
		dept.setDepartmentId(deptNo);
		
		int result = DepartmentsDAO.getInstance().deleteDept(dept);
		
		if(result > 0) {
			System.out.println("부서 삭제 완료");
		}else {
			System.out.println("부서 삭제 실패");
		}
		
		
		
	}
	
	
	
	
	
}
