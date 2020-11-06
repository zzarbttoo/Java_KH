package com.mvc.upgrade.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mvc.upgrade.model.dto.MyMemberDto;
@Repository
public class MyMemberDaoImpl implements MyMemberDao {

	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public MyMemberDto login(MyMemberDto dto) {
		
		MyMemberDto res = null;
		
		try {
			res = sqlSession.selectOne(NAMESPACE + "login", dto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("login mybatis 에러!");
			e.printStackTrace();
		}
			
		
		return res;
	}

	@Override
	public int register(MyMemberDto dto) {
		
		int res = 0;
		
		 try {
			res = sqlSession.insert(NAMESPACE + "register", dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return res;
	}

}
