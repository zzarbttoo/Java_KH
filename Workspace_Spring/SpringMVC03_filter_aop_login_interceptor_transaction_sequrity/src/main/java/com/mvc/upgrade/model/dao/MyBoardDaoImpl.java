package com.mvc.upgrade.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mvc.upgrade.model.dto.MyBoardDto;

@Repository
public class MyBoardDaoImpl implements MyBoardDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public List<MyBoardDto> selectList() {
		
		List<MyBoardDto> list = new ArrayList<MyBoardDto>();
		
		try {
			list = sqlSession.selectList(NAMESPACE + "selectList");
		} catch (Exception e) {
			System.out.println("[ERROR] selectList");
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public MyBoardDto selectOne(int myno) {
		
		MyBoardDto dto = null;
		
		try {
			dto = sqlSession.selectOne(NAMESPACE + "selectOne", myno);
		} catch (Exception e) {
			System.out.println("[ERROR] selectOne");
			e.printStackTrace();
		}
		
		return dto;
	}

	@Override
	public int insert(MyBoardDto dto) {
		int res = 0;
		
		try {
			res = sqlSession.insert(NAMESPACE + "insert", dto);
		} catch (Exception e) {
			System.out.println("[ERROR] insert");
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
			System.out.println("[ERROR] update");
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public int delete(int myno) {
		int res = 0;
		
		try {
			res = sqlSession.insert(NAMESPACE + "delete", myno);
		} catch (Exception e) {
			System.out.println("[ERROR] delete");
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public String test() {
		return null;
	}

}














