package com.zlyg.purchase.dao.sys;

import java.util.List;

import com.zlyg.purchase.common.PageNavigation;
import com.zlyg.purchase.model.sys.SysRole;
import com.zlyg.purchase.model.sys.SysUser;


public interface IUserDao {
	/**
	 * 根据服务器传过来的页码得到对应的用户LIST
	 * @param page
	 * @return
	 */
	public PageNavigation<SysUser> getPageData(PageNavigation<SysUser>page);
	/**
	 * 增加用户
	 * @param user
	 * @return
	 */
	public int addUser(SysUser user);
	/**
	 * 删除用户
	 * @param user
	 * @return
	 */
	public int deleteUser(SysUser user);
	/**
	 * 编辑用户
	 * @param user
	 * @return
	 */
	public int editUser(SysUser user);
	/**
	 * 回复删除的用户
	 * @param user
	 * @return
	 */
	public int recover(SysUser user);
	/**
	 * 根据Id模糊查询用户信息
	 * @param id
	 * @return
	 */
	public SysUser findUserById(int id);
	/**
	 * 得到角色信息，用于赋予用户角色信息
	 * @return
	 */
	public List<SysRole> getRole();
	/**
	 * 
	 * @param page
	 * @param key
	 * @return
	 */
	public PageNavigation<SysUser> getSerchData(PageNavigation<SysUser> page,String key);
	/**
	 * 
	 * @param page
	 * @return
	 */
	public PageNavigation<SysUser> getDelData(PageNavigation<SysUser> page);
	/**
	 * 根据服务器传过来的用户信息，用于数据库SQL语句登录判定
	 * @return
	 */
	public int judgeLogin(SysUser user) ;
}
