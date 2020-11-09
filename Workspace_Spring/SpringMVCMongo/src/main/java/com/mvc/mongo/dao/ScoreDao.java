package com.mvc.mongo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.mvc.mongo.dto.ScoreDto;

@Repository
public class ScoreDao {

	@Autowired
	private MongoTemplate mongoTemplate;
	
	public List<ScoreDto> findAll(){
		
		List<ScoreDto> list=  mongoTemplate.findAll(ScoreDto.class, "score");
		return list;
		
	}
	
}
