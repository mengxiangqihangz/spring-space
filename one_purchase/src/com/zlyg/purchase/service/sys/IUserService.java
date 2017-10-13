package com.zlyg.purchase.service.sys;

import java.util.List;

import com.zlyg.purchase.common.PageNavigation;
import com.zlyg.purchase.model.sys.SysRole;
import com.zlyg.purchase.model.sys.SysUser;


public interface IUserService {
	public PageNavigation<SysUser> getPageData(PageNavigation<SysUser> page);
	public int addUser(SysUser user);
	public int delateUser(SysUser user);
	public int editUser(SysUser user);
	public int recover(SysUser user);
	public SysUser findUserById(int id);
	public List<SysRole> getRole();
	public PageNavigation<SysUser> getSearchData(PageNavigation<SysUser> page,String key);
	public PageNavigation<SysUser> getDelData(PageNavigation<SysUser> page);
	public int judgeLogin(SysUser user);
}
