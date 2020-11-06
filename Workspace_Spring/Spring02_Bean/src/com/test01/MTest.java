package com.test01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test01/applicationContext.xml");

		MessageBean strawberry = (MessageBean) factory.getBean("strawberry");
		strawberry.sayHello("김선아");

		MessageBean orange = (MessageBean) factory.getBean("orange");
		orange.sayHello("최희선");
		
		MessageBean banana = (MessageBean) factory.getBean("banana");
		banana.sayHello("장성윤");
				
	}

}
