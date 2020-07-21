package com.test01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MTest03 {

	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		//SELECT MNO, MNAME, NICKNAME, FROM MYTEST
		
		//1.
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		
		//2.
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "kh";
		String password = "kh";
		
		Connection con = DriverManager.getConnection(url, user, password);
		
		
		
		//3.
		
		Statement stmt = con.createStatement();

		String sql = " SELECT MNO, MNAME, NICKNAME FROM MYTEST ";
		
		//4.
		
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()) {
			
			System.out.print(rs.getInt(1) + " ");
			System.out.print(rs.getString(2)+ " ");
			System.out.print(rs.getString(3) + " ");
			System.out.println();
			
			
		}
		
		//5.
		
		rs.close();
		stmt.close();
		con.close();
		
		
	}
}
