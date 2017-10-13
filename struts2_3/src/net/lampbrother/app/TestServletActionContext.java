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

		//1. ���� ServletActionContext ��ȡ ServletContext ����
		ServletContext servletContext = ServletActionContext.getServletContext();
		
		//2. ��ȡ HttpServletRequest ����
		HttpServletRequest request = ServletActionContext.getRequest();
		
		//2. ��ȡ HttpSession ����
		HttpSession session = request.getSession();
		
		return SUCCESS;
	}
}
