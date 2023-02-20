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
	
	
	//모든 사원 조회
	public List<Employees> getEmployeesList(){
		List<Employees> list = new ArrayList();
		
		Employees employ = null;
		
		try {
			conn();
			
			String sql = "select * from emp";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				employ = new Employees();
				employ.setEmployeeId(rs.getInt("employee_id"));
				employ.setLastName(rs.getString("last_name"));
				employ.setJobId(rs.getInt("job_id"));
				employ.setSalary(rs.getInt("salary"));
				
				list.add(employ);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return list;
		
	}
	
	//한 사원 조회
	public Employees getEmployees(int employeekey) {
		Employees employ = null;
		
		try {
			conn();
			
			String sql = "select * from emp where employee_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, employeekey);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				employ = new Employees();
				employ.setEmployeeId(rs.getInt("employee_id"));
				employ.setLastName(rs.getString("last_name"));
				employ.setJobId(rs.getInt("job_id"));
				employ.setSalary(rs.getString("salary");	
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return employ;
	}
	
	
	//삭제
	public int deleteEmp (Employees e) {
		int result =0;
		
		try {
			conn();
			
			String sql = "DELETE FROM WHERE emp employee_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, e.getEmployeeId());
			
			result = pstmt.executeUpdate();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
	
	
	//수정
	public int modifyEmp(Employees e) {
		int result =0;
		
		try {
			conn();
			String sql = "update set job_id =? where employee_id =?";
			pstmt = conn.prepareCall(sql);
			pstmt.setInt(1, e.getJobId());
			pstmt.setInt(2,	e.getEmployeeId());
			
			result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;

	}
	
	//등록
	public int insertEmp(Employees e) {
		int result = 0;
		
		try {
			conn();
			String sql =  "insert into emp values (?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, e.getEmployeeId());
			pstmt.setString(2, e.getLastName());
			pstmt.setInt(3, e.getJobId());
			pstmt.setInt(4, e.getSalary());
			
			result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;		
	}
	
	
	
	
	
	
	
	
	
}
