package com.newlecture.web.AOP;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.util.StopWatch;

public class LogAroundAdvice implements MethodInterceptor{
	
	@Override
	public Object invoke(MethodInvocation method) throws Throwable {
		
		StopWatch sw = new StopWatch();
		
		System.out.println("[시간체크] 호출 시작");
		sw.start();
		
		Object result = method.proceed();//prince를 호출 joinpoint weaving
		
		System.out.println("[시간체크] 호출 종료");
		sw.stop();
		System.out.println("[TIMELOG]Method : " + method.getMethod().getName());
		System.out.println("[TIMELOG]Process TIME : " + sw.getTotalTimeMillis());
		
		return result;
	}
	
}
