package com.muldel.dao;

import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.muldel.dto.MDBoardDto;

public class MDBoardDao extends SqlMapConfig{

	private String namespace = "com.multi.mdboard.";
	
	private SqlSessionFactory sqlSessionFactory;
	public SqlSessionFactory getSqlSessionFactory() {
		
		String resource = "com/muldel/db/multi-config.xml";
		try {
			Reader reader = Resources.getResourceAsReader(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return sqlSessionFactory;
		
	}
	
	public List<MDBoardDto> selectList() {
		List<MDBoardDto> list = new ArrayList<MDBoardDto>();
		
		SqlSession session= null;
		
		//try catch 안해도 되지만, 그래도 해주는 것이 좋다 어떻게 에러가 났는 지 보고 싶어서 
		try {
			session = getSqlSessionFactory().openSession(false);
			list = session.selectList(namespace + "selectList");
		} catch (Exception e) { 
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		System.out.println("어디가 문제임"+ session);
		System.out.println(list);
		
		return list;
	}

	public MDBoardDto selectOne(int seq) {

		return null;
	
	}

	public int update(MDBoardDto dto) {

		return 0;
	}

	public int delete(int seq) {

		return 0;
	}

	public int insert(MDBoardDto dto) {

		return 0;

	}

	// delete at Once
	public int multiDelete(String[] seqs) {
		int count = 0;
		
		Map<String, String[]> map = new HashMap<String, String[]>();
		map.put("seqs", seqs);
		
		SqlSession session = null;
		
		try {
			session = getSqlSessionFactory().openSession(false);
			count = session.delete(namespace + "muldel", map);
			
			//삭제된 값이 배열 길이와 같다면 commit
			if(count == seqs.length) {
				
				session.commit();
			}else {
				session.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}finally {
			
			session.close();
		}
		
		
		
		return count;
	}

}
