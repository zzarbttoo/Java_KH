package com.member.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//DB와 연결하는 공통 부분을 클래스로 작성 <- DB와 연결하는 일이 빈번하게 있겠다
//new 연산자를 사용하지 않도록, static으로 작성(메모리 낭비를 줄일 수 있다)
public class JDBCTemplate {

	// 1. driver 연결
	// 2. 계정 연결
	public static Connection getConnection() {

		// 1.
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
			//자동으로 커밋하는 것을 멈추도록 설정(내가 원할 때만 커밋하도록 설정)
			con.setAutoCommit(false);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return con;

	}

	//원할 때 커밋 해주도록 한다
	public static void commit(Connection con) {
		
		try {
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	//커밋이 있다면 롤백도 필요하다
	public static void rollback(Connection con) {
		
		try {
			con.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 5. close : finally에서 trycatch 하는                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        거 지저분해서 따로 만들었다
	public static void close(Connection con) {

		try {
			con.close();
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

	public static void close(ResultSet rs) {

		
		try {
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
