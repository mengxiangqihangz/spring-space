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
		 * ��scope Ϊ prototype ʱ ����������������� hashcode�ǲ�һ���ġ�
		 * ��scope Ϊ singleton ʱ ��Car�Ĺ�����ֻ��ִ��һ�Ρ�
		 */
//		System.out.println();
		
		
	}

}
