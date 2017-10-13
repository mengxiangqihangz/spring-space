package com.xmm.demo.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ExceptionMapping;
import org.apache.struts2.convention.annotation.ExceptionMappings;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@ParentPackage("struts-default") 
@Namespace(value = "/loginAction/")
@ExceptionMappings({ @ExceptionMapping(exception = "java.lange.RuntimeException", result = "error") })  
public class LoginAction extends ActionSupport {

	private static final long serialVersionUID = 1L;


	private String empname;
	private String password;

	@Action(value = "login")
	public String login() {

		System.out.println("\n提交的请求参数如下：");
		System.out.println("empname：" + empname);
		System.out.println("password：" + password + "\n");

		return SUCCESS;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	public String getEmpname() {
		return empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}