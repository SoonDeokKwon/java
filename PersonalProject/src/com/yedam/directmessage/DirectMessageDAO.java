package com.yedam.directmessage;

import java.util.ArrayList;
import java.util.List;

import com.yedam.common.DAO;

public class DirectMessageDAO extends DAO{
	
	//싱글톤
	private static DirectMessageDAO dmDao = new DirectMessageDAO();
	
	private DirectMessageDAO() {
		
	}
	
	private static DirectMessageDAO getInstance() {
		return dmDao;
	}
	
	//쪽지 보내기
	public int sendDM(DirectMessage DM) {
		int result = 0;
		
		try {
			conn();
			String sql = "INSERT INTO direct_message\r\n"
					+ "VALUES( ?, ?, ?,  ?, ?,  sysdate)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, DM.getReceiverId());
			pstmt.setString(2, DM.getReceiverName());
			pstmt.setString(3, DM.getSenderId());
			pstmt.setString(4, DM.getSenderName());
			pstmt.setString(5, DM.getDmContents());
			result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
	
	
	//받은 쪽지 확인
	public List<DirectMessage> reciveDMlist(String receiver){
		List<DirectMessage> list = new ArrayList<>();
		DirectMessage DM = null;
		
		try {
			conn();
			String sql = "DELETE FROM direct_message\r\n"
					+ "WHERE receiver_id =? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, receiver );
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				DM = new DirectMessage();
				DM.setReceiverId(rs.getString("receiver_id"));
				DM.setReceiverName(rs.getString("receiver_name"));
				DM.setSenderId(rs.getString("sender_id"));
				DM.setSenderName(rs.getString("sender_name"));
				DM.setDmContents(rs.getString("dm_contents"));
				DM.setDmDate(rs.getDate("dm_date"));
				list.add(DM);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return list;
	}
	
	//받은 쪽지함 비우기
	public int receiveDelete(DirectMessage DM) {
		int result = 0;
		
		try {
			conn();
			String sql = "DELETE FROM direct_message\r\n"
					+ "WHERE receiver_id = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, DM.getReceiverId());
			
			result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
	
	
	//보낸 쪽지 내용 확인
	public List<DirectMessage> sendDMlist(String sender){
		List<DirectMessage> list = new ArrayList<>();
		DirectMessage DM = null;
		
		try {
			conn();
			String sql = "DELETE FROM direct_message\r\n"
					+ "WHERE sender_id =? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sender );
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				DM = new DirectMessage();
				DM.setReceiverId(rs.getString("receiver_id"));
				DM.setReceiverName(rs.getString("receiver_name"));
				DM.setSenderId(rs.getString("sender_id"));
				DM.setSenderName(rs.getString("sender_name"));
				DM.setDmContents(rs.getString("dm_contents"));
				DM.setDmDate(rs.getDate("dm_date"));
				list.add(DM);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return list;
	}
	
	//보낸 쪽지함 비우기
	public int sendDelete(DirectMessage DM) {
		int result = 0;
		
		try {
			conn();
			String sql = "DELETE FROM direct_message\r\n"
					+ "WHERE sender_id = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, DM.getReceiverId());
			
			result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
	
	
}
