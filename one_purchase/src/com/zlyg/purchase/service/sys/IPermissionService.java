package com.zlyg.purchase.service.sys;

import java.util.List;

import org.antlr.runtime.tree.BaseTree;

import com.zlyg.purchase.common.PageNavigation;
import com.zlyg.purchase.model.SysTree;
import com.zlyg.purchase.model.sys.SysMenu;

public interface IPermissionService {
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
	 * 查询出一级菜单
	 * @return
	 * @throws Exception
	 */
	public List<SysMenu> getLevelOneMenu () throws Exception;
	
	/**
	 * 查询权限数菜单
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<SysTree> getAll () throws Exception;
	
	/**
	 * 查询权限数菜单
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<SysTree> getAll(int id) throws Exception;
	
	/**
	 * 查询默认被选中的权限菜单树
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<SysTree> getAllSelected (Long menuId) throws Exception;

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
	
	/**
	 * 删除权限菜单
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int delete (Long id) throws Exception;
	
	/**
	 * 根据菜单编码查询出菜单信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public SysMenu getMenuById (Long id) throws Exception;
}
