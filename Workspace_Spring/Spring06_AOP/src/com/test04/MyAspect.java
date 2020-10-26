package com.test04;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class MyAspect {

	//아까 리턴타입이 void여서 return이 안됐다
	@Before("execution(public String *(..))")
	public void before() {
		
		System.out.println("출석 카드를 찍는다.");
		
	}
	
	@AfterThrowing("execution(public * *(..))")
	public void throwing() {
		
		System.out.println("쉬는 날 이었다");
		
	}
	
	//com.test04의 어떤 class의 어떤 메소드
	@After("execution(public * com.test04.*.*(..))")
	public void after() {
		System.out.println("집에 간다.");
	}
	
	@AfterReturning(pointcut = "execution(public * *(..))", returning= "returnVal")
	public void returning(Object returnVal) {
		System.out.println(returnVal + "!!!!");
	}
	
}
