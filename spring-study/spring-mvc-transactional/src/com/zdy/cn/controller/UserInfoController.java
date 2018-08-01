package com.zdy.cn.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zdy.cn.model.UserInfo;
import com.zdy.cn.service.IUserInfoService;
import com.zdy.cn.service.imp.UseInfoServiceImp;

public class UserInfoController {
	
	ApplicationContext context = new ClassPathXmlApplicationContext("com/zdy/cn/resource/spring.xml");
	public UserInfoController(){
	}
	
	public IUserInfoService getUseInfoServiceImp(){
		return (IUserInfoService)context.getBean("useInfoServiceImp");
	}

	public String login(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("userName");
		String pwd = request.getParameter("userPwd");
		UserInfo user = new UserInfo();
		user.setName(name);
		user.setPwd(pwd);		
		boolean flag = getUseInfoServiceImp().login(user);		
		if(flag){
			List<UserInfo> listUser = getUseInfoServiceImp().findAll();
			request.setAttribute("list", listUser);
			return "success";
		}else{
			return "fail";
		}
	}

	public String regist(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		String age = request.getParameter("age");
		String addr = request.getParameter("addr");
		UserInfo user = new UserInfo();
		user.setName(name);
		user.setPwd(pwd);
		user.setAge(Integer.parseInt(age));
		user.setAddr(addr);
		boolean flag = getUseInfoServiceImp().regist(user);
		if(flag){
			return "success";
		}else{
			return "fail";
		}
	}
	
	public String edit(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		UserInfo user = getUseInfoServiceImp().edit(id);
		request.setAttribute("user", user);
		request.setAttribute("method", "edit");
		return "edit";
	}
	
	public String update(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String name = new String(request.getParameter("name").getBytes("ISO-8859-1"),"UTF-8");
		String pwd = request.getParameter("pwd");
		String age = request.getParameter("age");
		String addr = new String(request.getParameter("addr").getBytes("ISO-8859-1"),"UTF-8");
		UserInfo user = new UserInfo();
		user.setId(Integer.parseInt(id));
		user.setName(name);
		user.setPwd(pwd);
		user.setAge(Integer.parseInt(age));
		user.setAddr(addr);		
		boolean flag = getUseInfoServiceImp().update(user);
		if(flag){
			List<UserInfo> listUser = getUseInfoServiceImp().findAll();
			request.setAttribute("list", listUser);
			return "success";
		}else{
			return "fail";
		}
	}
}
