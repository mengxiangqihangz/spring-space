package com.yltx.frame.model.sys;

import java.util.List;

/**
 * 菜单操作类
 * @author asus
 *
 */
public class SysMenu {
	private String menuId;
	private String menuName;
	private String parentMenuId;
	private String menuPath;
	private List<SysMenu> menuList;
	
	public SysMenu () {
		
	}

	public String getMenuId() {
		return menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getParentMenuId() {
		return parentMenuId;
	}

	public void setParentMenuId(String parentMenuId) {
		this.parentMenuId = parentMenuId;
	}

	public String getMenuPath() {
		return menuPath;
	}

	public void setMenuPath(String menuPath) {
		this.menuPath = menuPath;
	}

	public List<SysMenu> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<SysMenu> menuList) {
		this.menuList = menuList;
	}
	
}
