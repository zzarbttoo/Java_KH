package com.hw.mvc.model.biz;

import com.hw.mvc.model.dto.MyMemberDto;

public interface MyMemberBiz {

	public MyMemberDto login(MyMemberDto dto);
	public int register(MyMemberDto dto);
}
