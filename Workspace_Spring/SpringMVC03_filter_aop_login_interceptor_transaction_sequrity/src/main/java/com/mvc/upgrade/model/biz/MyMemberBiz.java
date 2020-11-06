package com.mvc.upgrade.model.biz;

import com.mvc.upgrade.model.dto.MyMemberDto;

public interface MyMemberBiz {

	public MyMemberDto login(MyMemberDto dto);
	public int register(MyMemberDto dto);
}
