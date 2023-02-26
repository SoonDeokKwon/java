package com.yedam.board;

import java.util.ArrayList;
import java.util.List;

import com.yedam.common.DAO;
import com.yedam.service.Member;

public class SuggestionBoardDAO extends DAO {
	
	//싱글톤
	private static SuggestionBoardDAO sugDao = new SuggestionBoardDAO();
	
	private SuggestionBoardDAO() {
		
	}
	
	public static SuggestionBoardDAO getInstance() {
		return sugDao;
	}
	
	
	//게시 제목 페이지
	public List<SuggestionBoard> listSuggestBoard(){
		List<SuggestionBoard> list = new ArrayList<>();
		SuggestionBoard sug = null;
		
		try {
			conn();
			String sql = "SELECT sugboard_id, sugboard_subject\n"
					+ "FROM suggestion_board";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				sug = new SuggestionBoard();
				sug.setSugBoardId(rs.getInt("sugboard_id"));
				sug.setSugSubject(rs.getString("sugboard_subject"));
				list.add(sug);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return list;
	}
	
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
			
			String sql = "SELECT sugboard_id\n"
					+ "FROM suggestion_board\n"
					+ "WHERE sugboard_id =1";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				if(rs.getInt("sugboard_id") != 1){
					sql = "INSERT INTO suggestion_board\r\n"
							+ "VALUES(1, ?, ?, ?,sysdate)";
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, sug.getSugBoardId());
					pstmt.setString(2, sug.getMemberId());
					pstmt.setString(3, sug.getSugSubject());
					pstmt.setString(4, sug.getSugContents()); 
				}else {
					sql = "INSERT INTO suggestion_board \n"
							+ "SELECT sugboard_id+1 , ?,?, ?, ?, sysdate\n"
							+ "    FROM    suggestion_board sb\n"
							+ "    WHERE sugboard_id = (\n"
							+ "                                        SELECT MAX(sugboard_id)\n"
							+ "                                        FROM suggestion_board\n"
							+ "                                        )";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, sug.getMemberId());
					pstmt.setString(2, sug.getMemberName());
					pstmt.setString(3, sug.getSugSubject());
					pstmt.setString(4, sug.getSugContents());
					
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
	
	
	//관리자용 게시글 수정
	public int adminUpdateSuggest(SuggestionBoard sug) {
		int result = 0;
		
		try {
			conn();
			String sql = "UPDATE suggestion_board\r\n"
					+ "SET sugboard_subject = ?, sugboard_contents = ?, sugboard_date = sysdate \r\n"
					+ "WHERE sugboard_id = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sug.getSugSubject());
			pstmt.setString(2, sug.getSugContents());
			pstmt.setInt(3, sug.getSugBoardId());
			
			result = pstmt.executeUpdate();		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
	
	//회원용 게시글 수정
	public int memUpdateSuggest(SuggestionBoard sug) {
		int result = 0;
		
		try {
			conn();
			String sql = "UPDATE suggestion_board\r\n"
					+ "SET sugboard_subject = ?, sugboard_contents = ?, sugboard_date = sysdate \r\n"
					+ "WHERE sugboard_id = ?, member_id = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sug.getSugSubject());
			pstmt.setString(2, sug.getSugContents());
			pstmt.setInt(3, sug.getSugBoardId());
			pstmt.setString(4, sug.getMemberId());
			
			result = pstmt.executeUpdate();		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
	
	
	//관리자용 게시글 삭제
	public int adminDeleteSuggest(SuggestionBoard sug) {
		int result = 0;
		try {
			conn();
			String sql = "DELETE FROM suggestion_board\r\n"
					+ "WHERE sugboard_id =?";
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
	
	//회원용 게시글 삭제
	public int memDeleteSuggest(SuggestionBoard sug) {
		int result = 0;
		try {
			conn();
			String sql = "DELETE FROM suggestion_board\r\n"
					+ "WHERE sugboard_id =?, member_id = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sug.getSugBoardId());
			pstmt.setString(2, sug.getMemberId());
			
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
	public int reordering(SuggestionBoard sug) {
		int result = 0;
		
		try {
			conn();
			
			String sql = "UPDATE suggestion_board\n"
					+ "SET sugboard_id = sugboard_id - 1\n"
					+ "WHERE sugboard_id >?";
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
	
	
	
}
