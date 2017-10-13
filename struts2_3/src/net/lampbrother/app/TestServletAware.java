package net.lampbrother.app;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.util.ServletContextAware;

import com.opensymphony.xwork2.ActionSupport;

public class TestServletAware extends ActionSupport
	implements ServletContextAware, ServletRequestAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String execute() throws Exception {
		
		HttpSession session = request.getSession();
		System.out.println(session); 
		
		return SUCCESS;
	}

	private HttpServletRequest request;
	
	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		request = arg0;
	}

	private ServletContext servletContext = null;
	
	@Override
	public void setServletContext(ServletContext arg0) {
		servletContext = arg0;
	}
	
}
