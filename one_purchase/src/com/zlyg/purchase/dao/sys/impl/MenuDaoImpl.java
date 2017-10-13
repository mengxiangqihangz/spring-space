package com.zlyg.purchase.dao.sys.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.zlyg.purchase.common.PageNavigation;
import com.zlyg.purchase.dao.sys.IMenuDao;
import com.zlyg.purchase.model.sys.SysMenu;
@Repository
public class MenuDaoImpl implements IMenuDao {
	
	@Autowired
	public SimpleJdbcTemplate jdbcTemplate;
	
	private int getTotalRecord() {
		return jdbcTemplate.queryForInt("select count(*) from sys_menu");
	}

	@Override
	public PageNavigation<SysMenu> list(PageNavigation<SysMenu> page) {
		page.setTotalCount(getTotalRecord());
		
		String sql = "select * from sys_menu limit ?,?";
		
		List<SysMenu> list = jdbcTemplate.query(sql, new RowMapper<SysMenu>() {
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
		}, page.getMinResult(),page.getMaxResult());
		
		page.setData(list);
		
		return page;
	}

	@Override
	public List<SysMenu> getMenu(String id) {
		String sql = "select * from sys_menu where id in (select id from sys_menu_role where role_id='?')";
		List<SysMenu> menuTree = jdbcTemplate.query(sql, new RowMapper<SysMenu>() {
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
		}, id);
		
		return menuTree;
	}

}
