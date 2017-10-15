package com.justin;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.justin.service.IStage;
import com.justin.service.ITalent;
import com.justin.service.impl.Stage;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		
		ITalent talent = (ITalent)context.getBean("dance");
		talent.show();
		
//		IStage stage = (IStage)context.getBean("stage");
//		stage.start();
	}
}
