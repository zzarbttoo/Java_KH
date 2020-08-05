package com.my.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.my.dto.MyBoardDto;

public class MyBoardDao {

	// 전체 출력
	public List<MyBoardDto> selectList() {

		// 1. driver 연결
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("1. driver 연결");
		} catch (ClassNotFoundException e) {
			System.out.println("[error] 1.");
			e.printStackTrace();
		}

		// 2. 계정 연결
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "kh";
		String password = "kh";

		Connection con = null;

		try {
			con = DriverManager.getConnection(url, user, password);
			System.out.println("2. 계정 연결");
		} catch (SQLException e) {
			System.out.println("[error] 2");
			e.printStackTrace();
		}

		// 3. query 준비

		Statement stmt = null;
		ResultSet rs = null;

		List<MyBoardDto> list = new ArrayList<MyBoardDto>();

		String sql = " SELECT MYNO, MYNAME, MYTITLE, MYCONTENT, MYDATE " + " FROM MYBOARD " + " ORDER BY MYNO DESC ";

		try {
			stmt = con.createStatement();
			System.out.println("3. query 준비 : " + sql);
			// 4. query 실행 및 리턴

			rs = stmt.executeQuery(sql);
			System.out.println("4. query 실행 및 리턴");

			while (rs.next()) {

				MyBoardDto dto = new MyBoardDto();
				dto.setMyno(rs.getInt(1));
				dto.setMyname(rs.getString(2));
				dto.setMytitle(rs.getString(3));
				dto.setMycontent(rs.getString(4));
				dto.setMydate(rs.getDate(5));

				list.add(dto);

			}

		} catch (SQLException e) {
			System.out.println("error 3.4");
			e.printStackTrace();
		} finally {

			// 5. db종료
			try {

				rs.close();
				stmt.close();
				con.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		return list;

	}

	// 선택 출력

	public MyBoardDto selectOne(int myno) {

		// 1.
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("1. driver 연결");
		} catch (ClassNotFoundException e) {
			System.out.println("[error] 1.");
			e.printStackTrace();
		}

		// 2.

		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "kh";
		String password = "kh";

		Connection con = null;

		try {
			con = DriverManager.getConnection(url, user, password);
			System.out.println("계정 연결");
		} catch (SQLException e) {
			System.out.println("[error] 2.");
			e.printStackTrace();
		}
		// 3.

		PreparedStatement pstm = null;
		ResultSet rs = null;
		MyBoardDto dto = null;

		String sql = " SELECT MYNO, MYNAME, MYTITLE, MYCONTENT, MYDATE " + " FROM MYBOARD " + " WHERE MYNO = ? ";

		try {
			pstm = con.prepareStatement(sql);

			pstm.setInt(1, myno);
			System.out.println("3. query 준비 :" + sql);

			rs = pstm.executeQuery();
			System.out.println("4. query 실행 및 리턴");

			while (rs.next()) {

				// 여기서 선언하는거랑 앞에서 하는 것은 좀 다르다
				dto = new MyBoardDto();
				dto.setMyno(rs.getInt(1));
				dto.setMyname(rs.getString(2));
				dto.setMytitle(rs.getString(3));
				dto.setMycontent(rs.getString(4));
				dto.setMydate(rs.getDate(5));

			}
		} catch (SQLException e) {
			System.out.println("[error] 3.4.");
			e.printStackTrace();
		} finally {

			try {
				rs.close();
				pstm.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return dto;
	}

	// 추가
	public int insert(MyBoardDto dto) {

		// 1.

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("1. driver 생성");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("1 error");
		}

		// 2.

		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "kh";
		String password = "kh";

		Connection con = null;

		try {
			con = DriverManager.getConnection(url, user, password);
			System.out.println("2. 연결");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("error 2");
		}

		// 3.

		PreparedStatement pstm = null;
		int res = 0;

		String sql = " INSERT INTO MYBOARD " + " VALUES (MYSEQ.NEXTVAL, ?, ?, ?, SYSDATE) ";

		// 4.

		try {

			pstm = con.prepareStatement(sql);
			pstm.setString(1, dto.getMyname());
			pstm.setString(2, dto.getMytitle());
			pstm.setString(3, dto.getMycontent());
			System.out.println("3. 쿼리 준비");

			System.out.println("4. 쿼리 실행 및 리턴");
			res = pstm.executeUpdate();
			System.out.println();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {

				System.out.println("db 종료");
				pstm.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		// 5.

		return res;

	}

	// 수정
	public int update(MyBoardDto dto) {

		
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
			System.out.println("2. 계정 연결");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("[error]2.");
		}
		
		//3. 
		PreparedStatement pstm = null;
		int res = 0;
		
		String sql = " UPDATE MYBOARD SET MYTITLE = ?, MYCONTENT = ? WHERE MYNO = ? ";
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, dto.getMytitle());
			pstm.setString(2, dto.getMycontent());
			pstm.setInt(3, dto.getMyno());
			System.out.println("3. query 준비 : " + sql);
			
		res = pstm.executeUpdate();
		System.out.println("5");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
			try {
				pstm.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		System.out.println("어디서 에러 나는거냥랴ㅓ니어 ㅎ무너후매너윰재");
		System.out.println(res);
		
		return res;

	}

	// 삭제

	public int delete(int myno) {
		
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
			System.out.println("2. 계정 연결");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("2. error");
		}
		
		PreparedStatement pstm = null;
		int res = 0;
		
		
		String sql = " DELETE FROM MYBOARD WHERE MYNO = ? ";
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, myno);
			System.out.println("3. query 준비" + sql);
			
			
			//4. 
			res = pstm.executeUpdate();
			System.out.println("4. query 실행 및 리턴");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			
			try {
				pstm.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			System.out.println("5. db 종료");
		}
		
		
		return res;
		
		/*
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

		PreparedStatement pstm = null;
		int res = 0;

		String sql = " DELETE FROM MYBOARD WHERE MYNO = ? ";

		try {

			pstm = con.prepareStatement(sql);
			pstm.setInt(1, myno);
			
			res = pstm.executeUpdate();
			
			if(res > 0) {
				
				System.out.println("");
			}else {
				
				System.out.println("fail");
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return res;
		
		*/
		
	
	}

}
