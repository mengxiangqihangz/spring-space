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
import com.xmm.demo.domain.Emp;
import com.xmm.demo.service.EmpService;

@Controller
@ParentPackage("struts-default") 
@Namespace(value = "/loginAction")
@ExceptionMappings({ @ExceptionMapping(exception = "java.lange.RuntimeException", result = "error") })  
public class LoginAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	@Resource
	private EmpService empService;

	private String empname;
	private String password;

	@Action(value = "login" , results = { @Result(name = "success", location = "/success.jsp"),
										  @Result(name = "failure", location = "/failure.jsp"),
										  @Result(name = "error", location = "/login.jsp")})
	public String login() {

		System.out.println("\n提交的请求参数如下：");
		System.out.println("empname：" + empname);
		System.out.println("password：" + password + "\n");

		int eid = 0;
		try {
			eid = Integer.parseInt(empname);
		} catch (Exception ex) {
		}
//		return SUCCESS;
		Emp emp = empService.findEmpById(eid);// 为了测试结果，这里写死了
		if (emp != null) {
			System.out.println("\n根据主键ID查询记录：查到了，查询成功！");
			System.out.println(emp.toString() + "\n");

			HttpServletRequest request = ServletActionContext.getRequest();// 在Struts2的Action中获取Servlet的原生API
			request.setAttribute("empname", emp.getEname());

			// 注意：这里使用GsonBuilder来创建Gson实例
			Gson gson = new GsonBuilder().setPrettyPrinting().setDateFormat("yyyy-MM-dd HH:mm:ss:SSS").create();
			String empJson = gson.toJson(emp);
			System.out.println("\nEmp对象转化为JSON格式：");
			System.out.println(empJson + "\n");

			return SUCCESS;
		} else {
			System.out.println("\n根据主键ID查询记录：没查到，查询失败，记录不存在！\n");
			return "failure";
		}

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