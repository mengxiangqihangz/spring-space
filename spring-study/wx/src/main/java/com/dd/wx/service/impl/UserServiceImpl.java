package com.dd.wx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dd.wx.dao.UserDao;
import com.dd.wx.model.User;
import com.dd.wx.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserDao userDao;
	
	public List<User> getList() {
		return userDao.getList();
	}

	public User getUser(String id) {
		return userDao.getUser(id);
	}

	@Transactional
	public void insertUser(List<User> list) {
		for (User user : list) {
			System.out.println(user.getName());
			System.out.println(user.getId());
			userDao.insertUser(user);
		}
	}

}
