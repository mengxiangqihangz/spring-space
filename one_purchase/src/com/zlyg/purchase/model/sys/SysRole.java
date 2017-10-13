package com.zlyg.purchase.model.sys;

import java.util.List;

import com.zlyg.purchase.model.SysTree;

/**
 * 
 * @author Administrator
 *
 */
public class SysRole {

	private Long id;
	private String roleId;
	private String roleName;
	private String remark;
	private List<SysPri> dataPri;
	private SysPriId priId;
	private List<SysTree> treeList;
	
	
	public SysRole(){
		
	}
	
	

	public List<SysTree> getTreeList() {
		return treeList;
	}



	public void setTreeList(List<SysTree> treeList) {
		this.treeList = treeList;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public List<SysPri> getDataPri() {
		return dataPri;
	}

	public void setDataPri(List<SysPri> dataPri) {
		this.dataPri = dataPri;
	}

	public SysPriId getPriId() {
		return priId;
	}

	public void setPriId(SysPriId priId) {
		this.priId = priId;
	}

	



//	public List<T> getData() {
//		return data;
//	}
//
//	public void setData(List<T> data) {
//		this.data = data;
//	}	
	
	
	
}
