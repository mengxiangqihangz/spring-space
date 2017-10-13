package com.zlyg.purchase.model.sys;

import java.io.Serializable;

import com.zlyg.purchase.model.Entity;

/**
 * @author 
 * 
 *         菜单-角色关系model
 * 
 */
@SuppressWarnings("serial")
public class SysMenuRole extends Entity implements Serializable {
	private int menuId;
	private int roleId;

	public SysMenuRole() {

	}


	public int getMenuId() {
		return menuId;
	}


	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}


	public int getRoleId() {
		return roleId;
	}


	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}


	@Override
	public String getKeyName() {
		// TODO Auto-generated method stub
		return "roleId";
	}

}
