package com.justin.dao;

import com.justin.model.UserBean;

public interface UserDao {
	public void insertUser(UserBean user);
	
	public UserBean selectUser(int id);

}
