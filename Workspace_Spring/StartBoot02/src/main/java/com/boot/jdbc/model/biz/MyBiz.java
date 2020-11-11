package com.boot.jdbc.model.biz;

import java.util.List;

import com.boot.jdbc.model.dto.MyDto;


public interface MyBiz {

	List<MyDto> selectList();
	MyDto selectOne(int myno);
	int insert(MyDto dto);
	int update(MyDto dto);
	int delete(int myno);
	
}
