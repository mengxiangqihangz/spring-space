package com.zlyg.purchase.service.sys;

import java.util.List;

import com.zlyg.purchase.common.PageNavigation;
import com.zlyg.purchase.model.sys.SysPri;
import com.zlyg.purchase.model.sys.SysPriId;
import com.zlyg.purchase.model.sys.SysRole;

public interface IRoleService {
	public PageNavigation<SysRole> list(PageNavigation<SysRole> page);
	
	public PageNavigation<SysRole> findList(PageNavigation<SysRole> page,SysRole user);
	
	public boolean adduser(SysRole user,SysPriId pri);
	
	public boolean deluser(String userId);
	
	public SysRole getuser(String id);
	
	public boolean edituser(SysRole user,SysPriId pri);
	
	public List<SysPri> getPri();
	
	
}
