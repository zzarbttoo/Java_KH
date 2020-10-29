package com.mvc.upgrade.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mvc.upgrade.model.dto.MyBoardDto;

@Repository
public class MyBoardDaoImpl implements MyBoardDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<MyBoardDto> selectList() {
		
		List<MyBoardDto> list = new ArrayList<MyBoardDto>();
		
		list = sqlSession.selectList(NAMESPACE + "selectList");
		
		return list;
	}

	@Override
	public MyBoardDto selectOne(int myno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(MyBoardDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(MyBoardDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int myno) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	
}
