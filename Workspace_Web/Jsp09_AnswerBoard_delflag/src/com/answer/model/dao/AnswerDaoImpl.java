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
		ResultSet rs = null;
		
		List<AnswerDto> list = new ArrayList<AnswerDto>();
		
		 try {
			pstm = con.prepareStatement(SELECT_LIST_SQL);
			rs= pstm.executeQuery();
			
			while(rs.next()) {
				
				AnswerDto dto = new AnswerDto();
				
				dto.setBoardno(rs.getInt(1));
				dto.setGroupno(rs.getInt(2));
				dto.setGroupseq(rs.getInt(3));
				dto.setTitletab(rs.getInt(4));
				dto.setDelflag(rs.getString(5));
				dto.setTitle(rs.getString(6));
				dto.setContent(rs.getString(7));
				dto.setWriter(rs.getString(8));
				dto.setRegdate(rs.getDate(9));
				System.out.println(dto);
				list.add(dto);
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
		
			close(con, rs, pstm);
		
		}
		 
		 System.out.println(list);
		return list;
	}

	@Override
	public AnswerDto selectOne(int boardno) {
		
		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		AnswerDto dto = null;
		
		System.out.println("DEBUG1");
		
		 try {
			pstm = con.prepareStatement(SELECT_ONE_SQL);
			pstm.setInt(1, boardno);
			rs= pstm.executeQuery();
			
			
		System.out.println("DEBUG2");

			
			while(rs.next()) {
				
				dto = new AnswerDto();
				
				dto.setBoardno(rs.getInt(1));
				dto.setGroupno(rs.getInt(2));
				dto.setGroupseq(rs.getInt(3));
				dto.setTitletab(rs.getInt(4));
				dto.setDelflag(rs.getString(5));
				dto.setTitle(rs.getString(6));
				dto.setContent(rs.getString(7));
				dto.setWriter(rs.getString(8));
				dto.setRegdate(rs.getDate(9));
				System.out.println("dto 출력");
				System.out.println(dto);
				
			}
			System.out.println("null 이 드는데?");
			System.out.println(dto);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
		
			
			close(con, rs, pstm);
		
		}
		 
		return dto;
	}

	@Override
	public int insertBoard(AnswerDto dto) {
		Connection con  = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		
		try {
			pstm = con.prepareStatement(INSERT_BOARD_SQL);
			pstm.setString(1, dto.getTitle());
			pstm.setString(2, dto.getContent());
			pstm.setString(3, dto.getWriter());
			
			res = pstm.executeUpdate();
			
			if(res > 0) {
				commit(con);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
			close(con, pstm);
			
		}
		
		return res;
	}

	@Override
	public int updateBoard(AnswerDto dto) {
		return 0;
	}

	@Override
	public int deleteBoard(int boardno) {
		
		Connection con = getConnection();
		
		PreparedStatement pstm = null;
		int res = 0;
		
		try {
			pstm = con.prepareStatement(DELETE_BOARD_SQL);
			pstm.setInt(1, boardno);
			
			res = pstm.executeUpdate();
			
			if(res > 0 ) {
				
				commit(con);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
			close(con, pstm);
			
		}
			
		return res;
	}

	@Override
	public int updateAnswer(int parentboardno) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertAnswer(AnswerDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}

}
