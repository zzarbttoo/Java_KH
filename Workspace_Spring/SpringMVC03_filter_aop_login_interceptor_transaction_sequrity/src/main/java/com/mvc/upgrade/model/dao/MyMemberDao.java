package com.mvc.upgrade.model.dao;

import com.mvc.upgrade.model.dto.MyMemberDto;

public interface MyMemberDao {

	String NAMESPACE = "member.";
	
	public MyMemberDto login(MyMemberDto dto);
	public int register(MyMemberDto dto);
	
}
