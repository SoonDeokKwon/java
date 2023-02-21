package com.yedam.somoim;

import java.util.ArrayList;
import java.util.List;

import com.yedam.common.DAO;

public class SomoimDAO extends DAO{
	
	//싱글톤
	private static SomoimDAO sDao = new SomoimDAO();
	
	
	private SomoimDAO() {
		
	}
	
	public static SomoimDAO getInstance() {
		return sDao;
	}
	
	
	//로그인
	public Somoim login(String memberId) {
		Somoim somo = null;
		
		try {
			conn();
			String sql = "SELECT *\r\n"
					+ "FROM somoim \r\n"
					+ "WHERE member_id = 'host001'";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				somo = new Somoim();
				somo.setMemberId(rs.getString("member_id"));
				somo.setMemberName(rs.getNString("memeber_name"));
				somo.setJoinDate(rs.getDate("join_date"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();			
		}finally {
			disconn();
		}
		return somo;
		
	}
	
	
	
	//새 회원 등록
	public int insertMember(Somoim somo) {
		int result = 0;
		
		try {
			conn();
			
			String sql = "INSERT INTO somoim \n"
					+ "VALUES(?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, somo.getMemberId());
			pstmt.setString(2, somo.getMemberName());
			pstmt.setDate(3, somo.getJoinDate());
			pstmt.setString(4, somo.getEmail());
			pstmt.setInt(5, somo.getMemberAge());
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
	
	
	
	//모든 회원 조회 -> 가입 날자 순서대로 조회
	public List<Somoim> getMemberList() {
		List<Somoim> list = new ArrayList<>();
		
		Somoim somo = null;
		
		try {
			conn();
			String sql = "SELECT * \n"
					+ "FROM somoim\n"
					+ "ORDER BY join_date";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				somo = new Somoim();
				somo.setMemberId(rs.getString("member_id"));
				somo.setMemberName(rs.getString("memeber_name"));
				somo.setJoinDate(rs.getDate("join_date"));
				somo.setMemberAge(rs.getInt("member_age"));
				
				list.add(somo);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return list;
		
	}
	
	
	//아이디로 회원 조회
	public Somoim getMember() {
		Somoim somo = null;
		
		try {
			conn();
			String sql = "SELECT * \n"
					+ "FROM somoim\n"
					+ "WHERE member_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, SomoimService.somoimInfo.getMemberId());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				somo = new Somoim();
				somo.setMemberId(rs.getString("member_id"));
				somo.setMemberName(rs.getString("memeber_name"));
				somo.setJoinDate(rs.getDate("join_date"));
				somo.setMemberAge(rs.getInt("member_age"));
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return somo;
	}
	
	
	
	//이메일 변경
	public int updateEmail(Somoim somo) {
		int result =0;
		
		try {
			conn();
			
			String sql = "UPDATE somoim\n"
					+ "SET email = ?"
					+ "WHERE member_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, somo.getMemberId());
			pstmt.setString(2, somo.getEmail());
			
			result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		
		return result;
	}
	
	
	//소모임 인원 강제 탈퇴
	public int deleteMember(String memberId) {
		int result = 0;
		
		try {
			conn();
			
			String sql = "DELETE FROM somoim\n"
					+ "WHERE member_id =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			
			result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		
		return result;
	}
	
	

	
}
