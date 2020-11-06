package com.hw.mvc.model.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hw.mvc.model.dao.MyBoardDao;
import com.hw.mvc.model.dto.MyBoardDto;

@Service
public class MyBoardBizImpl implements MyBoardBiz {

	@Autowired
	MyBoardDao dao;
	
	@Override
	public List<MyBoardDto> selectList() {
		return dao.selectList();
	}

	@Override
	public MyBoardDto selectOne(int myno) {
		return dao.selectOne(myno);
	}

	@Override
	public int delete(int myno) {
		return dao.delete(myno);
	}

	@Override
	public int update(MyBoardDto dto) {
		return dao.update(dto);
	}

	@Override
	public int insert(MyBoardDto dto) {
		return dao.insert(dto);
	}

	@Transactional
	@Override
	public String test() {
		
		dao.insert(new MyBoardDto(0, "transaction", "test", "insert", null));
		
		String test = dao.test();
		
		test.length();
		
		return test;
	}

}
