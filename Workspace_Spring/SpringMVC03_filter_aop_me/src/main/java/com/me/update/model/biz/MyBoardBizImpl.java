package com.me.update.model.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.me.update.model.dao.MyBoardDao;
import com.me.update.model.dto.MyBoardDto;

@Service
public class MyBoardBizImpl implements MyBoardBiz {
	
	@Autowired
	private MyBoardDao dao;

	@Override
	public List<MyBoardDto> selectList() {
		return dao.selectList();
	}

	@Override
	public MyBoardDto selectOne(int myno) {
		// TODO Auto-generated method stub
		return dao.selectOne(myno);
	}

	@Override
	public int insert(MyBoardDto dto) {
		// TODO Auto-generated method stub
		return dao.insert(dto);
	}

	@Override
	public int update(MyBoardDto dto) {
		// TODO Auto-generated method stub
		return dao.update(dto);
	}

	@Override
	public int delete(int myno) {
		// TODO Auto-generated method stub
		return dao.delete(myno);
	}

}
