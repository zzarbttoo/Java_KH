package com.bike.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.bike.dto.BikeDto;

public class BikeDao {

	
	public boolean insert(List<BikeDto> list) {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "kh";
		String password = "kh";
		
		
		Connection con = null;
		
		try {
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		PreparedStatement pstm = null;
		int res = 0;
		String sql = " INSERT INTO KOREABIKE VALUES (?, ?, ?, ?, ?) ";
		
		
		try {
			
			pstm = con.prepareStatement(sql);
			//sql 문이 list 길이만큼 만들어진다
			for(int i = 0; i < list.size(); i++) {
				
				BikeDto dto = list.get(i);
				pstm.setString(1, dto.getName());
				pstm.setString(2, dto.getAddr());
				pstm.setDouble(3, dto.getLatitude());
				pstm.setDouble(4, dto.getLongitude());
				pstm.setInt(5, dto.getBike_count());
				
				//메모리에 잠깐 저장하는 코드 
				//addBatch() : pstm로 준비된 sql문을 memory에 임시저장시키는 기능 수행
				// -> executeBatch() 가 호출될 시, 저장된 sql문들을 db로 한번에 전달 및 실행
				//connection 한번으로 메모리에 저장한 임시 객체를 한번에 보내줄 수 있다
				pstm.addBatch();
				
				
			}
			System.out.println("sql" + sql);
			
			//-2:성공 -3:실패
			int[] result = pstm.executeBatch();
			
			for(int i = 0; i < result.length; i++) {
				
				if(result[i] == -2) {
					res++;
				}
			}
			
			if(res  == list.size()) {
				
				con.commit();
				
			}else {
				
				con.rollback();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
			try {
				pstm.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return (res == list.size())? true:false;
		
	}
	
	//KOREABIKE table 모든 row 삭제 
	public boolean delete() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "kh";
		String password = "kh";
	
		
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		PreparedStatement pstm = null;
		int res = 0;
		//코리아 바이크 안의 모든 로우가 지워진다
		String sql = " DELETE FROM KOREABIKE ";
		
		try {
			pstm = con.prepareStatement(sql);
			res = pstm.executeUpdate();
			
			//사실 제대로 트랜직션 하려면 biz에서 그 갯수를 리턴받아서(select)해서 그거와 같으면 딜리트 해야한다
			//commit 과 rollback을 biz에서 처리해줘야한다
			if(res > 0) {
				
				con.commit();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally { 
			
			try {
				pstm.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return (res > 0) ? true : false;
	}
	
	
	
}
