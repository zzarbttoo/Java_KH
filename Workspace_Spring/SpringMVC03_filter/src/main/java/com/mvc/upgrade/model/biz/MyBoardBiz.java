package com.mvc.upgrade.model.biz;

import java.util.List;

import com.mvc.upgrade.model.dto.MyBoardDto;

import java.util.List;

import com.mvc.upgrade.model.dto.MyBoardDto;

public interface MyBoardBiz {

	public List<MyBoardDto> selectList();
	public MyBoardDto selectOne(int myno);
	public int insert(MyBoardDto dto);
	public int update(MyBoardDto dto);
	public int delete(int myno);
}
