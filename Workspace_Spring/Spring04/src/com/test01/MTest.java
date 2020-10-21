package com.test01;

import java.util.Calendar;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test01/applicationContext.xml");
		
		MyClass myClass = (MyClass) factory.getBean("myclass");
		myClass.prn();
		
		Calendar myDate = (Calendar) factory.getBean("date");
		//System.out.println(myDate.getTime());
		
		
		//myDate.set(2020, 11, 25);
		//System.out.println(myDate.getTime());
		
		//System.out.println(factory.getBean("tDate"));
		//System.out.println(factory.getBean("christmas"));
		
		BeanTest beanTest = factory.getBean("beanTest", BeanTest.class);
		
	}
	
}
