package com.me.update.model.biz;

import java.util.List;

import com.me.update.model.dto.MyBoardDto;

public interface MyBoardBiz {

	public List<MyBoardDto> selectList();
	public MyBoardDto selectOne(int myno);
	public int insert(MyBoardDto dto);
	public int update(MyBoardDto dto);
	public int delete(int myno);
}
