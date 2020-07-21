package com.test01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class MTest06 {

	public static void main(String[] args) {
		
		//DELETE FROM MYTEST WHERE MNO = ???;
		//1.
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		//2.
		
		String url= "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "kh";
		String password= "kh";
		
		Connection con = null;
		
		
		try {
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//3. 
		
		Statement stmt = null;
		Scanner sc = new Scanner(System.in);
		System.out.println("삭제할 번호 : ");
		int mno = sc.nextInt();
		String sql = " DELETE FROM MYTEST WHERE MNO = " + mno;
		
		int res = 0;
		try {
			stmt = con.createStatement();
			
			//4.
			
			res = stmt.executeUpdate(sql);
			if(res>0) {
				System.out.println("삭제 성공");
			}else {
				System.out.println("삭제 실패");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			try {
				//5. 
				stmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		
		
		
	}
	
	
}
