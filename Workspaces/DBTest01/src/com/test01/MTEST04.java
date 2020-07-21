package com.test01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class MTEST04 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		//INSERT INTO MYTEST VALUES( MNO, 'MNAME', 'NICKNAME');
		
		//1. driver 연결
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		//2. 
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "kh";
		String password = "kh";
		
		Connection con = DriverManager.getConnection(url, user, password);
	
		//3.query 준비
		
		Statement stmt = con.createStatement();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("번호 입력 ");
		int num = sc.nextInt();
		System.out.println("이름 입력");
		String name = sc.next();
		System.out.println("별명 입력");
		String nickName = sc.next();
		
		String sqlInsert = " INSERT INTO MYTEST VALUES( " + num + " ,' " + name + " ',' " + nickName + " ') ";
		String sqlPrint = " SELECT MNO, MNAME, NICKNAME FROM MYTEST ";
	
		
		// 4. query 실행 및 리턴
		int resultInt = stmt.executeUpdate(sqlInsert);
		
		if(resultInt > 0) {
			System.out.println("입력 성공");
		}else {
			System.out.println("입력 실패");
		}
		
//		ResultSet rs = stmt.executeQuery(sqlPrint);
//		
//		while(rs.next()) {
//			System.out.print(rs.getInt(1) + " ");
//			System.out.print(rs.getString(2) + " ");
//			System.out.print(rs.getString(3) + " ");
//			System.out.println();
//		}
//		
//		
		stmt.close();
		con.close();
		
		
		
		
		
		
		
		
		
		
	}
}
