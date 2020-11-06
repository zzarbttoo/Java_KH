package com.muldel.dao;

import static com.muldel.db.JDBCTemplate.close;
import static com.muldel.db.JDBCTemplate.commit;
import static com.muldel.db.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.muldel.dto.MDBoardDto;

public class MDBoardDao {

	public List<MDBoardDto> selectList() {

		// 1.
		// 2.
		Connection con = getConnection();

		// 필요한 객체들을 위에 미리 만든다
		Statement stmt = null;
		ResultSet rs = null;
		List<MDBoardDto> list = new ArrayList<MDBoardDto>();
		String sql = " SELECT SEQ, WRITER, TITLE, CONTENT, REGDATE " + " FROM MDBOARD " + " ORDER BY SEQ DESC ";

		// 3.
		try {
			stmt = con.createStatement();
			System.out.println("3. query 준비 " + sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			// table이 리턴되며, resultSet 객체에 담는다
			rs = stmt.executeQuery(sql);
			System.out.println("4. query 실행 및 리턴");

			// 하나하나 dto에 담는다
			while (rs.next()) {

				MDBoardDto dto = new MDBoardDto();
				dto.setSeq(rs.getInt("SEQ"));
				dto.setWriter(rs.getString("WRITER"));
				dto.setTitle(rs.getString("TITLE"));
				dto.setContent(rs.getString("CONTENT"));
				dto.setRegdate(rs.getDate("REGDATE"));

				list.add(dto);

			}

		} catch (SQLException e) {
			System.out.println("[error] 3. 4.");
			e.printStackTrace();
		} finally {
			// 5.
			close(rs);
			close(stmt);
			close(con);
		}
		return list;
	}

	public MDBoardDto selectOne(int seq) {

		Connection con = getConnection();

		PreparedStatement pstm = null;
		ResultSet rs = null;
		MDBoardDto dto = null;

		String sql = " SELECT SEQ, WRITER, TITLE, CONTENT, REGDATE FROM MDBOARD WHERE SEQ = ? ORDER BY SEQ DESC ";

		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, seq);

			rs = pstm.executeQuery();

			while (rs.next()) {

				dto = new MDBoardDto();
				dto.setSeq(seq);
				dto.setWriter(rs.getString("WRITER"));
				dto.setTitle(rs.getString("TITLE"));
				dto.setContent(rs.getString("CONTENT"));
				dto.setRegdate(rs.getDate("REGDATE"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			close(rs);
			close(pstm);
		}

		return dto;
	}

	public int update(MDBoardDto dto) {

		Connection con = null;
		con = getConnection();

		PreparedStatement pstm = null;

		int res = 0;

		String sql = " UPDATE MDBOARD SET TITLE = ?, CONTENT = ? WHERE SEQ = ? ";

		try {
			pstm = con.prepareStatement(sql);

			pstm.setString(1, dto.getTitle());
			pstm.setString(2, dto.getContent());
			pstm.setInt(3, dto.getSeq());

			res = pstm.executeUpdate();

			if (res > 0) {

				System.out.println("성공");
				commit(con);

			} else {

				System.out.println("실패");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			close(pstm);
			close(con);
		}

		return res;
	}

	public int delete(int seq) {

		Connection con = null;
		con = getConnection();

		PreparedStatement pstm = null;
		int res = 0;

		String sql = " DELETE FROM MDBOARD WHERE SEQ = ? ";

		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, seq);

			res = pstm.executeUpdate();

			if (res > 0) {

				System.out.println("성공");
				commit(con);

			} else {

				System.out.println("실패");

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			close(pstm);
			close(con);
		}

		return res;
	}

	public int insert(MDBoardDto dto) {

		Connection con = null;

		try {
			con = getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}

		PreparedStatement pstm = null;
		int res = 0;
		
		String sql = " INSERT INTO MDBOARD VALUES (MDBOARDSEQ.NEXTVAL, ?, ?, ?, SYSDATE) ";
				
			
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, dto.getWriter());
			pstm.setString(2, dto.getTitle());
			pstm.setString(3, dto.getContent());
			
			
			System.out.println(dto.getWriter());
			System.out.println(dto.getTitle());
			System.out.println(dto.getContent());
			
			
			
			res = pstm.executeUpdate();
			System.out.println(res);
			
			if(res > 0) {
				
				System.out.println("성공");
				commit(con);
				
			}else {
				
				System.out.println("실패");
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
			close(pstm);
			close(con);
			
		}
		

		return res; 

	}

	// delete at Once
	public int multiDelete(String[] seqs) {

		// 1.
		// 2.
		Connection con = getConnection();

		PreparedStatement pstm = null;
		int res = 0;
		String sql = " DELETE FROM MDBOARD WHERE SEQ = ? ";
		int[] result = null;

		// 3.
		try {

			pstm = con.prepareStatement(sql);

			for (int i = 0; i < seqs.length; i++) {

				pstm.setString(1, seqs[i]);
				// 메모리에 임시 적재 후, executeBatch() 메서드가 호출될 때 한번에 모두 실행
				pstm.addBatch();
				System.out.println("3. query 준비 : " + sql + "(" + seqs[i] + ")");

			}

			// 4.
			// int [] 로 리턴
			result = pstm.executeBatch();
			System.out.println("4. query 실행 및 리턴");

			for (int i = 0; i < result.length; i++) {
				// 성공 : -2
				// 실패 : -3
				if (result[i] == -2) {

					res++;

				}

			}

			if (seqs.length == res) {

				commit(con);
			}

		} catch (SQLException e) {
			System.out.println("[error] 3. 4.");
			e.printStackTrace();
		} finally {

			// 5.
			close(pstm);
			close(con);
			System.out.println("5. db 종료");

		}
		return res;

	}

}
