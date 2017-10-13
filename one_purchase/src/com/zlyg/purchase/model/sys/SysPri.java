package com.zlyg.purchase.model.sys;

import java.util.List;

public class SysPri {
	
	private Long id;
	private String priId;
	private String priName;
	private String remark;
	private List<String> priIdLi;
	
	public List<String> getPriIdLi() {
		return priIdLi;
	}

	public void setPriIdLi(List<String> priIdLi) {
		this.priIdLi = priIdLi;
	}

	public SysPri(){
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public String getPriId() {
		return priId;
	}

	public void setPriId(String priId) {
		this.priId = priId;
	}

	public String getPriName() {
		return priName;
	}

	public void setPriName(String priName) {
		this.priName = priName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
//	public SysPri(int roleId){
//		
//		this.roleId=roleId;
//		
//	}
	

	

}



