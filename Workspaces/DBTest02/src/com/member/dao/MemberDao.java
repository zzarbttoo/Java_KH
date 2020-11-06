package com.member.dao;

//static으로 import를 해주면 static메소드 호출 방식으로 안하고 그냥 호출이 가능하다
import static com.member.db.JDBCTemplate.close;
import static com.member.db.JDBCTemplate.commit;
import static com.member.db.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.member.dto.MemberDto;

// Dao : Data Access Object
//database와 연결만 해야한다(화면에 출력만 하면 안된다)
public class MemberDao {

	// 전체 출력
	// list <- 중복과 순서가 있기 때문에 보통 많이 쓴다(하지만 꼭 쓴다는 얘기는 아니다)

	public List<MemberDto> selectList() {

		Connection con = getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		List<MemberDto> list = new ArrayList<MemberDto>();

		String sql = " SELECT MNO, MNAME, MAGE, MGENDER, MLOCATION, MJOB, MTEL, MEMAIL " + " FROM MEMBERBOARD "
				+ " ORDER BY MNO DESC ";

		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {

				MemberDto dto = new MemberDto();
				dto.setMno(rs.getInt(1));
				dto.setMname(rs.getString(2));
				dto.setMage(rs.getInt(3));
				dto.setMgender(rs.getString(4));
				dto.setMlocation(rs.getString(5));
				dto.setMjob(rs.getString(6));
				dto.setMtel(rs.getString(7));
				dto.setMemail(rs.getString(8));

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

	// 선택 출력
	// 내가 원하는 것 하나를 찾기 위해 하나를 Primary키로 잡았다
	public MemberDto selectOne(int mno) {

		
		Connection con = getConnection();
//		Statement stmt = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		MemberDto dto = new MemberDto();
		
		

//		String selectoneSql =" SELECT MNO, MNAME, MAGE, MGENDER, MLOCATION, MJOB, MTEL, MEMAIL " + " FROM MEMBERBOARD "
//				+ " WHERE MNO = " + mno;
 
		String sql = " SELECT MNO, MNAME, MAGE, MGENDER, MLOCATION, MJOB, MTEL, MEMAIL " + " FROM MEMBERBOARD " +
		" WHERE MNO = ? ";
		
		
		//3.
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, mno);
			
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				
				dto = new MemberDto();
				dto.setMno(rs.getInt(1));
				dto.setMname(rs.getString(2));
				dto.setMage(rs.getInt(3));
				dto.setMgender(rs.getString(4));
				dto.setMlocation(rs.getString(5));
				dto.setMjob(rs.getString(6));
				dto.setMtel(rs.getString(7));
				dto.setMemail(rs.getString(8));
				
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rs);
			
			//statement를 상속받고 있기 때문에 이거도 가능하다
			close(pstm);
			close(con);
		}
		
		return dto;
				
//		
//		try {
////			stmt = con.createStatement();
////			rs = stmt.executeQuery(selectoneSql);
//			
//			while(rs.next()) {
//				
//				dto.setMno(rs.getInt(1));
//				dto.setMname(rs.getString(2));
//				dto.setMage(rs.getInt(3));
//				dto.setMgender(rs.getString(4));
//				dto.setMlocation(rs.getString(5));
//				dto.setMjob(rs.getString(6));
//				dto.setMtel(rs.getString(7));
//				dto.setMemail(rs.getString(8));
//				
//			}
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}finally {
//			close(rs);
//			close(stmt);
//			close(con);
//		}
//		
		
//		return dto;
	}

	// 추가
	// 추가 됐다 안됐다 (0/1)
	// Dto를 넣어주면 그 데이터 베이스에 저장됐으면 1 아니면 0을 전달해줄 것임
	public int insert(MemberDto dto) {
		// 1. 2.
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;

		String sql = " INSERT INTO MEMBERBOARD VALUES(MEMBERSEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, ?) ";

		// 3.
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, dto.getMname());
			pstm.setInt(2, dto.getMage());
			pstm.setString(3, dto.getMgender());
			pstm.setString(4, dto.getMlocation());
			pstm.setString(5, dto.getMjob());
			pstm.setString(6, dto.getMtel());
			pstm.setString(7, dto.getMemail());

			res = pstm.executeUpdate();

			// 4.

			if (res > 0) {
				// setAutoCommit을 false로 해줬다
				commit(con);
			}

		} catch (SQLException e) {
			System.out.println("error [3. 4.]");
			e.printStackTrace();
		} finally {
			close(pstm);
			close(con);
		}

		return res;
	}

	// 수정

	public int update(MemberDto dto) {

		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;

		String sql = " UPDATE MEMBERBOARD SET MNAME = ? WHERE MNO = ? ";

		try {
			pstm = con.prepareStatement(sql);
			System.out.println(dto.getMname());
			pstm.setString(1, dto.getMname());
			
			pstm.setInt(2, dto.getMno());

			res = pstm.executeUpdate();
			System.out.println(res);

			if (res > 0) {

				commit(con);
			} else {
				System.out.println("error [3.4.]");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			close(pstm);
			close(con);
		}

		return res;
	}

	// 삭제
	public int delete(int mno) {
		
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		
		
		String deleteSql = " DELETE FROM MEMBERBOARD WHERE MNO = ? ";
		try {
			pstm = con.prepareStatement(deleteSql);
			
			pstm.setInt(1, mno);
			res = pstm.executeUpdate();
			
			
			if(res > 0) {
				commit(con);
			}else {
				
				System.out.println("error [3.4.]");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
			close(pstm);
			close(con);
			
		}
		
		return res;

	}

}
