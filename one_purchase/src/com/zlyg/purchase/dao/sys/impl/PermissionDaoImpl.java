package com.zlyg.purchase.dao.sys.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.zlyg.purchase.common.PageNavigation;
import com.zlyg.purchase.dao.sys.IPermissionDao;
import com.zlyg.purchase.model.sys.SysMenu;

/**
 * @author justin
 * 权限管理服务类（菜单类）
 *
 */
@Repository
public class PermissionDaoImpl  implements IPermissionDao {
	
	
	@Autowired
	public SimpleJdbcTemplate jdbcTemplate;

	@Override
	public PageNavigation<SysMenu> list(PageNavigation<SysMenu> page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getRecordCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int add(SysMenu menu) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(SysMenu menu) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Long id) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<SysMenu> getLevelOneMenu() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SysMenu> getAll() throws Exception {
		String sql = "select * from sys_menu";
		List<SysMenu> menuList =jdbcTemplate.query(sql, new RowMapper<SysMenu>() {
			public SysMenu mapRow(ResultSet rs, int i) throws SQLException {
				SysMenu menu = new SysMenu();
				menu.setId(rs.getInt("id"));
				menu.setMenuName(rs.getString("menu_name"));
				menu.setMenuPath(rs.getString("menu_path"));
				menu.setParentMenuId(rs.getInt("parent_menu_id"));
				menu.setMenuDesc(rs.getString("menu_desc"));
				menu.setMenuLevel(rs.getInt("menu_level"));
				menu.setCreator(rs.getInt("creator"));
				menu.setCreateDate(rs.getString("create_date"));
				menu.setModifier(rs.getInt("Modifier"));
				menu.setModifyDate(rs.getString("Modify_date"));
				return menu;
			}
		});
		
		return menuList;
		
	}

	@Override
	public List<SysMenu> getMenuListByRoleId(Long[] ids) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SysMenu getMenuById(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/*@Override
	public PageNavigation<SysMenu> list(PageNavigation<SysMenu> page) {
		String sql = "select * from sys_menu limit ?,?";
		List<SysMenu> menuList = this.queryList(sql, page.getMinResult(),page.getMaxResult());
		page.setData(menuList);
		return page;
	}

	@Override
	public int getRecordCount() {
		return this.queryAll().size();
	}

	@Override
	public int add(SysMenu menu) throws Exception {
		this.save(menu);
		return 1;
	}
	
	public int delete (Long id) throws Exception {
		return super.delete(id);
	}

	@Override
	public List<SysMenu> getLevelOneMenu() throws Exception {
		String sql = "select * from sys_menu where parent_menu_id = -1";
		return this.queryList(sql);
	}

	@Override
	public List<SysMenu> getAll() throws Exception {
		return this.queryAll();
	}
	
	public List<SysMenu> getMenuListByRoleId (Long []ids) throws Exception {
		StringBuffer sf = new StringBuffer ("select * from sys_menu where id in (");
		for (int i=0;i<ids.length;i++) {
			if (i==ids.length-1) {
				sf.append(ids[i]).append(")");
			}else{
				sf.append(ids[i]).append(",");
			}
		}
		return super.queryList(sf.toString());
	}
	
	*//**
	 * 根据菜单编码查询出菜单信息
	 * @param id
	 * @return
	 * @throws Exception
	 *//*
	public SysMenu getMenuById (Long id) throws Exception {
		return super.get(id);
	}*/

}
