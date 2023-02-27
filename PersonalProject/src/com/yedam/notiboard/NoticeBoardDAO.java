package com.yedam.notiboard;

import java.util.ArrayList;
import java.util.List;

import com.yedam.common.DAO;

public class NoticeBoardDAO extends DAO{

	//싱글톤
	private static NoticeBoardDAO noticeDao = new NoticeBoardDAO();
	
	private NoticeBoardDAO() {
		
	}
	
	public static NoticeBoardDAO getInstance() {
		return noticeDao;
	}
	
	
	//게시 제목 리스트
	public List<NoticeBoard> listNoticeBoard(){
		List <NoticeBoard> list = new ArrayList<>();
		NoticeBoard noti = null;
		
		try {
			conn();
			String sql = "SELECT *\r\n"
					+ "FROM noticeboard\r\n"
					+ "ORDER BY notiboard_id";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				noti = new NoticeBoard();
				noti.setNoticeId(rs.getInt("notiboard_id"));
				noti.setMemberName(rs.getString("member_name"));
				noti.setNotiSubject(rs.getNString("notiboard_subject"));
				list.add(noti);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return list;
	}
	
	//게시물 내용 보기
	public NoticeBoard viewNotiBoard(int nId) {
		NoticeBoard noti = null;
		
		try {
			conn();
			String sql = "SELECT *\r\n"
					+ "FROM noticeboard\r\n"
					+ "WHERE notiboard_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, nId);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				noti =  new NoticeBoard();
				noti.setNoticeId(rs.getInt("notiboard_id"));
				noti.setMemberId(rs.getString("member_id"));
				noti.setMemberName(rs.getString("member_name"));
				noti.setNotiSubject(rs.getString("notiboard_subject"));
				noti.setNotiContents(rs.getString("notiboard_contents"));
				noti.setNotiBoardDate(rs.getDate("notiboard_date"));
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			disconn();
		}
		return noti;
	}
	
	//게시물 작성
	public int insertNotiBoard(NoticeBoard noti) {
		int result = 0;
		
		try {
			conn();
			String sql = "SELECT notiboard_id\r\n"
					+ "FROM noticeboard\r\n"
					+ "WHERE notiboard_id = 1";
			pstmt= conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				if(rs.getInt("notiboard_id") != 1) {
					sql = "INSERT INTO noticeboard\r\n"
							+ "VALUES (1, 'admin01', '소크라테스', ?, ?, sysdate)";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, noti.getNotiSubject());
					pstmt.setString(2, noti.getNotiContents());
					result = pstmt.executeUpdate();
				}else {
					sql = "INSERT INTO  noticeboard\r\n"
							+ "SELECT notiboard_id + 1 , 'admin01', '소크라테스', ? , ? ,sysdate\r\n"
							+ "    FROM    noticeboard\r\n"
							+ "    WHERE notiboard_id = (\r\n"
							+ "                                        SELECT MAX(notiboard_id)\r\n"
							+ "                                        FROM noticeboard \r\n"
							+ "                                        )";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, noti.getNotiSubject());
					pstmt.setString(2, noti.getNotiContents());
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
	
	//게시물 수정
	public int modifyNoticeBoard(NoticeBoard noti) {
		int result = 0;
		
		try {
			conn();
			String sql = "UPDATE noticeboard\r\n"
					+ "SET notiboard_subject = ?, notiboard_contents = ? \r\n"
					+ "WHERE notiboard_id = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,  noti.getNotiSubject());
			pstmt.setString(2, noti.getNotiContents());
			pstmt.setInt(3, noti.getNoticeId());
			
			result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
	
	//게시물 삭제
	public int deleteNotiBoard(NoticeBoard noti) {
		int result =0;
		
		try {
			conn();
			String sql = "DELETE FROM noticeboard\r\n"
					+ "WHERE notiboard_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, noti.getNoticeId());
			
			result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
	
	//게시물 삭제 후 게시번호 재정렬
	public int notiReordering(NoticeBoard noti){
		int result = 0;
		
		try {
			conn();
			String sql = "UPDATE noticeboard\r\n"
					+ "SET notiboard_id = notiboard_id - 1\r\n"
					+ "WHERE notiboard_id > ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, noti.getNoticeId());
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
	
	
	
	
	
}
