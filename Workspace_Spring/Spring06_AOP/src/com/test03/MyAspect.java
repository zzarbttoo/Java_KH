package com.test03;

import org.aspectj.lang.JoinPoint;

public class MyAspect {

	//org.aspectj.lang.JoinPoint
	public void before(JoinPoint join) {
		
		System.out.println("출석 카드를 찍는다");
		System.out.println(join.getTarget().getClass());
		System.out.println(join.getSignature().getName());
	}
	public void after(JoinPoint join) {
		
		System.out.println("집에 간다");
		
	}
	
}
