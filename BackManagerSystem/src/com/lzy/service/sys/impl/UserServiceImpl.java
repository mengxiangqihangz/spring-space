package com.lzy.service.sys.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lzy.dao.sys.IUserDao;
import com.lzy.model.LoginRecords;
import com.lzy.model.SysUser;
import com.lzy.service.sys.IUserService;


@Service("userService")
public class UserServiceImpl implements IUserService {
	
	@Autowired
	private IUserDao userDao;
	
	
	/**
	 * 验证用户是否成功登陆
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public int isLogin (SysUser user) throws Exception {
		return userDao.isLogin (user);
	}
	
	/**
	 * 用户注册
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public boolean isregister(SysUser user) throws Exception {
		return userDao.isregister (user);
	}
	
	/**
	 * 用户个人信息
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public SysUser userinfor(String userId) throws Exception {
		return userDao.userinfor (userId);
	}
	
	/**
	 * 用户登陆信息记录
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public void records(LoginRecords login) throws Exception {
		userDao.records(login);
	}

	/**
	 * 用户登陆信息查询
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public List<LoginRecords> loadInforList(int iDisplayStart, int iDisplayLength, String userId) throws Exception {
		
		return userDao.loadInforList(iDisplayStart, iDisplayLength, userId);
	}

	/**
	 * 用户登陆信息查询条数
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public int queryDataCount(String userId) {
		
		return userDao.queryDataCount(userId);
	}

	/**
	 * 首页显示用户登录信息
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public LoginRecords home(String userId) {
		return userDao.home(userId);
		
	}

	
}
