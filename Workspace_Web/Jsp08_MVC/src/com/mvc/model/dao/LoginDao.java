package com.mvc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import static com.mvc.db.JDBCTemplate.*;

import com.mvc.model.dto.LoginDto;

public class LoginDao {

	public boolean login() {
		
		return true;
		
	}
	
	public List<LoginDto> selectList(){
		
		Connection con = getConnection();
		PreparedStatement pstm = null;
		
		String sql = " SELECT NUM, WRITER, ID, PASSWORD, PHONENUMBER, COMDATE FROM LOGIN ";
		
		
				
		
		return null;
		
	}
	
}
