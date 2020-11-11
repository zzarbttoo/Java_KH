package com.boot.jdbc.model.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.jdbc.model.dto.MyDto;
import com.boot.jdbc.model.mapper.MyBoardMapper;

@Service
public class MyBizImpl implements MyBiz {

	
	@Autowired
	private MyBoardMapper myboardMapper;
	
	@Override
	public List<MyDto> selectList() {
		return myboardMapper.selectList();

	}

	@Override
	public MyDto selectOne(int myno) {
		return myboardMapper.selectOne(myno);
	}

	@Override
	public int insert(MyDto dto) {
		return myboardMapper.insert(dto);
	}

	@Override
	public int update(MyDto dto) {
		return myboardMapper.update(dto);
	}

	@Override
	public int delete(int myno) {
		return myboardMapper.delete(myno);
	}

	
	
}
