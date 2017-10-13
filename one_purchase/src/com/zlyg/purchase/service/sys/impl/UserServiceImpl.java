package com.zlyg.purchase.service.sys.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zlyg.purchase.common.PageNavigation;
import com.zlyg.purchase.dao.sys.IUserDao;
import com.zlyg.purchase.model.sys.SysRole;
import com.zlyg.purchase.model.sys.SysUser;
import com.zlyg.purchase.service.sys.IUserService;

@Service
public class UserServiceImpl implements IUserService{
	@Autowired
	private IUserDao userDao;
	@Override
	public int addUser(SysUser user) {
		// TODO Auto-generated method stub
		return userDao.addUser(user);
	}

	@Override
	public int delateUser(SysUser user) {
		// TODO Auto-generated method stub
		return userDao.deleteUser(user);
	}

	@Override
	public int editUser(SysUser user) {
		// TODO Auto-generated method stub
		return userDao.editUser(user);
	}

	@Override
	public SysUser findUserById(int id) {
		// TODO Auto-generated method stub
		return userDao.findUserById(id);
	}

	@Override
	public PageNavigation<SysUser> getPageData(PageNavigation<SysUser> page) {
		// TODO Auto-generated method stub
		return userDao.getPageData(page);
	}

	@Override
	public List<SysRole> getRole() {
		// TODO Auto-generated method stub
		return userDao.getRole();
	}

	@Override
	public PageNavigation<SysUser> getSearchData(PageNavigation<SysUser> page,
			String key) {
		// TODO Auto-generated method stub
		return userDao.getSerchData(page, key);
	}

	@Override
	public PageNavigation<SysUser> getDelData(PageNavigation<SysUser> page) {
		// TODO Auto-generated method stub
		return userDao.getDelData(page);
	}

	@Override
	public int recover(SysUser user) {
		// TODO Auto-generated method stub
		return userDao.recover(user);
	}

	@Override
	public int judgeLogin(SysUser user) {
		return userDao.judgeLogin(user);
	}
	

}
