package com.lzy.dao.sys;

import java.util.List;

import com.lzy.model.LoginRecords;
import com.lzy.model.SysUser;



public interface IUserDao {
	/**
	 * 验证用户是否成功登陆
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public int isLogin (SysUser user);
	
	/**
	 * 用户注册
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public boolean isregister(SysUser user) throws Exception;
	
	/**
	 * 用户个人信息
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public SysUser userinfor(String userId) throws Exception;
	
	/**
	 * 用户登陆信息记录
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public void records(LoginRecords login) throws Exception;

	/**
	 * 用户登陆信息查询
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public List<LoginRecords> loadInforList(int iDisplayStart, int iDisplayLength, String userId);

	/**
	 * 用户登陆信息查询条数
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public int queryDataCount(String userId);

	
	/**
	 * 首页显示用户登录信息
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public LoginRecords home(String userId);



	
	
}
