package com.yedam.sugboard;

import java.util.ArrayList;
import java.util.List;

import com.yedam.common.DAO;

public class SugCommentDAO extends DAO{
	
	//싱글톤
	private static SugCommentDAO sCommentDao = new SugCommentDAO();
	
	private SugCommentDAO() {
		
	}
	
	public static SugCommentDAO getInstance() {
		return sCommentDao;
	}
	
	//댓글 보이게 하기
	public List<SugComment> listSugComment(int comId){
		List<SugComment> list = new ArrayList<>();
		SugComment comment = null;
		
		try {
			conn();
			String sql = "SELECT *\r\n"
					+ "FROM suggestion_comment\r\n"
					+ "WHERE sugboard_id = ?\r\n"
					+ "ORDER BY sugcomment_id";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, comId);
			rs= pstmt.executeQuery();
			
			while(rs.next()) {
				comment = new SugComment();
				comment.setSugCommentId(rs.getInt("sugcomment_id"));
				comment.setMemberId(rs.getString("member_id"));
				comment.setMemberName(rs.getString("member_name"));
				comment.setSugComment(rs.getString("sugcomment_contents"));
				comment.setSugCommentDate(rs.getDate("sugcomment_date"));
				list.add(comment);
			}	
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return list;
	}
	
	//댓글 입력
	public int insertSugComment(SugComment sCom) {
		int result =0;
		
		try {
			conn();
			String sql = "SELECT sugcomment_id\n"
					+ "FROM suggestion_comment\n"
					+ "WHERE sugcomment_id =1";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getInt("sugcomment_id") != 1) {
					sql = "INSERT INTO suggestion_comment\r\n"
							+ "VALUES(1, ?, ?, ?, ?, sysdate)";
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, sCom.getSugBoardId());
					pstmt.setString(2, sCom.getMemberId());
					pstmt.setString(3, sCom.getMemberName());
					pstmt.setString(4, sCom.getSugComment());
					result = pstmt.executeUpdate();
				}else {
					sql = "INSERT INTO  suggestion_comment  \r\n"
							+ "SELECT sugcomment_id + 1 , ?, ?, ?, ?, sysdate\r\n"
							+ "    FROM    suggestion_comment \r\n"
							+ "    WHERE sugcomment_id = (\r\n"
							+ "                                        SELECT MAX(sugcomment_id)\r\n"
							+ "                                        FROM suggestion_comment \r\n"
							+ "                                        )";
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, sCom.getSugBoardId());
					pstmt.setString(2, sCom.getMemberId());
					pstmt.setString(3, sCom.getMemberName());
					pstmt.setString(4, sCom.getSugComment());
					result = pstmt.executeUpdate();
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			disconn();
		}
		return result;
	}
	
	//댓글 수정
	public int modifySugComment(SugComment sCom) {
		int result =0;
		
		try {
			conn();
			String sql = "UPDATE suggestion_comment\r\n"
					+ "SET sugcomment_contents = ? \r\n"
					+ "WHERE sugcomment_id = ? AND member_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sCom.getSugComment());
			pstmt.setInt(2, sCom.getSugCommentId());
			pstmt.setString(3, sCom.getMemberId());
			
			result = pstmt.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
	
	
	//댓글 삭제
	public int deleteSugComment(SugComment sCom) {
		int result =0;
		
		try {
			conn();
			String sql = "DELETE FROM suggestion_comment\r\n"
					+ "WHERE sugcomment_id = ? AND member_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sCom.getSugCommentId());
			pstmt.setString(2, sCom.getMemberId());
			
			result = pstmt.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
	
	
	//댓글번호 재정렬
	public int SugComReordering(SugComment sCom) {
		int result = 0;
		
		try {
			conn();
			
			String sql = "UPDATE suggestion_comment\n"
					+ "SET sugcomment_id = sugcomment_id - 1\n"
					+ "WHERE member_id =? AND sugcomment_id > ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sCom.getMemberId());
			pstmt.setInt(2, sCom.getSugCommentId());
			
			result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
	
	
	
	
	
	
}
