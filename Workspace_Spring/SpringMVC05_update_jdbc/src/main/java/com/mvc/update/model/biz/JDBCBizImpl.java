package com.mvc.update.model.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.update.model.dao.JDBCDao;
import com.mvc.update.model.dto.JDBCDto;

@Service
public class JDBCBizImpl implements JDBCBiz {

	@Autowired
	private JDBCDao dao;
	
	@Override
	public List<JDBCDto> selectList() {
		return dao.selectList();
	}

	@Override
	public JDBCDto selectOne(int seq) {
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
