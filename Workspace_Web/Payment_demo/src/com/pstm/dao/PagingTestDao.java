package com.pstm.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.pstm.dto.PagingTestDto;

public class PagingTestDao extends PagingMapConfig{


	public List<PagingTestDto> selectAllTestPaging(int offset, int count){
	 
		SqlSession session = null;
		
		List<PagingTestDto> list = new ArrayList<PagingTestDto>();
		session = getSqlSessionFactory().openSession(true);
		
		System.out.println("세션 확인");
		
		HashMap<String, Object> parameters = new HashMap<String, Object>();
		
		parameters.put("offset", offset);
		parameters.put("count", count);
		
		try {
			//list = session.selectList("pagingmapper.selectTestPaging", parameters);
			list = session.selectList("pagingmapper.selectTestPaging");
			System.out.println(" 값 도착");
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
			System.out.println("세션 닫음");
		}
		
		return list; 
		
	}
	
	public int getNoFoRecord() {
		
		SqlSession session = null;
		session = getSqlSessionFactory().openSession(true);
		
		int noOfRecords = 0;
	
		try {
			noOfRecords = session.selectOne("pagingmapper.selectTotalRecords");
			System.out.println(noOfRecords);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			session.close();
		}
		
		return noOfRecords;
	}
	
	
}
