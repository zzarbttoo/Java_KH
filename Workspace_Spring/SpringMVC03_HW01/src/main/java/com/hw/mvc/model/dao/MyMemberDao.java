package com.hw.mvc.model.dao;

import com.hw.mvc.model.dto.MyMemberDto;

public interface MyMemberDao {

	String NAMESPACE ="com.mymember.";
	
	public MyMemberDto login(MyMemberDto dto);
	public int register(MyMemberDto dto);
}
