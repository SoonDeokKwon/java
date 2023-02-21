package com.yedam.student;

import java.util.ArrayList;
import java.util.List;

import com.yedam.common.DAO;

public class StudentDAO extends DAO {
	//싱글톤
	
	private static StudentDAO stdDao = null;
	
	private StudentDAO() {
		
	}
	
	public static StudentDAO getInstance() {
		if(stdDao == null) {
			stdDao = new StudentDAO();
		}
		
		return stdDao;
		
	}
	
	
	//전체 학생 정보 조회
	public List<Student> getStudentList(){
		List<Student> list = new ArrayList<>();
		
		Student std = null;
		
		try {
			conn();
			String sql = "select * from std";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				std = new Student();
				std.setStdId(rs.getInt("std_id"));
				std.setStdName(rs.getString("std_name"));
				std.setStdMajor(rs.getString("std_major"));
				std.setStdPoint(rs.getInt("std_point"));
				
				list.add(std);
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return list;
	}
	
	//학번 조회
	public Student getStudent(int stdId) {
		Student std = null;
		
		try {
			conn();
			
			String sql = "SELECT *\r\n"
					+ "FROM std\r\n"
					+ "WHERE std_id = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, stdId);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				std = new Student();
				
				std.setStdId(rs.getInt("std_id"));
				std.setStdName(rs.getString("std_name"));
				std.setStdMajor(rs.getString("std_major"));
				std.setStdPoint(rs.getInt("std_point"));
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		
		return std;
		
	}
	
	//학생 등록
	public int insertStd(Student std) {
		int result = 0;
		
		try {
			conn();
			
			String sql = "insert into std vlaues (?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,std.getStdId());
			pstmt.setString(2, std.getStdName());
			pstmt.setString(3, std.getStdMajor());
			pstmt.setDouble(4, std.getStdPoint());
			
			result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
		
	}
	
	//학생 제적
	public int deleteStd(int stdId) {
		int result = 0;
		
		try {
			conn();
			
			String sql = "delete from std where std_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, stdId);
			
			result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		
		return result;
		
	}
	
	//학생 전공 변경
	public int updateStd(Student std) {
		int result = 0;
		
		try {
			conn();
			
			String sql = "update set std_major =? where std_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, std.getStdId());
			pstmt.setString(2,std.getStdMajor());
			
			result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		
		return result;
		
	}
	
	//전공별 성적 합계, 평균
	public List<Student> getAnalyze(){
		List<Student> list = new ArrayList<>();
		Student std = null;
		
		try {
			conn();
			String sql = "SELECT std_major, sum(std_point) AS total, avg(std_point)\r\n"
					+ "FROM std\r\n"
					+ "GROUP BY std_major";
			pstmt = conn.prepareStatement(sql);
			
			rs= pstmt.executeQuery();
			
			while(rs.next()) {
				std = new Student();
				std.setStdMajor(rs.getString("std_major"));
				std.setStdSum(rs.getDouble("total"));
				std.setStdAvg(rs.getDouble("avg(std_point)"));
				
				list.add(std);
			}	
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return list;
		
	}
	
	
	
	
}
