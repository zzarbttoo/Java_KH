package com.score.dao;

import static com.score.db.JDBCTemplate.close;
import static com.score.db.JDBCTemplate.commit;
import static com.score.db.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.score.dto.ScoreDto;

public class ScoreDao {

	public List<ScoreDto> selectList() {

		Connection con = getConnection();
		Statement stmt = null;
		ResultSet rs = null;

		List<ScoreDto> list = new ArrayList<ScoreDto>();

		String selectSql = " SELECT MYNAME, MYKOR, MYENG, MYMATH, MYSUM, MYAVG, MYGRADE FROM MYSCORE ";

		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(selectSql);

			while (rs.next()) {

				ScoreDto dto = new ScoreDto(rs.getString(1), rs.getInt(2), rs.getInt(3), rs.getInt(4));
				list.add(dto);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			close(rs);
			close(stmt);
			close(con);
		}

		return list;

	}

	public ScoreDto selectOne(String myName) {

		Connection con = getConnection();

		PreparedStatement pstm = null;
		ResultSet rs = null;

		String name = null;
		int kor = 0;
		int eng = 0;
		int math = 0;

		String selectSql = " SELECT MYNAME, MYKOR, MYENG, MYMATH, MYSUM, MYAVG, MYGRADE FROM MYSCORE WHERE MYNAME = ? ";

		try {
			pstm = con.prepareStatement(selectSql);
			pstm.setString(1, myName);

			rs = pstm.executeQuery();

			while (rs.next()) {

				name = rs.getString(1);
				kor = rs.getInt(2);
				eng = rs.getInt(3);
				math = rs.getInt(4);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstm);
			close(con);

		}

		ScoreDto dto = new ScoreDto(name, kor, eng, math);

		return dto;

	}

	public int insert(ScoreDto dto) {

		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;

		// 디버깅
		System.out.println(dto);

		String insertSql = " INSERT INTO MYSCORE VALUES(?, ?, ?, ?, ?, ?, ?) ";

		try {

			pstm = con.prepareStatement(insertSql);
			pstm.setString(1, dto.getMyName());
			pstm.setInt(2, dto.getMyKor());
			pstm.setInt(3, dto.getMyEng());
			pstm.setInt(4, dto.getMyMath());
			pstm.setInt(5, dto.getMySum());
			pstm.setDouble(6, dto.getMyAvg());
			pstm.setString(7, dto.getMyGrade());


			res = pstm.executeUpdate();

			if (res > 0) {

				commit(con);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("error 3. 4.");
		} finally {

			close(pstm);
			close(con);

		}
		return res;
	}

	public int update(ScoreDto dto) {

		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;

		String updateSql = " UPDATE MYSCORE SET MYKOR = ?, MYENG = ?, MYMATH = ? " + " WHERE MYNAME = ? ";

		try {
			pstm = con.prepareStatement(updateSql);
			pstm.setInt(1, dto.getMyKor());
			pstm.setInt(2, dto.getMyEng());
			pstm.setInt(3, dto.getMyMath());
			pstm.setString(4, dto.getMyName());

			res = pstm.executeUpdate();

			if (res > 0) {

				commit(con);
			}

		} catch (SQLException e) {

			System.out.println("error 3. 4.");
			e.printStackTrace();
		} finally {

			close(pstm);
			close(con);
		}

		return res;
	}

	public int delete(String myName) {

		Connection con = getConnection();

		PreparedStatement pstm = null;
		int res = 0;

		String deleteSql = " DELETE FROM MYSCORE WHERE MYNAME = ? ";

		try {
			pstm = con.prepareStatement(deleteSql);
			pstm.setString(1, myName);

			res = pstm.executeUpdate();

			if (res > 0) {

				commit(con);
			}

		} catch (SQLException e) {

			System.out.println("error .3 .4");
			e.printStackTrace();
		} finally {

			close(pstm);
			close(con);
		}

		return res;
	}

	public ScoreDto selectFirst() {

		String firstName = null;
		int firstKor = 0;
		int firstEng = 0;
		int firstMath = 0;

		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;

		String selectFirstSql = " SELECT MYNAME, MYKOR, MYENG, MYMATH, MYSUM, MYAVG, MYGRADE FROM "
				+ " (SELECT MYNAME, MYKOR, MYENG, MYMATH, MYSUM, MYAVG, MYGRADE FROM MYSCORE ORDER BY MYAVG DESC) "
				+ " WHERE ROWNUM = 1 ";

		try {
			pstm = con.prepareStatement(selectFirstSql);
			rs = pstm.executeQuery();

			while (rs.next()) {

				firstName = rs.getString(1);
				System.out.println(firstName);
				firstKor = rs.getInt(2);
				System.out.println(firstKor);
				firstEng = rs.getInt(3);
				firstMath = rs.getInt(4);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			close(rs);
			close(pstm);
			close(con);

		}

		ScoreDto dto = new ScoreDto(firstName, firstKor, firstEng, firstMath);

		return dto;
	}

	public ScoreDto selectSecond() {

		Connection con = getConnection();
		Statement stmt = null;
		ResultSet rs = null;

		String secondName = null;
		int secondKor = 0;
		int secondEng = 0;
		int secondMath = 0;

		String selectSecondSql = " SELECT MYNAME, MYKOR, MYENG, MYMATH, MYSUM, MYAVG, MYGRADE FROM "
				+ " (SELECT ROW_NUMBER() OVER (ORDER BY MYAVG DESC) ROWNUMBER, MYNAME, MYKOR, MYENG, MYMATH, MYSUM, MYAVG, MYGRADE FROM MYSCORE ORDER BY MYAVG DESC) SUBTABLE "
				+ " WHERE SUBTABLE.ROWNUMBER = 2 ";

		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(selectSecondSql);

			while (rs.next()) {

				secondName = rs.getString(1);
				secondKor = rs.getInt(2);
				secondEng = rs.getInt(3);
				secondMath = rs.getInt(4);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(stmt);
			close(con);

		}

		ScoreDto dto = new ScoreDto(secondName, secondKor, secondEng, secondMath);
		System.out.println(dto);

		return dto;
	}

	public ScoreDto selectThird() {

		String thirdName = null;
		int thirdKor = 0;
		int thirdEng = 0;
		int thirdMath = 0;

		Connection con = getConnection();
		Statement stmt = null;
		ResultSet rs = null;

		String selectThirdSql = " SELECT MYNAME, MYKOR, MYENG, MYMATH, MYSUM, MYAVG, MYGRADE FROM "
				+ " (SELECT ROW_NUMBER() OVER (ORDER BY MYAVG DESC) ROWNUMBER, MYNAME, MYKOR, MYENG, MYMATH, MYSUM, MYAVG, MYGRADE FROM MYSCORE) SUBTABLE "
				+ " WHERE SUBTABLE.ROWNUMBER = 3 ";

		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(selectThirdSql);

			while (rs.next()) {

				thirdName = rs.getString(1);
				System.out.println(thirdName);
				thirdKor = rs.getInt(2);
				thirdEng = rs.getInt(3);
				thirdMath = rs.getInt(4);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			close(rs);
			close(stmt);
			close(con);
		}

		ScoreDto dto = new ScoreDto(thirdName, thirdKor, thirdEng, thirdMath);

		return dto;
	}

	public ScoreDto topN(int n) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		ScoreDto dto = null;
		ResultSet rs = null;
	
		String sql = " SELECT * " + 
				" FROM " + 
				" (SELECT ROWNUM AS R, MYNAME, MYKOR, MYENG, MYAVG, MYGRADE FROM " + 
				" (SELECT MYNAME, MYKOR, MYENG, MYMATH, MYSUM, MYSUM, MYGRADE FROM MYSCORE " + 
				" ORDER BY MYAVG DESC)) " + 
				" WHERE R = ? " ;
		
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, n);
			
			rs = pstm.executeQuery();
			while(rs.next()) {
				
				//그냥 *로 하면, rowNum이 나오기 때문에, 컬럼 하나하나씩 해주는 것이 좋다
				dto = new ScoreDto();
				dto.setMyName(rs.getString(2));
				dto.setMyKor(rs.getInt(3));
				dto.setMyEng(rs.getInt(4));
				dto.setMyMath(rs.getInt(5));
				dto.setMySum(rs.getInt(6));
				dto.setMyAvg(rs.getDouble(7));
				dto.setMyGrade(rs.getString(8));
	
				
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return dto;
				
	}
	
	
}
