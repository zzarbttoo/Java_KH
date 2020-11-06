package com.pstm.biz;

import java.util.List;

import com.pstm.dao.PagingTestDao;
import com.pstm.dto.PagingTestDto;

public class PagingTestBiz {

	
	private PagingTestDao pagingTestDao;
	
	public List<PagingTestDto> selectAllTestPaging(int offset, int count ){
		
		System.out.println("biz 도착");
		return pagingTestDao.selectAllTestPaging(offset, count);
	}
	
	

}
