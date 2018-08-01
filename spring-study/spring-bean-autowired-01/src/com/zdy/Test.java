package com.zdy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zdy.service.IStage;
import com.zdy.service.ITalent;

public class Test {

	public static void main(String[] args) {
		
		ApplicationContext context=new ClassPathXmlApplicationContext("com/resource/springaop.xml");
		IStage stage=(IStage)context.getBean("stage");
		stage.show();
		
	}
}
