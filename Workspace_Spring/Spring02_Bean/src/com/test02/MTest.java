package com.test02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {
	
	public static void main(String[] args) {
		
		//classpath : 경로이기 때문에 /
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test02/applicationContext.xml");
		
		Address lee = (Address) factory.getBean("lee");
		System.out.println(lee.toString());
		
		Address hong = (Address) factory.getBean("hong");
		System.out.println(hong.toString());
	}

}
