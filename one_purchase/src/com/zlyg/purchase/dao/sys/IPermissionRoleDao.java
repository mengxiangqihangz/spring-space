package com.zlyg.purchase.dao.sys;

import java.util.List;

import com.zlyg.purchase.model.sys.SysMenuRole;

/**
 * @author 
 * 权限角色关系dao
 *
 */
public interface IPermissionRoleDao {
	
	/**
	 * 删除指定角色对应的权限信息
	 * @param roleId
	 */
	public void deletePermissionRole (Long roleId);
	
	/**
	 * 批量添加角色权限信息
	 * @param userRoleList
	 */
	public void addPermissionRole (SysMenuRole []menuRoleArr);
	
	/**
	 * 查询所有的权限菜单列表
	 * @param roleId
	 * @return
	 */
	public List<SysMenuRole> getMenuRoleList (int id);
}
