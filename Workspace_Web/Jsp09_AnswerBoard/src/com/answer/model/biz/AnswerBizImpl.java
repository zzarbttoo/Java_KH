package com.answer.model.biz;

import java.util.List;

import com.answer.model.dao.AnswerDaoImpl;
import com.answer.model.dto.AnswerDto;

public class AnswerBizImpl implements AnswerBiz {

	AnswerDaoImpl dao = new AnswerDaoImpl();
	
	@Override
	public List<AnswerDto> selectList() {
		
		return dao.selectList();
		
	}

	@Override
	public AnswerDto selectOne(int boardno) {
		return dao.selectOne(boardno);
	}

	@Override
	public int delete(int boardno) {
		return dao.delete(boardno);
	}


	@Override
	public int update(AnswerDto dto) {
		return dao.update(dto);
	}

	@Override
	public int insert(AnswerDto dto) {
		return dao.insert(dto);
	}

	@Override
	public int answerProc(AnswerDto dto) {
		
		//parentgroupseq = 0 -> 본글이므로 update x 그냥 추가
		//만약에 맨 뒤에 다는거면, 그거도 따로 처리해줘야함
		//아니면 update->insert
		
		/*
		//일단 그냥 짜보자
		if(dao.updateAnswer(dto.getBoardno())==0){
			
			System.out.println("DEBUG1");
			System.out.println("마지막 댓글");
			return dao.insertAnswer(dto);
			
			
		}else {
			
			System.out.println("댓글 순서 변경이 일어남");
			return dao.insertAnswer(dto);
		}
		*/
		
		//여기는 트랜잭션 아직은 걸지 않았다 
		//나중에는 commit을 biz에서 하면 transaction 처리가 되는 것이다
		int update = dao.updateAnswer(dto.getBoardno());
		int insert = dao.insertAnswer(dto);
		return update + insert;
		
		
	}
		
}
