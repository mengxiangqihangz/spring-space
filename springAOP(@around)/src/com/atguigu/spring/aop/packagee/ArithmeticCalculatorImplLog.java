package com.atguigu.spring.aop.packagee;

import com.atguigu.spring.aop.helloworld.ArithmeticCalculator;

public class ArithmeticCalculatorImplLog implements ArithmeticCalculator {

	@Override
	public int add(int i, int j) {
		System.out.println("the method add begin with["+i+","+j+"]");
		int result=i+j;
		System.out.println("the method add ends with"+result);
		return result;
	}

	@Override
	public int sub(int i, int j) {
		System.out.println("the method sub begin with["+i+","+j+"]");
		int result=i-j;
		System.out.println("the method sub ends with"+result);
		return result;
	}

	@Override
	public int mul(int i, int j) {
		System.out.println("the method mul begin with["+i+","+j+"]");
		int result=i*j;
		System.out.println("the method mul ends with"+result);
		return result;
	}

	@Override
	public int div(int i, int j) {
		System.out.println("the method div begin with["+i+","+j+"]");
		int result=i/j;
		System.out.println("the method div ends with"+result);
		return result;
	}

}
