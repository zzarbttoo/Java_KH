package com.mvc.biz;

import java.util.List;

import com.mvc.dto.MVCBoardDto;

public interface MVCBoardBiz {

	
	public List<MVCBoardDto> selectList();
	public MVCBoardDto selectOne(int seq);
	public boolean insert(MVCBoardDto dto);
	public boolean update(MVCBoardDto dto);
	public boolean delete(int seq);
	
	
}
