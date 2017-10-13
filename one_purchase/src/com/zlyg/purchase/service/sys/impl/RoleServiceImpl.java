package com.zlyg.purchase.service.sys.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zlyg.purchase.common.PageNavigation;
import com.zlyg.purchase.dao.sys.IRoleDao;
import com.zlyg.purchase.model.sys.SysPri;
import com.zlyg.purchase.model.sys.SysPriId;
import com.zlyg.purchase.model.sys.SysRole;
import com.zlyg.purchase.service.sys.IRoleService;

@Service
public class RoleServiceImpl implements IRoleService  {
	@Autowired
	private IRoleDao dao;

	@Override
	public PageNavigation<SysRole> list(PageNavigation<SysRole> page) {
		return dao.list(page);
	}

	@Override
	public PageNavigation<SysRole> findList(PageNavigation<SysRole> page,
			SysRole user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean adduser(SysRole role,SysPriId pri) {
		return dao.addRole(role,pri);
	}

	@Override
	public boolean deluser(String roleId) {
		return dao.delRole(roleId);
	}

	@Override
	public SysRole getuser(String id) {
		return dao.getRole(id);
	}

	@Override
	public boolean edituser(SysRole role,SysPriId pri) {
		return dao.editRole(role,pri);
	}

	@Override
	public List<SysPri> getPri() {
		return dao.getPri();
	}


}
