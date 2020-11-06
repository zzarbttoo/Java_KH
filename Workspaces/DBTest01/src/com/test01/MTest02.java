package com.test01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class MTest02 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//특정 부서 번호를 입력하면, DEPT 테이블에서 해당 부서 번호에 맞는 row 한개 출력
		
		//1. driver 연결
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		//2. 계정 연결
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "kh";
		String password = "kh";
		
		
		Connection con = DriverManager.getConnection(url, user, password);	
		
		//3. query 준비
		
		Scanner sc = new Scanner(System.in);
		System.out.println("부서번호 입력");
		int deptno = sc.nextInt();
		
		Statement stmt = con.createStatement();
		String sql = " SELECT DEPTNO, DNAME, LOC " 
				+ " FROM DEPT "
				+ " WHERE DEPTNO = " + deptno;
		
		//4. query 실행 및 리턴
		
		ResultSet rs = stmt.executeQuery(sql);
		
		//리턴 받는 값이 한줄일지라도 while로 써주기
		while(rs.next()) {
			System.out.printf("%3d  %12s  %10s \n", rs.getInt(1), rs.getString(2), rs.getString(3));
		}
		
		//5. db 종료
		
		rs.close();
		stmt.close();
		con.close();
	}
}
