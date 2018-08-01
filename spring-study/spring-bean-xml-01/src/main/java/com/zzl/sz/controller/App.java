package com.zzl.sz.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zzl.sz.service.Server;

public class App {
	
	public static void main(String[] args) {
		//1. 创建spring 的 ioc 容器
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		//2. 从容器中获取 bean
		Server serverImpl = (Server) context.getBean("serverImpl");
		//3. 调用方法
		String value = serverImpl.doJob();
//		System.out.println(value);
		

	}
}
