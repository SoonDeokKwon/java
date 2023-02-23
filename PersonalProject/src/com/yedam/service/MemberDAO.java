package com.yedam.service;

import com.yedam.common.DAO;

public class MemberDAO extends DAO{
	
	//싱글톤
	public static MemberDAO mDao = new MemberDAO();
	
	private MemberDAO() {
		
	}
	
	public static  MemberDAO getInstance(){
		return mDao;
	}
	
	//로그인
	public Member login(String id) {
		Member mem  = null;
		
		try {
			conn();
			String sql = "SELECT * \r\n"
					+ "FROM user_info\r\n"
					+ "WHERE member_id =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				mem = new Member();
				mem.setMemberId(rs.getString("member_id"));
				mem.setMemberPw(rs.getString("member_pw"));
				mem.setMemberName(rs.getString("member_name"));
				mem.setCarNo(rs.getString("car_number"));
				mem.setMemberDisc(rs.getDouble("member_discount"));
				mem.setNoiceScore(rs.getInt("notice_score"));
			}

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return mem;
		
	}
	
	
	//회원 정보 조회
	public Member getMember() {
		Member mem = new Member();
		
		try {
			conn();
			
			String sql = "SELECT * \r\n"
					+ "FROM user_info\r\n"
					+ "WHERE member_id =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, MemberService.memberInfo.getMemberId());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				mem = new Member();
				mem.setMemberId(rs.getString("member_id"));
				mem.setMemberPw(rs.getString("member_pw"));
				mem.setMemberName(rs.getString("member_name"));
				mem.setCarNo(rs.getString("car_number"));
				mem.setMemberDisc(rs.getDouble("member_discount"));
				mem.setNoiceScore(rs.getInt("notice_score"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return mem;
	}
	
	//회원 정보 등록
	public int insertMember(Member mem) {
		int result = 0;
		
		try {
			
			
			
			conn();
			String sql = "INSERT INTO user_info\r\n"
					+ "VALUES (?,?,?,?, 0.1, 0)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mem.getMemberId());
			pstmt.setString(2, mem.getMemberPw());
			pstmt.setString(3, mem.getMemberName());
			pstmt.setString(4, mem.getCarNo());
			
			result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
	
	//회원 정보 수정
	public int modifyMember1(Member mem) {
		int result = 0;
		
		try {
			conn();
			String sql = "UPDATE user_info\r\n"
					+ "SET member_pw = ?\r\n"
					+ "WHERE member_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mem.getMemberPw());
			pstmt.setString(2, mem.getMemberId());
			
			result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
	
	//회원 정보 수정
	public int modifyMember2(Member mem) {
		int result = 0;
		
		try {
			conn();
			String sql = "UPDATE user_info\r\n"
					+ "SET car_number = ?\r\n"
					+ "WHERE member_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mem.getCarNo());
			pstmt.setString(2, mem.getMemberId());
			
			result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
	
	//화원 정보 삭제
	public int deleteMember(String memId) {
		int result = 0;
		
		try {
			conn();
			
			String sql = "DELETE FROM user_info\r\n"
					+ "WHERE member_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId);
			
			result = pstmt.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
	
	//중복된 ID가 있는지 조회 
	public int doubleCheck(Member mem) {
		int result =0;
		
		try {
			conn();
			
			String sql = "SELECT COUNT(member_id)\r\n"
					+ "FROM user_info\r\n"
					+ "WHERE member_id =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mem.getMemberId());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				if(rs.getInt("COUNT(member_id)") != 0) {
					result = 2;
				}else {
					 sql = "INSERT INTO user_info\r\n"
							+ "VALUES (?,?,?,?, 0.1, 0)";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, mem.getMemberId());
					pstmt.setString(2, mem.getMemberPw());
					pstmt.setString(3, mem.getMemberName());
					pstmt.setString(4, mem.getCarNo());
					
					result = pstmt.executeUpdate();
				}
			}
	
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
	
	
	
}
