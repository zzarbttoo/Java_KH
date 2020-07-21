package com.test01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class MTest {

	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		int select = 0;

		while (select != 6) {
			System.out.println("menu 선택");
			System.out.println("1. 전체 출력");
			System.out.println("2. 선택 출력");
			System.out.println("3. 추가");
			System.out.println("4. 수정");
			System.out.println("5. 삭제");
			select = sc.nextInt();

			switch (select) {

			case 1:
				selectList();
				break;
			case 2:
				selectOne();
				break;
			case 3:
				insert();
				break;
			case 4:
				update();
				break;
			case 5:
				delete();
				break;
			case 6:
				System.exit(0);
			}

		}

	}

	public static void selectList() {
		// 1. 2.
		Connection con = getConnection();
		String sql = " SELECT MNO, MNAME, NICKNAME FROM MYTEST ";

		Statement stmt = null;

		try {
			stmt = con.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		ResultSet rs = null;

		try {
			rs = stmt.executeQuery(sql);
			while (rs.next()) {

				System.out.print(rs.getInt(1));
				System.out.print(rs.getString(2));
				System.out.println(rs.getString(3));
				System.out.println();

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				stmt.close();
				con.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		// 3.

	}

	public static void selectOne() {

		Connection con = getConnection();

		Scanner sc = new Scanner(System.in);
		int selectNum = sc.nextInt();

		String sqlSelect = " SELECT MNO, MNAME, NICKNAME FROM MYTEST WHERE MNO = " + selectNum;

		Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sqlSelect);

			while (rs.next()) {

				System.out.print(rs.getInt(1));
				System.out.print(rs.getString(2));
				System.out.print(rs.getString(3));
				System.out.println();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				stmt.close();
				con.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public static void insert() {

		Connection con = getConnection();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자 입력");
		int num = sc.nextInt();
		System.out.println("이름 입력");
		String name = sc.next();
		System.out.println("닉네임 입력");
		String nickname = sc.next();
		
		String sqlInsert = " INSERT INTO MYTEST VALUES(?, ?, ?) ";
		PreparedStatement pstm = null;
		int res = 0;
		
		
		try {
			pstm = con.prepareStatement(sqlInsert);
			pstm.setInt(1, num);
			pstm.setString(2, name);
			pstm.setString(3, nickname);
			
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

	public static void update() {

		Connection con = getConnection();
	
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자 입력");
		int num = sc.nextInt();
		System.out.println("이름 입력");
		String name = sc.next();
		System.out.println("닉네임 입력");
		String nickName = sc.next();
		
		
		String sqlUpdate = " UPDATE MYTEST SET MNAME = ?, NICKNAME = ? WHERE MNO = ? ";
		PreparedStatement pstm = null;
		
		int res = 0;
		
		try {
			pstm = con.prepareStatement(sqlUpdate);
			pstm.setString(2, name);
			pstm.setString(3, nickName);
			
			res = pstm.executeUpdate();
			
			if(res > 0) {
				
				System.out.println("입력 성공");
			}else {
				System.out.println("입력 실패");
			}
			
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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

	public static void delete() {

		Connection con = getConnection();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자 입력");
		int num = sc.nextInt();
		
		
		String sqlDel = " DELETE FROM MYTEST WHERE MNO = " + num;
		
		Statement stmt = null;
		int res = 0;
		
		
		try {
			stmt = con.createStatement();
			res = stmt.executeUpdate(sqlDel);
			
			if(res>0) {
				System.out.println("삭제 성공");
			}else {
				System.out.println("삭제 실패");
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
			try {
				stmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
	}

	public static Connection getConnection() {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
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
		
		return con;
	}

}
