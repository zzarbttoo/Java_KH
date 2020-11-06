package com.score.biz;

import java.util.List;

import com.score.dao.ScoreDao;
import com.score.dto.ScoreDto;

public class ScoreBiz {

	
	private ScoreDao dao = new ScoreDao();
	
	public List<ScoreDto> selectList(){
		
		return dao.selectList();
	}
	
	public ScoreDto selectOne(String name) {
		
		return dao.selectOne(name);
	}
	
	public int insert(ScoreDto dto) {
		
		return dao.insert(dto);
	}
	
	public int update(ScoreDto dto) {
		
		return dao.update(dto);
	}
	
	public int delete(String name) {
		
		return dao.delete(name);
		
	}

	public ScoreDto selectFirst() {
		
		//dao에서 Dto 를 리턴하도록
		return dao.selectFirst();
	}
	
	public ScoreDto selectSecond() {
		
		return dao.selectSecond();
	}
	
	public ScoreDto selectThird() {
		
		return dao.selectThird();
	}
	
	public ScoreDto topN(int n) {
		
		return dao.topN(n);
	}
	
	
	
	
	
}
