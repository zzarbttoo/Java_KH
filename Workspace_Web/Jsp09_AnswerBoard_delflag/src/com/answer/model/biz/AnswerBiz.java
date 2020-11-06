package com.answer.model.biz;

import java.util.List;

import com.answer.model.dto.AnswerDto;

public interface AnswerBiz {
	
	public List<AnswerDto> selectList();
	public AnswerDto selectOne(int boardno);
	public int insertBoard(AnswerDto dto);
	public int updateBoard(AnswerDto dto);
	public int deleteBoard(int boardno);
	public int answerProc(AnswerDto dto);
	
}
