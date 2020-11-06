package com.test01.anno;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	
	public static void main(String[] args) {
		
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test01/anno/applicationContext.xml");
		
		//@component 걸려있는 class랑 같지만, 첫글자만 소문자로 한다
		MyNickNamePrn my = factory.getBean("myNickNamePrn", MyNickNamePrn.class);
		
		System.out.println(my);
	}
	
}
