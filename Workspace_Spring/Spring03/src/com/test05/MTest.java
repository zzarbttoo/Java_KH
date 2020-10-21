package com.test05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test05/applicationContextCP.xml");
		
		//Emp lee = (Emp) factory.getBean("lee");
		//Emp hong = (Emp) factory.getBean("hong");
		
		//System.out.println(lee);
		//System.out.println(hong);
		
		Developer leess = (Developer) factory.getBean("leess");
		Engineer honggd = (Engineer) factory.getBean("honggd");
		
		System.out.println(leess);
		System.out.println(honggd);
		
		//factory는 classpathxmlApplicationContext에 들어가있다 
		//그러므로 자식타입으로 전한한 뒤 close를 했다
		//하지만 나중에는 이거 할 일이 없을 것이다 
		((ClassPathXmlApplicationContext) factory).close();
		
		
		
	}
	
}
