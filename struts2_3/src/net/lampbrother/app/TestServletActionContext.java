package net.lampbrother.app;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class TestServletActionContext extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String execute() throws Exception {

		//1. 利用 ServletActionContext 获取 ServletContext 对象
		ServletContext servletContext = ServletActionContext.getServletContext();
		
		//2. 获取 HttpServletRequest 对象
		HttpServletRequest request = ServletActionContext.getRequest();
		
		//2. 获取 HttpSession 对象
		HttpSession session = request.getSession();
		
		return SUCCESS;
	}
}
