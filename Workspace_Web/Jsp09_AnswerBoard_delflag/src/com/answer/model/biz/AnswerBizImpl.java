package com.answer.model.biz;

import java.util.List;

import com.answer.model.dao.AnswerDao;
import com.answer.model.dao.AnswerDaoImpl;
import com.answer.model.dto.AnswerDto;

public class AnswerBizImpl implements AnswerBiz {

	private AnswerDao dao = new AnswerDaoImpl();
	@Override
	public List<AnswerDto> selectList() {
		return dao.selectList();
	}

	@Override
	public AnswerDto selectOne(int boardno) {
		
		
		return dao.selectOne(boardno);
	}

	@Override
	public int insertBoard(AnswerDto dto) {
		return dao.insertBoard(dto);

	}

	@Override
	public int updateBoard(AnswerDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteBoard(int boardno) {
		return dao.deleteBoard(boardno);
	}

	@Override
	public int answerProc(AnswerDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}

}
