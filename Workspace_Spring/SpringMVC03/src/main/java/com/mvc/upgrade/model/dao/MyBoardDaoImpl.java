package com.mvc.upgrade.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mvc.upgrade.model.dto.MyBoardDto;

@Repository
public class MyBoardDaoImpl implements MyBoardDao {
	
	@Autowired
	public SqlSessionTemplate sqlSession;

	
	@Override
	public List<MyBoardDto> selectList() {
		
		List<MyBoardDto> dtolist = sqlSession.selectList(NAMESPACE + "selectList");
		System.out.println(dtolist);
		return dtolist;
	}

	@Override
	public MyBoardDto selectOne(int myno) {
		
		MyBoardDto dto = sqlSession.selectOne(NAMESPACE + "selectOne" , myno);
		
		return dto;
	}

	@Override
	public int insert(MyBoardDto dto) {
		int res = 0;
		try {
			res = sqlSession.insert(NAMESPACE + "insert", dto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public int update(MyBoardDto dto) {
		
		int res = 0;
		
		try {
			res = sqlSession.update(NAMESPACE + "update", dto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int delete(int myno) {
		int res = 0;
		
		try {
			res = sqlSession.delete(NAMESPACE + "delete", myno);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return res;
	}
	
	

}
