package com.atguigu.spring.aop.Priority;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class VlidationAspect {
	@Before("execution(public int com.atguigu.spring.aop.helloworld.ArithmeticCalculator.*(int,int))")
	public void VlidateArgs(JoinPoint joinPoint){
		System.out.println("validate: "+Arrays.asList(joinPoint.getArgs()));
	}
}
