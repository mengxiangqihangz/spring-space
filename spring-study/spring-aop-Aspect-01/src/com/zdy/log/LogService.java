package com.zdy.log;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogService {
	
	@Pointcut("execution(* com.zdy.service.*.*(..))")
	public void cut(){
		
	}
	
	@Before("cut()")
	public void writeLog(){
		System.out.println("我在记日志");
	}
}
