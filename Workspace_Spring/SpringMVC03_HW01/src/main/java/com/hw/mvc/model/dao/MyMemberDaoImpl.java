package com.hw.mvc.model.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hw.mvc.model.dto.MyMemberDto;

@Repository
public class MyMemberDaoImpl implements MyMemberDao {
	
	@Autowired
	public SqlSession sqlSession;

	@Override
	public MyMemberDto login(MyMemberDto dto) {
		
		MyMemberDto res = null;
		
		try {
			res = sqlSession.selectOne(NAMESPACE + "selectOne", dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public int register(MyMemberDto dto) {
		
		int res = 0;
		
		try {
			res = sqlSession.insert(NAMESPACE + "insert" , dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return res;
	}

	

}
