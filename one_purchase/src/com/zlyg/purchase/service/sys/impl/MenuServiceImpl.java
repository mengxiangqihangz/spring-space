package com.zlyg.purchase.service.sys.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zlyg.purchase.common.PageNavigation;
import com.zlyg.purchase.dao.sys.IMenuDao;
import com.zlyg.purchase.model.sys.SysMenu;
import com.zlyg.purchase.service.sys.IMenuService;
@Service
public class MenuServiceImpl implements IMenuService {
	@Autowired
	private IMenuDao dao; 
	@Override
	public PageNavigation<SysMenu> list(PageNavigation<SysMenu> page) {
		return dao.list(page);
	}
	@Override
	public List<SysMenu> getMenu(String id) {
		return dao.getMenu(id);
	}

}
