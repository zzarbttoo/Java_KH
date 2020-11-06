package com.hello.mvc.model;

import org.springframework.stereotype.Repository;

//얘가 다오라는 것을 알려준다
//exception을 data exception으로 바꿔주는 친구
@Repository
public class HelloDao {

	//TODO : 07.Dao 에서 return
	public String getHello() {
		return "Spring";
	}

}
