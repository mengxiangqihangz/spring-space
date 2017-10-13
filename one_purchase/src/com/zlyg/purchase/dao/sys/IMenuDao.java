package com.zlyg.purchase.dao.sys;

import java.util.List;

import com.zlyg.purchase.common.PageNavigation;
import com.zlyg.purchase.model.sys.SysMenu;

public interface IMenuDao {
	/**
	 * 根据页面传过来的页码信息获取列表
	 * @param page
	 * @return
	 */
	public PageNavigation<SysMenu> list(PageNavigation<SysMenu> page);
	
	/**
	 * 根据角色Id获取对应的菜单
	 * @param id
	 * @return
	 */
	public List<SysMenu> getMenu(String id);
}
