package com.yedam.employees.service;

import java.util.List;
import java.util.Scanner;

public class EmployeesService {
	Scanner sc = new Scanner(System.in);
	
	
	//
	public void getEmployeesList() {
		List<Employees> list = EmployeesDAO.getInstance().getEmployeesList();
		System.out.println("=====================================");
		
		for(int i = 0; i < list.size(); i++) {
			System.out.println("사원 ID : " + list.get(i).getEmployeeId());
			System.out.println("사원 이름 : " + list.get(i).getLastName());
			System.out.println("직무 ID : " + list.get(i).getJobId());
			System.out.println("월  급 : " + list.get(i).getSalary());
			System.out.println("=====================================");
		}
		
	}
	
	
	//등록
	public void getEmployees() {
		System.out.println("사원 번호>");
		int empNo = Integer.parseInt(sc.nextLine());
		Employees emp = EmployeesDAO.getInstance().getEmployees(empNo);
		System.out.println("============부서 생성============");		if(emp == null) {
			System.out.println("조회된 결과 없음.");
		}else {
			System.out.println("사원 ID : " + emp.getEmployeeId());
			System.out.println("사원 이름 : " + emp.getLastName());
			System.out.println("직무 ID : " + emp.getJobId());
			System.out.println("월  급 : " + emp.getSalary());
		}
		System.out.println("================================");
		
	}
	
	
	//
	public void insertEmp() {
		System.out.println("==============부서 수정================");
		System.out.println("사원 번호>");
		int empNo = Integer.parseInt(sc.nextLine());
		System.out.println("사원 이름");
		String empName = sc.nextLine();
		System.out.println("직무 번호");
		int jobNo = Integer.parseInt(sc.nextLine());
		System.out.println("사원 월급");
		int salary = Integer.parseInt(sc.nextLine());
		
		Employees emp = new Employees();
		
		emp.setEmployeeId(empNo);
		emp.setLastName(empName);
		emp.setJobId(jobNo);
		emp.setSalary(salary);
		
		int result = EmployeesDAO.getInstance().insertEmp(emp);
		
		if(result > 0) {
			System.out.println("사원 등록 완료");
		}else {
			System.out.println("사원 수정 실패");
		}

	}
	
	
	
	
	//
	public void modifyEmp() {
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
		
		System.out.println(empNo);
		
		if(result > 0) {
			System.out.println("사원 삭제 완료");
		}else {
			System.out.println("사원 삭제 실패");
		}
	}
	
	
	
	
	
	
}
