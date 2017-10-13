package com.zlyg.purchase.dao.sys.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.zlyg.purchase.dao.basic.BaseDao;
import com.zlyg.purchase.dao.sys.IPermissionRoleDao;
import com.zlyg.purchase.model.sys.SysMenuRole;

@Service
public class PermissionRoleDaoImpl extends BaseDao implements IPermissionRoleDao {

	@Override
	public void deletePermissionRole(Long roleId) {
		int count = this.deleteByProperty("role_id", roleId+"");
		System.out.println("删除的数据有：" + count);
	}

	@Override
	public void addPermissionRole(SysMenuRole []menuRoleArr) {
		this.saves(menuRoleArr);
	}
	
	@Override
	public List<SysMenuRole> getMenuRoleList (int id) {
	/*	String sql = "select * from sys_menu_role where role_id = ?";
		return this.queryList(sql, roleId);*/
		String sql = "select * from sys_menu_role where role_id = (select role_id from sys_role where id = ?)";
		List<SysMenuRole> menuRoleList = jdbcTemplate.query(sql, new RowMapper<SysMenuRole>() {
			public SysMenuRole mapRow( ResultSet rs, int i) throws SQLException {
				SysMenuRole menuRole = new SysMenuRole();
				menuRole.setMenuId(rs.getInt("menu_id"));
				menuRole.setRoleId(rs.getInt("role_id"));
				return menuRole;
			}
		},id);
		return menuRoleList;
//		return null;
	}

}
