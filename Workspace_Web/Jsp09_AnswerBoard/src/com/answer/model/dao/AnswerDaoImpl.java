package com.answer.model.dao;

import static com.answer.db.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.answer.model.dto.AnswerDto;

public class AnswerDaoImpl implements AnswerDao {

	@Override
	public List<AnswerDto> selectList() {

		Connection con = getConnection();
		PreparedStatement pstm = null;
		List<AnswerDto> list = new ArrayList<AnswerDto>();
		ResultSet rs = null;
		AnswerDto dto = null;

		try {
			pstm = con.prepareStatement(SELECT_LIST_SQL);
			rs = pstm.executeQuery();

			while (rs.next()) {

				dto = new AnswerDto();
				dto.setBoardno(rs.getInt(1));
				dto.setGroupno(rs.getInt(2));
				dto.setGroupseq(rs.getInt(3));
				dto.setTitletab(rs.getInt(4));
				dto.setTitle(rs.getString(5));
				dto.setContent(rs.getString(6));
				dto.setWriter(rs.getString(7));
				dto.setRegdate(rs.getDate(8));

				list.add(dto);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			close(con, rs, pstm);
		}

		return list;
	}

	@Override
	public AnswerDto selectOne(int boardno) {

		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		AnswerDto dto = null;

		try {
			pstm = con.prepareStatement(SELECT_ONE_SQL);
			rs = pstm.executeQuery();

			while (rs.next()) {

				dto = new AnswerDto();
				dto.setBoardno(rs.getInt(1));
				dto.setGroupno(rs.getInt(2));
				dto.setGroupseq(rs.getInt(3));
				dto.setTitletab(rs.getInt(4));
				dto.setTitle(rs.getString(5));
				dto.setContent(rs.getString(6));
				dto.setWriter(rs.getString(7));
				dto.setRegdate(rs.getDate(8));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			close(con, rs, pstm);
		}

		return dto;
	}

	@Override
	public int update(AnswerDto dto) {

		Connection con = getConnection();
		PreparedStatement pstm = null;
		String sql = UPDATE_BOARD_SQL;
		int res = 0;

		try {
			pstm = con.prepareStatement(sql);
			// need to do add

			res = pstm.executeUpdate();

			if (res > 0) {

				commit(con);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			close(con, pstm);
		}

		return res;
	}

	@Override
	public int insert(AnswerDto dto) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		String sql = INSERT_BOARD_SQL;
		int res = 0;

		try {
			pstm = con.prepareStatement(sql);
			// need to do add

			res = pstm.executeUpdate();

			if (res > 0) {

				commit(con);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			close(con, pstm);
		}

		return res;

	}

	@Override
	public int delete(int boardno) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		String sql = DELETE_BOARD_SQL;
		int res = 0;

		try {
			pstm = con.prepareStatement(sql);
			// need to do add

			res = pstm.executeUpdate();

			if (res > 0) {

				commit(con);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			close(con, pstm);
		}

		return res;

	}

	@Override
	public int updateAnswer(int boardno) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		String sql = UPDATE_ANSWER_SQL;
		int res = 0;

		try {
			pstm = con.prepareStatement(sql);
			// need to do add

			res = pstm.executeUpdate();

			if (res > 0) {

				commit(con);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			close(con, pstm);
		}

		return res;

	}

	@Override
	public int insertAnswer(AnswerDto dto) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		String sql = INSERT_ANSWER_SQL;
		int res = 0;

		try {
			pstm = con.prepareStatement(sql);
			// need to do add

			res = pstm.executeUpdate();

			if (res > 0) {

				commit(con);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			close(con, pstm);
		}

		return res;

	}

}
