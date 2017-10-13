package com.zdy.cn.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zdy.cn.program.instrumentalist.IPerformer;
import com.zdy.cn.springinaction.knights.Knight;

public class LoginController extends HttpServlet {
	ApplicationContext context;
	
	@Override
	public void init() throws ServletException {
//		context=new ClassPathXmlApplicationContext("resource/spring.xml");
		context=new ClassPathXmlApplicationContext("resource/program.xml");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String str=req.getParameter("name");
//		Knight knight=(Knight)context.getBean(str);
//		knight.work();
		IPerformer instrumentalist=(IPerformer)context.getBean("onemanban");
		instrumentalist.perform();
		
	}

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.service(arg0, arg1);
	}
	
			
}
