package com.sz;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sz.server.Person;

public class Main {
	
	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationcontext.xml");
		Person p = (Person)ctx.getBean("person");
		p.doWork();
	}
}
