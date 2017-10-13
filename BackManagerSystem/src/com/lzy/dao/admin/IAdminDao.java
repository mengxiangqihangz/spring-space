package com.lzy.dao.admin;

import com.lzy.model.SysUser;

public interface IAdminDao {

		public boolean changepwd(SysUser user);

		public boolean save(SysUser user);
}
