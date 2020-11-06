package com.test02;

public class MessageBeanKo implements MessageBean{

	@Override
	public void sayHello(String name) {
		
		System.out.printf("안녕하세요  %s 님!\n", name);
	}

}
