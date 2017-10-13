package com.lzy.service.admin;

import com.lzy.model.SysUser;

public interface IAdminService {
		
	public boolean changepwd(SysUser user);

	public boolean save(SysUser user);
}
