package com.atguigu.spring.aop.helloworld.imp;

import org.springframework.stereotype.Component;

import com.atguigu.spring.aop.helloworld.ArithmeticCalculator;

/**
 * 方法实现类
 * @author liang
 *
 */
@Component
public class ArithmeticCalculatorImpl implements ArithmeticCalculator {

	@Override
	public int add(int i, int j) {
		int result=i+j;
		return result;
	}

	@Override
	public int sub(int i, int j) {
		int result=i-j;
		return result;
	}

	@Override
	public int mul(int i, int j) {
		int result=i*j;
		return result;
	}

	@Override
	public int div(int i, int j) {
		int result=i/j;
		return result;
	}

}
