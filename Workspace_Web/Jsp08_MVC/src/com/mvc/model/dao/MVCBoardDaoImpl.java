package com.mvc.model.dao;

import static com.mvc.db.JDBCTemplate.*;
import static com.mvc.db.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mvc.model.dto.MVCBoardDto;

public class MVCBoardDaoImpl implements MVCBoardDao {

	@Override
	public List<MVCBoardDto> selectList() {
		
		
		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<MVCBoardDto> list = new ArrayList<MVCBoardDto>();
		MVCBoardDto dto = null;
		String sql = SELECT_LIST_SQL;
		
		try {
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				
				dto = new MVCBoardDto();
				dto.setSeq(rs.getInt(1));
				dto.setWriter(rs.getString(2));
				dto.setTitle(rs.getString(3));
				dto.setContent(rs.getString(4));
				dto.setRegdate(rs.getDate(5));
				list.add(dto);
				System.out.println("여기 문제냐");
				System.out.println(dto);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstm);
			close(con);
			System.out.println("db 종료 되는 것?");
		}
		
				
		
		return list;
	}

	@Override
	public MVCBoardDto selectOne(int seq) {
		
		
		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		MVCBoardDto dto = null;
		String sql = SELECT_ONE_SQL;
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, seq);
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				
				dto = new MVCBoardDto();
				dto.setSeq(rs.getInt(1));
				dto.setWriter(rs.getString(2));
				dto.setTitle(rs.getString(3));
				dto.setContent(rs.getString(4));
				dto.setRegdate(rs.getDate(5));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstm);
			close(con);
		}
		
		return dto;
	}

	@Override
	public int delete(int seq) {
		
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		
		try {
			pstm = con.prepareStatement(DELETE_SQL);
			pstm.setInt(1, seq);
			
			res = pstm.executeUpdate();
			if(res > 0) {
				
				commit(con);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
			close(pstm);
			close(con);
		}
		
		return res;
	}

	@Override
	public int update(MVCBoardDto dto) {
	
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		
		String sql = UPDATE_SQL;
		System.out.println("update sql num");
		System.out.println(dto.getSeq());
		System.out.println(dto.getTitle());
		System.out.println(dto.getContent());
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, dto.getTitle());
			pstm.setString(2, dto.getContent());
			pstm.setInt(3, dto.getSeq());
			
			res = pstm.executeUpdate();
			System.out.println("어디 문제냐냐냐");
			System.out.println(res);
			if(res > 0) {
				commit(con);
				System.out.println("업데이트 성공!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
			close(pstm);
			close(con);
			
		}
		
		return res;
	}

	@Override
	public int insert(MVCBoardDto dto) {
		
		Connection con = getConnection();
		PreparedStatement pstm = null;
		
		int res = 0;
		System.out.println("debug1");
		try {
			pstm = con.prepareStatement(INSERT_SQL);
			pstm.setString(1, dto.getWriter());
			pstm.setString(2, dto.getTitle());
			pstm.setString(3, dto.getContent());
			
			System.out.println("debug2");
			res = pstm.executeUpdate();
			
			if(res>0) {
				
				commit(con);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
			close(pstm );
			close(con);
			
		}
		
		return res;
	}

}
