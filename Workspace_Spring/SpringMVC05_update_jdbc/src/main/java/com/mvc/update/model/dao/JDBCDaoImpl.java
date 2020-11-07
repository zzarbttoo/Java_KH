package com.mvc.update.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mvc.update.model.dto.JDBCDto;

@Repository
public class JDBCDaoImpl implements JDBCDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<JDBCDto> selectList() {
		
		List<JDBCDto> list = null;
		
		String sql = "	SELECT SEQ, WRITER, TITLE, CONTENT, REGDATE FROM JDBCBOARD ORDER BY SEQ DESC ";
	
		//java 8 버전부터 나온 Lambda 식 사용
		list = jdbcTemplate.query(sql,
				(rs, rowNum) -> {
					JDBCDto dto = new JDBCDto(rs.getInt(1),
							rs.getString(2),
							rs.getString(3),
							rs.getString(4),
							rs.getDate(5));
					
					return dto;
				});
		
		return list;
	}

	@Override
	public JDBCDto selectOne(int seq) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(JDBCDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(JDBCDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int seq) {
		// TODO Auto-generated method stub
		return 0;
	}

}
