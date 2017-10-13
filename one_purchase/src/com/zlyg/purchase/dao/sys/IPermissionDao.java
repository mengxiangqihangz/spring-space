//package com.zlyg.purchase.dao.sys;
//
//import com.zlyg.purchase.model.sys.Privilege;
//
//
//public interface IPrivilegeDao {
//	
//	public String getRoleId(Privilege pri);
//
//}
package com.zlyg.purchase.dao.sys;

import java.util.List;

import com.zlyg.purchase.common.PageNavigation;
import com.zlyg.purchase.model.sys.SysMenu;

public interface IPermissionDao {
	/**
	 * 获取权限分页列表
	 * 
	 * @param page
	 * @return
	 */
	public PageNavigation<SysMenu> list(PageNavigation<SysMenu> page);
	
	/**
	 * 返回总记录数
	 * @return
	 */
	public int getRecordCount ();

	/**
	 * 添加权限信息
	 * @param t
	 * @return
	 * @throws Exception
	 */
	public int add(SysMenu menu) throws Exception;
	
	/**
	 * 变更权限信息
	 * @param t
	 * @return
	 * @throws Exception
	 */
	public int update (SysMenu menu) throws Exception;
	
	public int delete (Long id) throws Exception;
	
	public List<SysMenu> getLevelOneMenu() throws Exception;
	
	public List<SysMenu> getAll() throws Exception;
	
	public List<SysMenu> getMenuListByRoleId (Long []ids) throws Exception;
	
	/**
	 * 根据菜单编码查询出菜单信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public SysMenu getMenuById (Long id) throws Exception;
}
