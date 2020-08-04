package com.my.dao;

import java.sql.Connection;
import java.sql.DriverManager;
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
		String url = "jdbc:oracle:this:@localhst:1521:xe";
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

	// 추가

	// 수정

	// 삭제

}
