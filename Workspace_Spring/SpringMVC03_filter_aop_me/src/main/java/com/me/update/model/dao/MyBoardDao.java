package com.me.update.model.dao;

import java.util.List;

import com.me.update.model.dto.MyBoardDto;

public interface MyBoardDao {

	String NAMESPACE = "com.myboard.";
	
	public List<MyBoardDto> selectList();
	public MyBoardDto selectOne(int myno);
	public int insert(MyBoardDto dto);
	public int update(MyBoardDto dto);
	public int delete(int myno);
	
}
