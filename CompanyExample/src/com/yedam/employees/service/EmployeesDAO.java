package com.yedam.employees.service;

import java.util.ArrayList;
import java.util.List;

import com.yedam.common.DAO;

public class EmployeesDAO extends DAO {
	
	//싱글톤
	private static EmployeesDAO employDao = null;
	
	private EmployeesDAO() {
		
	}
	
	public static EmployeesDAO getInstance() {
		if(employDao == null) {
			employDao = new EmployeesDAO();
		}
		return employDao;
	}
	
	
	//모든 사원 조회, 한 사원 조회, 부서 삭제, 수정, 등록
	//명심!!! 각 DAO에서 사용하는 쿼리는 반드시 sqlDveloper에서 실행해보고 자바에 적용시킬 것.!!
	
	
	//모든 부서 조회

	
	
	
	
	
}
