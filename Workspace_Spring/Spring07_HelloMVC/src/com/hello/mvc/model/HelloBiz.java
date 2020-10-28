package com.hello.mvc.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//이친구는 biz인 것을 알려준다
//객체 생성 빼고는 하는 것이 없지만, 
@Service
public class HelloBiz {

	//TODO : 06.Dao(@Repository) 호출
	@Autowired
	private HelloDao dao;
	
	public String getHello() {
		//TODO : 08. Biz 에서 return
		return "Hello," + dao.getHello();
	}
	
}
