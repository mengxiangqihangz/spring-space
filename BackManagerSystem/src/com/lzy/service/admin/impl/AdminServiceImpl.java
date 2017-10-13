package com.lzy.service.admin.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lzy.dao.admin.IAdminDao;
import com.lzy.model.SysUser;
import com.lzy.service.admin.IAdminService;



@Service("adminService")
public class AdminServiceImpl implements IAdminService{
	
	@Autowired
	private IAdminDao adminDao;
	
	
	public boolean changepwd(SysUser user) {
		return adminDao.changepwd(user);
	}


	@Override
	public boolean save(SysUser user) {
		return adminDao.save(user);
	}




}
