package com.test07;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.util.StopWatch;

public class LoggingAdvice implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		
		String methodName = invocation.getMethod().getName();
		StopWatch timer = new StopWatch();
		
		
		timer.start(methodName);
		//target 전(Before)
		System.out.println("[LOG] METHOD : " + methodName + "is Calling");
		//target
		Object target=  invocation.proceed();
		timer.stop();
		//target 후(after)
		System.out.println("[LOG] METHOD :"+  methodName + "was Called");
		System.out.println("[LOG] TIME :" + timer.getTotalTimeSeconds() + "sec");
		
		return target;
	}

	
	
}
