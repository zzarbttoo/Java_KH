package com.muldel.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTemplate {

	//jdbc는 singleton pattern으로 만들기도 한다
	
	//1. 2.
	public static Connection getConnection() {
		//driver 연결 -> ojdbc6.jar(library)
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("1. driver 연결");
			
		} catch (ClassNotFoundException e) {
			System.out.println("[error 1]");
			e.printStackTrace();
		}
		
		//2. 계정 연결 -> Connection 객체 생성
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "kh";
		String password = "kh";
		Connection con = null;
		
		try {
			con = DriverManager.getConnection(url, user, password);
			//오늘부터는 내가 원할 때만 커밋할 것이다
			con.setAutoCommit(false);
		} catch (SQLException e) {
			System.out.println("[error] 2.");
			e.printStackTrace();
		}
		
		return con;
		
	}
	
	public static void commit(Connection con) {
		
		try {
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void rollback(Connection con) {
		
		try {
			con.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	//close
	public static void close(Connection con) {
		
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void close(ResultSet rs) {
		
		try {
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Statement stmt) {
		
		
		try {
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
		
	
}
