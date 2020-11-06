package com.hw.mvc.model.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hw.mvc.model.dao.MyMemberDao;
import com.hw.mvc.model.dto.MyMemberDto;

@Service
public class MyMemberBizImpl implements MyMemberBiz {

	@Autowired
	MyMemberDao dao;
	
	@Override
	public MyMemberDto login(MyMemberDto dto) {
		return dao.login(dto);
	}

	@Override
	public int register(MyMemberDto dto) {
		return dao.register(dto);
	}

}
