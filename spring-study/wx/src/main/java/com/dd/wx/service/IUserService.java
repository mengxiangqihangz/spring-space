package com.dd.wx.service;

import java.util.List;

import com.dd.wx.model.User;

public interface IUserService {

	public List<User> getList();
	
	public User getUser(String id);
	
	
	public void insertUser(List<User> list);
}
