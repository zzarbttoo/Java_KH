package com.test01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class MTest04_try {

	
	public static void main(String[] args) {
		//INSERT INTO MYTEST VALUES( MNO, 'MNAME', 'NICKNAME');
		
		
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
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		Scanner sc = new Scanner(System.in);
		System.out.println("번호 입력 : ");
		int num = sc.nextInt();
		System.out.println("이름 입력 : ");
		String name = sc.next();
		System.out.println("별명 입력 : ");
		String nickName = sc.next();
		
		String sqlInsert = " INSERT INTO MYTEST VALUES(? , ? , ?) " ;
		PreparedStatement pstm = null;
		
		int res = 0;
		
		try {
			
			//sql문이 어디에 들어가느냐에 따라 다르다
			pstm = con.prepareStatement(sqlInsert);
			pstm.setInt(1, num);
			pstm.setString(2, name);
			pstm.setString(3, nickName);
			
			res = pstm.executeUpdate();
			if(res > 0) {
				System.out.println("입력 성공");
			}else {
				
				System.out.println("입력 실패");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
			
			try {
				pstm.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		
		
		
	}
}
