package com.hw.mvc.model.biz;

import java.util.List;

import com.hw.mvc.model.dto.MyBoardDto;

public interface MyBoardBiz {
	public List<MyBoardDto> selectList();
	public MyBoardDto selectOne(int myno);
	public int delete(int myno);
	public int update(MyBoardDto dto);
	public int insert(MyBoardDto dto);
	public String test();
	
}
