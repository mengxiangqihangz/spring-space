package net.lampbrother.app;

import java.util.Map;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.ParameterAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class TestAware extends ActionSupport 
	implements RequestAware, SessionAware, ApplicationAware, ParameterAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String execute() throws Exception {
		
//		applicationMap.put("applicationKey", "^^applicationValue");
//		
//		sessionMap.put("sessionKey", "^^sessionValue");
//		
//		requestMap.put("requestKey", "^^requestValue");
//		
//		String[] name = parameterMap.get("name");
//		System.out.println("name: " + name[0]); 
		
		return "success";
	}

	
	
	private Map<String, Object> requestMap = null;
	
	@Override
	public void setRequest(Map<String, Object> arg0) {
		requestMap = arg0;
	}
	
	private Map<String, Object> sessionMap = null;

	@Override
	public void setSession(Map<String, Object> arg0) {
		sessionMap = arg0;
	}

	private Map<String, Object> applicationMap = null;
	
	@Override
	public void setApplication(Map<String, Object> arg0) {
		applicationMap = arg0;
	}
	
	private Map<String, String[]> parameterMap;

	@Override
	public void setParameters(Map<String, String[]> arg0) {
		parameterMap = arg0;
	}
	
}
