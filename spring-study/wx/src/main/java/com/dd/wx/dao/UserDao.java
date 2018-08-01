package com.dd.wx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dd.wx.model.User;

public interface UserDao {

	public List<User> getList();
	
	public User getUser(@Param("id") String id);
	
	public void insertUser(User user);
}
