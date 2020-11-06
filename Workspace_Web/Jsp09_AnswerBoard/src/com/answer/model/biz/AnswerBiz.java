package com.answer.model.biz;

import java.util.List;

import com.answer.model.dto.AnswerDto;

public interface AnswerBiz {

	public List<AnswerDto> selectList();
	public AnswerDto selectOne(int boardno);
	public int delete(int boardno);
	public int update(AnswerDto dto);
	public int insert(AnswerDto dto);
		
	//updateAnswer, insertAnswer을 한번에 호출하고 이것이 트랜젝션 처리 될 것이다
	public int answerProc(AnswerDto dto);
	
}
