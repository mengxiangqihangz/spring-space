package com.zlyg.purchase.model.sys;

/**
 * @author justin
 * 
 * 用户角色关系model类
 *
 */
public class SysUserRole {
	private Long userId;
	private Long roleId;

	public SysUserRole() {

	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
}
