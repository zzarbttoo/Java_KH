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

//DAO  : Data Access Object
public class MyBoardDao {

	public MyBoardDao() {

	}

	public List<MyBoardDto> select() {

		// 1. driver연결 -> ojdbc6.jar 안넣고 하면 classnotfound 된다
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		// 2. 계정 연결

		// database connection url <-지금은 컴퓨터 내부에 있어서 localhost에 있는 것이다
		// 나중에 세미 할때는 다르게 쓸 것이다 (학원에서 서버를 만들어 놓았따!)<-팀끼리 같은 데이터베이스를 공유할 수 있다
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "kh";
		String password = "kh";

		Connection con = null;

		try {
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// 3. query 준비
		String sql = " SELECT MYNO, MYNAME, MYTITLE, MYCONTENT, MYDATE FROM MYBOARD ORDER BY MYNO DESC ";

		Statement stmt = null;
		// table을 저장할 수 있는 객체
		ResultSet rs = null;

		List<MyBoardDto> list = new ArrayList<MyBoardDto>();
		MyBoardDto dto = null;

		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {

				dto = new MyBoardDto();

				dto.setMyno(rs.getInt(1));
				dto.setMyname(rs.getString(2));
				dto.setMytitle(rs.getString(3));
				dto.setMycontent(rs.getString(4));
				dto.setMydate(rs.getDate(5));

				list.add(dto);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

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

	public MyBoardDto selectOne(int myno) {

		System.out.println(myno);

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("여기에러냐1");
		}

		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "kh";
		String password = "kh";

		Connection con = null;

		try {
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();

			System.out.println("여기에러냐2");
		}

		String sql = " SELECT MYNO, MYNAME, MYTITLE, MYCONTENT, MYDATE FROM MYBOARD WHERE MYNO = ? ";

		PreparedStatement pstm = null;
		ResultSet rs = null;

		MyBoardDto dto = null;

		try {
			// statement <- 쿼리를 전달하고 실행시켜주는 애 그리고 리턴도 받아준다
			pstm = con.prepareStatement(sql);
			System.out.println("여기 에러냐 11");
			pstm.setInt(1, myno);

			System.out.println("여기 에러냐22");
			rs = pstm.executeQuery();

			dto = new MyBoardDto();

			System.out.println("여기 에러냐33");
			while (rs.next()) {

				dto.setMyno(rs.getInt(1));
				dto.setMyname(rs.getString(2));
				dto.setMytitle(rs.getString(3));
				dto.setMycontent(rs.getString(4));
				dto.setMydate(rs.getDate(5));

				System.out.println("여기 에러냐44");
			}

		} catch (SQLException e) {
			e.printStackTrace();

			System.out.println("여기에러냐3");
		} finally {

			try {
				pstm.close();
				rs.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();

				System.out.println("여기에러냐4");
			}

		}

		return dto;

	}

	// 추가 : 이름(myname), 제목(mytitle), 내용(mycontent)
	public int insert(MyBoardDto dto) {

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

		String sql = " INSERT INTO MYBOARD VALUES(MYSEQ.NEXTVAL, ?, ?, ?, SYSDATE) ";

		PreparedStatement pstm = null;
		int res = 0;

		try {
			pstm = con.prepareStatement(sql);

			pstm.setString(1, dto.getMyname());
			pstm.setString(2, dto.getMytitle());
			pstm.setString(3, dto.getMycontent());

			res = pstm.executeUpdate();

			if (res > 0) {

				System.out.println("성공");

			} else {

				System.out.println("실패");

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return res;

	}

	// 수정 : 제목 내용 번호 <-만일 수정한 날짜까지 바꾸고 싶다면 mydate도 바꿔주면 된다

	public int update(MyBoardDto dto) {

		
		//1. driver
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 연결 ");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		//2. 계정 연결
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
		
		//3. 쿼리 준비
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
		
			System.out.println(res);
			System.out.println("돼는거 맞냐냐냐");
			
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

	// 삭제 : 번호
	public int delete(int myno) {

		System.out.println("어디가 문제");
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

		String sql = " DELETE FROM MYBOARD WHERE MYNO = ? ";

		PreparedStatement pstm = null;
		int res = 0;

		try {

			System.out.println("어디가 문제11");
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, myno);

			res = pstm.executeUpdate();

			System.out.println("어디가 문제22");
			if (res > 0) {

				System.out.println("삭제 성공");

			} else {

				System.out.println("삭제 실패");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				pstm.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return res;

	}

}
