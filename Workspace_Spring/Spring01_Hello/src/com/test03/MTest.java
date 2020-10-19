package com.test03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {
	
	public static void main(String[] args) {
		// 1. 
		// Resource res = new FileSystemResource("src/com/test03/beans.xml");
		
		//2. 
		//Resource res = new ClassPathResource("com/test03/beans.xml");
		//BeanFactory factory = new XmlBeanFactory(res);
		
		//3.
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test03/beans.xml");
		MessageBean bean = (MessageBean) factory.getBean("korean");
		bean.sayHello("스프링");
		
		bean = (MessageBean) factory.getBean("english");
		bean.sayHello("Spring");
	}

}
/*
	
	1. ApplicationContext와 ClassPathXmlApplicationContext
	BeanFactory <- ApplicationContext <- ClassPathXmlApplicationContext (<-는 상속받았다는 것)
	스프링의 ApplicationContext 객체는 스프링 컨테이너 인스턴스이다.
	스프링은 ApplicationContext 인터페이스의 몇가지 기본 구현을 제공하는데,
	그 중 ClassPathXmlApplicationContext는 XML 형식의 독립형 어플리케이션에 적합하다
	-> 지정된 classpath(경로) 에서 xml 파일을 읽어서 사용한다 
	
	2. context, context, container
	content : 기능
	context : 기능을 구현하기 위한 정보(설정)
	container : 담는 그릇
	
*/