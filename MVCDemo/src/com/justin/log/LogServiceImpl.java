package com.justin.log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.justin.service.ITalent;

@Component("log")
@Aspect
public class LogServiceImpl {
	
	@Pointcut("execution(* com.justin.service.*.*(..))")
	public void aspect () {
		
	}
	
	@Before("aspect ()")
	public void writeLog (JoinPoint jp) {
		Object obj[] = jp.getArgs();
		for (int i = 0; i < obj.length; i++) {
			System.out.println(obj[i].toString());
		}
		System.out.println("记录日志信息！");
	}
	
	@Around("aspect ()")
	public void writeAround (ProceedingJoinPoint pjp) {
		long startTime = System.currentTimeMillis();
		
		try {
			pjp.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		long endTime = System.currentTimeMillis();
		
		System.out.println("被代理方法执行的时间为:" + (endTime - startTime));
	}
}
