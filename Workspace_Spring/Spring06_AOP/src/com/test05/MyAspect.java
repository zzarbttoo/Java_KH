package com.test05;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
public class MyAspect {

	//pointcut을 일일히 치기 귀찮아 myClass에 담아두었다
	@Pointcut("execution(public * *(..))")
	public void myClass() {
		
		
	}
	
	@Before("myClass()")
	public void before() {
		System.out.println("출석카드를 찍는다");
	}
	
	@After("myClass()")
	public void after() {
		System.out.println("집에 간다");
	}
}
