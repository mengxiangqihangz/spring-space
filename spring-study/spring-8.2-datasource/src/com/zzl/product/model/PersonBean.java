package com.zzl.product.model;

import org.springframework.stereotype.Component;


public class PersonBean {
	
	private int id;
	private String name;
	private int pwd;
	
	
	public int getPwd() {
		return pwd;
	}
	public void setPwd(int pwd) {
		this.pwd = pwd;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	
	}

}
