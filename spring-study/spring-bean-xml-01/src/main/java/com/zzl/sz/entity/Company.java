package com.zzl.sz.entity;

import java.util.List;

public class Company {
	
	private String name;
	
	private String addr;
	
	private List<String> employee;
	
	public Company(String name,String addr,List<String> employee){
		this.name = name;
		this.addr = addr;
		this.employee = employee;
	}
	
	@Override
	public String toString(){
		StringBuffer stb = new StringBuffer();
		stb.append("name = " + name + ", addr = " + addr + ", employee = {");
		for (String str : employee) {
			stb.append(str + ",");
		}
		stb.append("}");
		return stb.toString();
	}
	
}
