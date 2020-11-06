package com.weather.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class dao {

	public List<Test> selectList(){
	
		
	Connection connection = getConnection();
	PreparedStatement pstm  = null;
	List<Test> list = null;
	ResultSet rs = null;
	
	String sql = " SELECT * FROM TEST " ;
	
	try {
		pstm = connection.prepareStatement(sql);
		rs = pstm.executeQuery();
		
		while(rs.next()) {
			
			Test test= new Test();
			
			test.setSeq(rs.getInt(1));
			test.setTitle(rs.getString(2));
			test.setContent(rs.getString(3));
			test.setWriter(rs.getString(4));
			test.setRegdate(rs.getDate(5));
			
			list.add(test);
			
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	}finally {
		
		try {
			con.close();
			pstm.close();
			rs.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	return list;
}
