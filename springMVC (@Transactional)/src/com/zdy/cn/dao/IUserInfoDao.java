package com.zdy.cn.dao;

import java.util.List;

import com.zdy.cn.model.UserInfo;

public interface IUserInfoDao {

	public boolean login(String sql) throws Exception;
	
	public boolean regist(String sql) throws Exception;
	
	public List<UserInfo> findAll(String sql) throws Exception;
	
	public UserInfo edit(String sql) throws Exception;
	
	public boolean update(String sql) throws Exception;
}
