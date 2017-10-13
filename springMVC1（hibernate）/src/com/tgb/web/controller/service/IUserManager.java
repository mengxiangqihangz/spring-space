package com.tgb.web.controller.service;

import java.util.List;

import com.tgb.web.controller.entity.User;

public interface IUserManager {

	void addUser(User user);
	
	public List<User> getAllUser();
	
	public boolean delUser(String id);
	
	public User getUser(String id);
	
	public boolean updateUser(User user);

	public User getUserByName(String name);
}
