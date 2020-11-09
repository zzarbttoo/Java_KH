package com.mvc.update.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.mvc.update.model.dto.JDBCDto;

@Repository
public class JDBCDaoImpl implements JDBCDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	/*
	 * @Override public List<JDBCDto> selectList() {
	 * 
	 * List<JDBCDto> list = null;
	 * 
	 * String sql =
	 * "	SELECT SEQ, WRITER, TITLE, CONTENT, REGDATE FROM JDBCBOARD ORDER BY SEQ DESC "
	 * ;
	 * 
	 * //java 8 버전부터 나온 Lambda 식 사용 list = jdbcTemplate.query(sql, (rs, rowNum) -> {
	 * JDBCDto dto = new JDBCDto(rs.getInt(1), rs.getString(2), rs.getString(3),
	 * rs.getString(4), rs.getDate(5));
	 * 
	 * return dto; });
	 * 
	 * return list; }
	 * 
	 */

	/*
	 * 
	 * @Override public List<JDBCDto> selectList() {
	 * 
	 * List<JDBCDto> list = null; String sql =
	 * " SELECT SEQ, WRITER, TITLE, CONTENT, REGDATE FROM JDBCBOARD ORDER BY SEQ DESC "
	 * ;
	 * 
	 * list = jdbcTemplate.query(sql,new RowMapper<JDBCDto>() {
	 * 
	 * @Override public JDBCDto mapRow(ResultSet rs, int rowNum) throws SQLException
	 * {
	 * 
	 * JDBCDto res = new JDBCDto(rs.getInt(1), rs.getString(2), rs.getString(3),
	 * rs.getString(4), rs.getDate(5)); return res; } });
	 * 
	 * 
	 * 
	 * 
	 * return list; }
	 * 
	 */
	
	@Override
	public List<JDBCDto> selectList() {
		
		List<JDBCDto> list = null;
		String sql = " SELECT SEQ, WRITER, TITLE, CONTENT, REGDATE FROM JDBCBOARD ORDER BY SEQ DESC ";
		list = jdbcTemplate.query(sql, new MyMapper());
		
		return list;
	}

	
	@Override
	public JDBCDto selectOne(int seq) {
		
		JDBCDto res = null;
		
		String sql = " SELECT SEQ, WRITER, TITLE, CONTENT, REGDATE FROM JDBCBOARD WHERE SEQ = ? ";
		res = jdbcTemplate.queryForObject(sql, new Object[] {seq}, new MyMapper());
		
		return res;
	}
	@Override
	public int insert(JDBCDto dto) {
		
		int res = 0;
		
		String sql = " INSERT INTO JDBCBOARD VALUES(JDBCBOARDSEQ.NEXTVAL, ?, ?, ?, SYSDATE) ";
		
		res = jdbcTemplate.update(sql, new Object[] {dto.getWriter(), dto.getTitle(), dto.getContent()});
		
		if(res > 0) {
			System.out.println("성공");
		}		
		
		return res;
	}

	@Override
	public int update(JDBCDto dto) {
		
		int res = 0;
		
		String sql = " UPDATE JDBCBOARD SET TITLE = ?, CONTENT = ? WHERE SEQ = ? "; 
		
		res = jdbcTemplate.update(sql, new Object[] {dto.getTitle(), dto.getContent(), dto.getSeq()});
		
		return res;
	}

	@Override
	public int delete(int seq) {
		
		int res = 0;
		String sql = " DELETE FROM JDBCBOARD WHERE SEQ = ? "; 
		//res = jdbcTemplate.update(sql, seq); 이런 식으로 나열해도 된다
		res = jdbcTemplate.update(sql, new Object[] {seq});
		
		return res;

	}

	// RowMapper inner class
	private static final class MyMapper implements RowMapper<JDBCDto> {

		//setResult 값을 자동으로 넣어주는 역할을 한다 
		@Override
		public JDBCDto mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			JDBCDto dto = new JDBCDto();
			dto.setSeq(rs.getInt(1));
			dto.setWriter(rs.getString(2));
			dto.setTitle(rs.getString(3));
			dto.setContent(rs.getString(4));
			dto.setRegdate(rs.getDate(5));
			
			
			return dto;
		}
	}

}
