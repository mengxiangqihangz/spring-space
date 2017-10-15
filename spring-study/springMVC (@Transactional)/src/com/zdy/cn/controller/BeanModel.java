package com.zdy.cn.controller;

import java.util.HashMap;
import java.util.Map;

public class BeanModel {

	private String path;
	
	private String className;
	
	private String method;
	
	private Map<String, String> forward = new HashMap<String, String>();
	
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public Map<String, String> getForward() {
		return forward;
	}
	public void setForward(Map<String, String> forward) {
		this.forward = forward;
	} 
}
