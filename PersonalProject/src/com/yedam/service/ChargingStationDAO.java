package com.yedam.service;

import java.util.ArrayList;
import java.util.List;

import com.yedam.common.DAO;

public class ChargingStationDAO extends DAO{
	
	//싱글톤
	public static ChargingStationDAO cDao = new ChargingStationDAO();
	
	private ChargingStationDAO () {
		
	}
	
	public static ChargingStationDAO getInstance() {
		return cDao;
	}
	
	//빈자리 조회  
	//locNo : 빈자리 조회 시 입력해줄 자리 번호
	public List<ChargingStation> emptyCheck() {
		List<ChargingStation> list = new ArrayList<>();
		
		ChargingStation charg = null;
		
		try {
			conn();
			
			String sql = "SELECT *\r\n"
					+ "FROM charging_station\r\n"
					+ "ORDER BY location_id";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				charg = new ChargingStation();
				charg.setLocationId(rs.getInt("location_id"));
				list.add(charg);
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return list;
	}
	
	
	//충전 등록 
	public  int regisCharging(ChargingStation c) {
		int result = 0;
		try {
			conn();
			String sql = "SELECT COUNT(location_id)\r\n"
					+ "FROM charging_station\r\n"
					+ "WHERE location_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,  c.getLocationId());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				if(rs.getInt("COUNT(location_id)") != 0) {
					result = 2;
				}else {
					sql = "INSERT INTO charging_station\r\n"
							+ "VALUES(?,?,?,sysdate,?)";
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, c.getLocationId());
					pstmt.setString(2, c.getCarNo());
					pstmt.setString(3, c.getChargType());
					pstmt.setInt(4, c.getBatterRemain());
					
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
	
	
	//비회원 결제
	public ChargingStation payCharging(int paykey) {
		ChargingStation charg = null;
		
		try {
			conn();
			String sql = "SELECT charg_type, battery_remains\r\n"
					+ "FROM charging_station\r\n"
					+ "WHERE location_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, paykey);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				charg = new ChargingStation();
				charg.setChargType(rs.getString("charg_type"));
				charg.setBatterRemain(rs.getInt("battery_remains"));
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return charg;
	}
	

	//등록 해제
	public int deletCharging(int locaId) {
		int result = 0;
		
		try {
			conn();
			 String sql = "DELETE FROM charging_station\r\n"
			 		+ "WHERE location_id = ?";
			 pstmt = conn.prepareStatement(sql);
			 pstmt.setInt(1, locaId);
			 
			 result = pstmt.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
	
	
}
