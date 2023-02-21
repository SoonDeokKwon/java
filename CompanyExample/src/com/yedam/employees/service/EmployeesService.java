package com.yedam.employees.service;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import com.yedam.departments.service.Departments;
import com.yedam.departments.service.DepartmentsDAO;

public class EmployeesService {
	Scanner sc = new Scanner(System.in);
	
	
	//
	public void getEmployeesList() {
		List<Employees> list = EmployeesDAO.getInstance().getEmployeesList();
		System.out.println("=====================================");
		
		for(int i = 0; i < list.size(); i++) {
			System.out.println("사원 ID : " + list.get(i).getEmployeeId());
			System.out.println("사원 이름 : " + list.get(i).getLastName());
			System.out.println("사원 이메일 : " + list.get(i).getEmail());
			System.out.println("사원 입사일 : " + list.get(i).getHireDate());
			System.out.println("직무 ID : " + list.get(i).getJobId());
			System.out.println("월  급 : " + list.get(i).getSalary());
			System.out.println("=====================================");
		}
		
	}
	
	
	//
	public void getEmployees() {
		System.out.println("사원 번호>");
		int empNo = Integer.parseInt(sc.nextLine());
		Employees emp = EmployeesDAO.getInstance().getEmployees(empNo);
		System.out.println("===============================");		
		if(emp == null) {
			System.out.println("조회된 결과 없음.");
		}else {
			System.out.println("사원 ID : " + emp.getEmployeeId());
			System.out.println("사원 이름 : " + emp.getLastName());
			System.out.println("직무 ID : " + emp.getJobId());
			System.out.println("월  급 : " + emp.getSalary());
		}
		System.out.println("================================");
		
	}
	
	
	//등록
	public void insertEmp() {
		System.out.println("==============부서 수정================");
		System.out.println("사원 번호>");
		int empNo = Integer.parseInt(sc.nextLine());
		System.out.println("사원 이름>");
		String empName = sc.nextLine();
		System.out.println("사원 이메일>");
		String empEmail = sc.nextLine();
		System.out.println("사원 입사일>");
		Date hireDate = Date.valueOf(sc.nextLine());
		System.out.println("직무 번호>");
		int jobNo = Integer.parseInt(sc.nextLine());
		System.out.println("사원 월급>");
		int salary = Integer.parseInt(sc.nextLine());
		
		Employees emp = new Employees();
		
		emp.setEmployeeId(empNo);
		emp.setLastName(empName);
		emp.setEmail(empEmail);
		emp.setHireDate(hireDate);
		emp.setJobId(jobNo);
		emp.setSalary(salary);
		
		int result = EmployeesDAO.getInstance().insertEmp(emp);
		
		if(result > 0) {
			System.out.println("사원 등록 완료");
		}else {
			System.out.println("사원 등록 실패");
		}

	}
	
	
	
	//수정
	public void modifyEmp() {
		System.out.println("==============부서 수정================");
		System.out.println("수정 부서 번호>");
		int empNo = Integer.parseInt(sc.nextLine());
		System.out.println("바꿀 직무 번호>");
		int jobNo = Integer.parseInt(sc.nextLine());
		
		Employees dept = new Employees();
		dept.setEmployeeId(empNo);
		dept.setJobId(jobNo);
		
		int result = EmployeesDAO.getInstance().modifyEmp(dept);
		
		if(result > 0) {
			System.out.println("부서 수정 완료");
		}else {
			System.out.println("부서 수정 실패");
		}
		
	}
	
	
	
	//삭제
	public void deleteEmp() {
		System.out.println("==============부서 삭제================");
		System.out.println("삭제 사원 번호>");
		int empNo = Integer.parseInt(sc.nextLine());
		
		Employees emp = new Employees();
		emp.setEmployeeId(empNo);
		
		int result = EmployeesDAO.getInstance().deleteEmp(emp);
		
		if(result > 0) {
			System.out.println("사원 삭제 완료");
			
		}else {
			System.out.println("사원 삭제 실패");
		}
		

	}
	
	
	
	
	
	
}
