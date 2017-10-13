package com.lzy.dao.admin.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lzy.dao.admin.IAdminDao;
import com.lzy.model.SysUser;

@Repository("adminDao")
public class AdminDaoImpl implements IAdminDao{

	@Autowired
	private JdbcTemplate jdbcTemplate_sys;
	
	/**
	 * 用户修改密码
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public boolean changepwd(SysUser user) {
		String sql = "update sysuser set userPwd = '"+user.getUserPwd()+"' where userid = "+user.getUserId();
		int update = jdbcTemplate_sys.update(sql);
		if(update == 0){
			return false;
		}
		return true;
	}

	/**
	 * 用户修改信息
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@Override
	public boolean save(SysUser user) {
		String sql = "update sysuser set userName =?, sex=?, age=?, mobile=?, email=?, qq=?, addr=? where userid = ? ";
		int count = jdbcTemplate_sys.update(sql, new Object[]{user.getUserName(),user.getSex(),user.getAge(),user.getMobile(),user.getEmail(),user.getQq(),user.getAddr(),user.getUserId()});
		if(count == 0){
			return false;
		}
		return true;
	}


}
