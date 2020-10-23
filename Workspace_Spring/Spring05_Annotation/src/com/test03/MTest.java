package com.test03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {
public static void main(String[] args) {
	ApplicationContext factory =new ClassPathXmlApplicationContext("com/test03/applicationContext.xml");
	
	TV igTV = factory.getBean("igTV" , TV.class);
	igTV.powerOn();
	
	TV samsong = (TV) factory.getBean("samsong");
	TV samsongzzap = (TV) factory.getBean("samsong", SamsongTV.class);
	
	samsong.powerOn();
	samsongzzap.volumeDown();
}
}
