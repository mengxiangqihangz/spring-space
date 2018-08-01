package com.sz;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@ComponentScan
public class Main {

	
	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-scope.xml");
//		Car car = (Car)ctx.getBean("car");
//		Car car2 = (Car)ctx.getBean("car");
		App app = (App)ctx.getBean("app");
		App2 app2 = (App2)ctx.getBean("app2");
		app.proc();
		app2.proc();

		/**
		 * 当scope 为 prototype 时 ，创建的两个对象的 hashcode是不一样的。
		 * 当scope 为 singleton 时 ，Car的构造器只会执行一次。
		 */
//		System.out.println();
		
		
	}

}
