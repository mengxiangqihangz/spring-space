package com.atguigu.spring.aop.helloworld;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopTest {
	public static void main(String[] args) {
		
		ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		ArithmeticCalculator arith=(ArithmeticCalculator) ctx.getBean("arithmeticCalculatorImpl");
		int result=arith.add(10, 5);
		System.out.println(result);
		
		int resul=arith.div(16, 4);		
		//int resul=arith.div(16, 0);		
		System.out.println(resul);
	}

}
