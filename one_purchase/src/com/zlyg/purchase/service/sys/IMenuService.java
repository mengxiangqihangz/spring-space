package com.zlyg.purchase.service.sys;

import java.util.List;

import com.zlyg.purchase.common.PageNavigation;
import com.zlyg.purchase.model.sys.SysMenu;

public interface IMenuService {
	public PageNavigation<SysMenu> list(PageNavigation<SysMenu> page);
	
	public List<SysMenu> getMenu(String id);
}
