package com.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mvc.db.JDBCTemplate;
import com.mvc.dto.MVCBoardDto;

public class MVCBoardDaoImpl extends JDBCTemplate implements MVCBoardDao {

	
	@Override
	public List<MVCBoardDto> selectList() {

		Connection con = getConnection();

		PreparedStatement pstm = null;
		ResultSet rs = null;

		List<MVCBoardDto> list = new ArrayList<MVCBoardDto>();

		try {
			// 쿼리 준비
			pstm = con.prepareStatement(SELECT_LIST_SQL);
			// 쿼리 실행 및 리턴
			rs = pstm.executeQuery();

			while (rs.next()) {

				MVCBoardDto dto = new MVCBoardDto(rs.getInt("SEQ"), rs.getString("WRITER"), rs.getString("TITLE"),
						rs.getString("CONTENT"), rs.getDate("REGDATE"));
				list.add(dto);
			}
			
			
			System.out.println();
			

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
			//db 종료
			close(rs);
			close(pstm);
			close(con);
		}

		return list;
	}

	@Override
	public MVCBoardDto selectOne(int seq) {
		
		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		MVCBoardDto dto = null;
		
		try {
			pstm = con.prepareStatement(SELECT_ONE_SQL);
			pstm.setInt(1, seq);
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				//여기서 0값이 들어가지 않도록 조심하자
				dto = new MVCBoardDto(rs.getInt("SEQ"),rs.getString("WRITER"), rs.getString("TITLE"), rs.getString("CONTENT"), rs.getDate("REGDATE"));
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
	public boolean insert(MVCBoardDto dto) {
		
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		
		try {
			pstm = con.prepareStatement(INSERT_SQL);
			pstm.setString(1, dto.getWriter());
			pstm.setString(2, dto.getTitle());
			pstm.setString(3, dto.getContent());
			System.out.println("3. query 준비 :" + INSERT_SQL);
			
			res = pstm.executeUpdate();
			
			
			if(res>0) {
				
				commit(con);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstm);
			close(con);
		}
		System.out.println("res는");
			System.out.println(res);
		return (res>0)?true:false;
	}

	@Override
	public boolean update(MVCBoardDto dto) {
		
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		
		try {
			pstm = con.prepareStatement(UPDATE_SQL);
			
			pstm.setString(1, dto.getWriter());
			pstm.setString(2, dto.getTitle());
			pstm.setString(3, dto.getContent());
			pstm.setInt(4, dto.getSeq());

			res=pstm.executeUpdate();
			System.out.println("update 뭐가 문제임");
			System.out.println(res);
			if(res > 0) {
				
				commit(con);
			}
			

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstm);
			close(con);
		}
		
			return (res>0) ? true:false;
	}

	@Override
	public boolean delete(int seq) {
		
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
		
		
		return (res > 0) ? true :false;
	}

}
