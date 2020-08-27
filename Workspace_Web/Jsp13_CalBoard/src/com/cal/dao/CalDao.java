package com.cal.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.cal.dto.CalDto;

public class CalDao {

	
	public int insertCalBoard(CalDto dto) {
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "kh";
		String pw = "kh";
		
		Connection con = null;
		
		try {
			con = DriverManager.getConnection(url, user, pw);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		PreparedStatement pstm = null;
		int res = 0;
		
		String sql = " INSERT INTO CALBOARD VALUES(CALBOARDSEQ.NEXTVAL, ?, ?, ?, ?, SYSDATE) ";
		
		try {
			pstm = con.prepareStatement(sql);
			
			pstm.setString(1, dto.getId());
			pstm.setString(2, dto.getTitle());
			pstm.setString(3, dto.getContent());
			pstm.setString(4, dto.getMdate());
			
			res = pstm.executeUpdate();
			
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
		
				
	
		return res;
		
	}
	
}
