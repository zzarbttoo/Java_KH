package com.test04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test04/beans.xml");
		
		Emp lee = (Emp) factory.getBean("lee");
		Emp hong = (Emp) factory.getBean("hong");
		
		System.out.println(lee);
		System.out.println(hong);
		
		Developer leess = (Developer) factory.getBean("leess");
		Engineer honggd = (Engineer) factory.getBean("honggd");
		System.out.println(honggd);
		System.out.println(leess);
		
		
	}
	
}
