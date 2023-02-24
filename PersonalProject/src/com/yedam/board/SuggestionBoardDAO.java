package com.yedam.board;

import java.util.ArrayList;
import java.util.List;

import com.yedam.common.DAO;

public class SuggestionBoardDAO extends DAO {
	
	//싱글톤
	private static SuggestionBoardDAO sugDao = new SuggestionBoardDAO();
	
	private SuggestionBoardDAO() {
		
	}
	
	public static SuggestionBoardDAO getInstance() {
		return sugDao;
	}
	
	
	//게시 제목 페이지
	
	
	//게시 내용 보기
	public SuggestionBoard viewSuggestBoard(){
		SuggestionBoard sug = new SuggestionBoard() ;
		
		try {
			conn();
			String sql = "SELECT *\r\n"
					+ "FROM suggestion_board\r\n"
					+ "WHERE sugboard_id =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sug.getSugBoardId());
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				sug = new SuggestionBoard();
				sug.setSugBoardId(rs.getInt("sugboard_id"));
				sug.setMemberId(rs.getString("member_id"));
				sug.setSugSubject(rs.getString("sugboard_subject"));
				sug.setSugContents(rs.getString("sugboard_contents"));
				sug.setSugDate(rs.getDate("sugboard_date"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return sug;
	}
	
	//게시글 작성
	public int insertSuggestion(SuggestionBoard sug) {
		int result = 0;
		
		try {
			conn();
			String sql = "INSERT INTO suggestion_board\r\n"
					+ "VALUES(?, ?, ?, ?,sysdate)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sug.getSugBoardId());
			pstmt.setString(2, sug.getMemberId());
			pstmt.setString(3, sug.getSugSubject());
			pstmt.setString(4, sug.getSugContents());
			
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
	
	
	//게시글 수정
	public int updateSuggestion(SuggestionBoard sug) {
		int result = 0;
		
		try {
			conn();
			String sql = "UPDATE suggestion_board\r\n"
					+ "SET sugboard_subject = ?, sugboard_contents = ?\r\n"
					+ "WHERE sugboard_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sug.getSugSubject());
			pstmt.setString(2, sug.getSugContents());
			pstmt.setString(3, sug.getMemberId());
			
			result = pstmt.executeUpdate();		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
	
	
	//게시글 삭제
	public int deleteSuggestion(SuggestionBoard sug) {
		int result = 0;
		try {
			conn();
			String sql = "DELETE FROM suggestion_board\r\n"
					+ "WHERE sugboard_id =? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sug.getSugBoardId());
			
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		
		return result;
	}

	
	
	//게시판 삭제한 내용을 기준으로 번호 재정렬
	//
	
	
}
