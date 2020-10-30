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
		
		list = sqlSession.selectList(NAMESPACE + "selectList");
		
		return list;
	}

	@Override
	public MyBoardDto selectOne(int myno) {
		
		MyBoardDto selectDto = new MyBoardDto();
		
		try {
			selectDto = sqlSession.selectOne(NAMESPACE + "selectOne", myno);
		} catch (Exception e) {
			System.out.println("[ERROR] selectOne");
			e.printStackTrace();
		}
		System.out.println(selectDto);
		return selectDto;
	}

	
	//날짜 처리 해주자
	@Override
	public int insert(MyBoardDto dto) {
		
		int res = 0;
		try {
			res = sqlSession.insert(NAMESPACE + "insert", dto);
		} catch (Exception e) {
			System.out.println("[Error] insert");
		}
		
		return res;
	}
	

	@Override
	public int update(MyBoardDto dto) {
		
		int resultNum = sqlSession.update(NAMESPACE + "update", dto);
				
		return resultNum;
	}

	@Override
	public int delete(int myno) {
		
		int resultNum = sqlSession.delete(NAMESPACE + "delete", myno);
		return resultNum;
	}

	
	
}
