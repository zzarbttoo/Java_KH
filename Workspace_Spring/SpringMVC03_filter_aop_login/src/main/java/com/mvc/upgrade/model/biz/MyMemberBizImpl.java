package com.mvc.upgrade.model.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.upgrade.model.dao.MyMemberDao;
import com.mvc.upgrade.model.dto.MyMemberDto;

@Service
public class MyMemberBizImpl implements MyMemberBiz {

	@Autowired
	private MyMemberDao dao;
	
	@Override
	public MyMemberDto login(MyMemberDto dto) {
		return dao.login(dto);
	}

	@Override
	public int register(MyMemberDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}

}
