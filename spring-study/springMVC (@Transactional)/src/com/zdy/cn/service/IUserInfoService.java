package com.zdy.cn.service;

import java.util.List;

import com.zdy.cn.model.UserInfo;

public interface IUserInfoService {

	public boolean login(UserInfo user) throws Exception;
	
	public boolean regist(UserInfo user) throws Exception;
	
	public List<UserInfo> findAll() throws Exception;
	
	public UserInfo edit(String id) throws Exception;
	
	public boolean update(UserInfo user) throws Exception;
}
