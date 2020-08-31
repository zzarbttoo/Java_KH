package com.my.dao;



import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.my.dto.MyBoardDto;

public class MyBoardDao extends SqlMapConfig {

	
	private String namespace ="myboardmapper.";
	
	public List<MyBoardDto> selectList() {
		SqlSession session = null;
		
		List<MyBoardDto> list = new ArrayList<MyBoardDto>();
		session = getSqlSessionFactory().openSession(true);
		//list = session.selsctList("myboardmapper.selectList")
		
		list = session.selectList(namespace + "selectList");
		

		return list;

	}

	public MyBoardDto selectOne(int myno) {
		
		SqlSession session= null;
		
		MyBoardDto dto = null;
		session = getSqlSessionFactory().openSession(true);
		dto = session.selectOne(namespace + "selectOne", myno);
		
		session.close();
		
		return dto;

	}

	public int insert(MyBoardDto dto) {
		
		SqlSession session = null;
		
		int res = 0;
		session = getSqlSessionFactory().openSession(true);
		res = session.insert(namespace + "insert", dto) ;
		session.close();
		
		System.out.println("왜안됨"+ res);
		

		return res;

	}

	public int update(MyBoardDto dto) {

		SqlSession session = null;
		
		int res = 0;
		session = getSqlSessionFactory().openSession(true);
		res = session.update(namespace + "update", dto);
		
		session.close();
		return res;

	}

	public int delete(int myno) {

		return 0;
	}

}
