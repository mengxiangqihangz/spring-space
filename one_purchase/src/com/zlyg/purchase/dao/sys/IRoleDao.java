package com.zlyg.purchase.dao.sys;

import java.util.List;

import com.zlyg.purchase.common.PageNavigation;
import com.zlyg.purchase.model.sys.SysPri;
import com.zlyg.purchase.model.sys.SysPriId;
import com.zlyg.purchase.model.sys.SysRole;
import com.zlyg.purchase.model.sys.SysUser;

public interface IRoleDao {
	
	/**
	 * 
	 * @param page
	 * @return
	 */
	public PageNavigation<SysRole> list(PageNavigation<SysRole> page);
	
	
	public boolean addRole(SysRole role,SysPriId pri);
	
	
	public boolean delRole(String roleId);
	
	
	public boolean editRole(SysRole role,SysPriId pri); 
	
	public SysRole getRole(String id);

	public List<SysPri> getPri();
}
