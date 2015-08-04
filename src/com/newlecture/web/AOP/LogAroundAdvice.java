package com.newlecture.web.AOP;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.util.StopWatch;

public class LogAroundAdvice implements MethodInterceptor{
	
	@Override
	public Object invoke(MethodInvocation method) throws Throwable {
		
		StopWatch sw = new StopWatch();
		
		System.out.println("[�ð�üũ] ȣ�� ����");
		sw.start();
		
		Object result = method.proceed();//prince�� ȣ�� joinpoint weaving
		
		System.out.println("[�ð�üũ] ȣ�� ����");
		sw.stop();
		System.out.println("[TIMELOG]Method : " + method.getMethod().getName());
		System.out.println("[TIMELOG]Process TIME : " + sw.getTotalTimeMillis());
		
		return result;
	}
	
}
