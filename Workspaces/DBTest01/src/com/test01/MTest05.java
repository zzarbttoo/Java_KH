package com.test01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class MTest05 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		//UPDATE MYTEST SET NICKNAME = '???' WHERE MNO = ???
		
		//1.
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		//2.
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "kh";
		String password = "kh";
		
		
		Connection con = DriverManager.getConnection(url, user, password);
		//3.
	
		Scanner sc = new Scanner(System.in);
		
		System.out.println("name 수정");
		String delName = sc.next();
		System.out.println("nick 수정");
		String delNick = sc.next();
		System.out.println("num 수정");
		int delNum = sc.nextInt();
		
//		String sqlSelect =
		String sqlUpdate = " UPDATE MYTEST SET NICKNAME = ' " + delName + " ' WHERE MNO = " + delNum;
		
		Statement stmt = con.createStatement();
		
		int updateInt = stmt.executeUpdate(sqlUpdate);
		if(updateInt > 0) {
			System.out.println("수정 성공");
		}else {
			System.out.println("수정 실패");
		}
//		int deleteInt = stmt.executeUpdate(sqlDelete);
		
		//4.
		//4-1. SELECT
		//4-2/ INSERT/ UPDATE/DELETE
		
		
		//5.
		
		stmt.close();
		con.close();
		
		
		
		
		
	}
	
	
}
