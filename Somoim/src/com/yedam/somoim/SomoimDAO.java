package com.yedam.somoim;

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
	
	
	
	
	//모든 회원 조회 -> 가입 날자 순서대로 조회
	
	
	
	
	//아이디로 회원 조회
	
	
	
	
	
	//이메일 변경
	
	
	
	
	//소모임 인원 강제 탈퇴
	
	
	
	
	
}
