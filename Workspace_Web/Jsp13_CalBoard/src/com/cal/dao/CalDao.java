package com.cal.dao;

import static com.cal.db.JDBCTemplate.close;
import static com.cal.db.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cal.dto.CalDto;

public class CalDao {

	public int insertCalBoard(CalDto dto) {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "kh";
		String pw = "kh";

		Connection con = null;

		try {
			con = DriverManager.getConnection(url, user, pw);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		PreparedStatement pstm = null;
		int res = 0;

		String sql = " INSERT INTO CALBOARD VALUES(CALBOARDSEQ.NEXTVAL, ?, ?, ?, ?, SYSDATE) ";

		try {
			pstm = con.prepareStatement(sql);

			pstm.setString(1, dto.getId());
			pstm.setString(2, dto.getTitle());
			pstm.setString(3, dto.getContent());
			pstm.setString(4, dto.getMdate());

			res = pstm.executeUpdate();

			if (res > 0) {

				con.commit();
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

	public List<CalDto> selectCalendarList(String yyyyMMdd, String id) {

		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<CalDto> list = new ArrayList<CalDto>();
		// 20200828만 자르고, 그 것에 해당하는 글들은 다 들고 올 것이다
		String sql = " SELECT SEQ, ID, TITLE, CONTENT, MDATE, REGDATE FROM CALBOARD WHERE SUBSTR(MDATE, 1, 8)= ? AND ID =? ";

		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, yyyyMMdd);
			pstm.setString(2, id);

			rs = pstm.executeQuery();

			while (rs.next()) {

				CalDto dto = new CalDto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getDate(6));
				list.add(dto);
				System.out.println("글 잘 나오는거 맞냐" + rs.getString(4));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			close(con, rs, pstm);
		}

		return list;
	}

	public List<CalDto> calendarViewList(String id, String yyyyMM) {

		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<CalDto> list = new ArrayList<CalDto>();

		String sql = " SELECT * FROM "
				+ " (SELECT (ROW_NUMBER() OVER (PARTITION BY SUBSTR(MDATE, 1, 8) ORDER BY MDATE )) RN, "
				+ " SEQ, ID, TITLE, CONTENT, MDATE, REGDATE " + " FROM CALBOARD "
				+ " WHERE ID=? AND SUBSTR(MDATE, 1, 6) = ? ) " + " WHERE RN BETWEEN 1 AND 3 ";

		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, id);
			pstm.setString(2, yyyyMM);

			rs = pstm.executeQuery();

			while (rs.next()) {

				CalDto cal = new CalDto();
				cal.setSeq(rs.getInt(2));
				cal.setId(rs.getString(3));
				cal.setTitle(rs.getString(4));
				cal.setContent(rs.getString(5));
				cal.setMdate(rs.getString(6));
				cal.setRegdate(rs.getDate(7));

				list.add(cal);

				System.out.println("DAo " + rs.getInt(2));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			close(con, rs, pstm);

		}

		return list;

	}

	public int calendarViewCount(String id, String yyyyMMdd) {

		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		int count = 0;
		String sql = " SELECT COUNT(*) FROM CALBOARD WHERE ID = ? AND SUBSTR(MDATE, 1, 8) = ? ";

		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, id);
			pstm.setString(2, yyyyMMdd);

			rs = pstm.executeQuery();

			//셀렉트 하면 테이블이 나오기 때문에 이거로 해야한다 
			while (rs.next()) {

				count = rs.getInt(1);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			close(con, rs, pstm);
		}

		return count;

	}

}
