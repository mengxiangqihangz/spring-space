package com.zlyg.purchase.model.sys;
/**
 * 菜单类
 * @author Administrator
 *
 */
public class SysMenu {
	
		private	    int     id;
		private		String	menuName;
		private		String	menuPath;
		private		int 	parentMenuId;
		private		String	menuDesc;
		private		int	    menuLevel;
		private		int	    creator;
		private		String	createDate;
		private		int	    Modifier;
		private	    String  ModifyDate;
		
		public SysMenu(){
			
		}

		public long getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getMenuName() {
			return menuName;
		}

		public void setMenuName(String menuName) {
			this.menuName = menuName;
		}

		public String getMenuPath() {
			return menuPath;
		}

		public void setMenuPath(String menuPath) {
			this.menuPath = menuPath;
		}

		public int getParentMenuId() {
			return parentMenuId;
		}

		public void setParentMenuId(int parentMenuId) {
			this.parentMenuId = parentMenuId;
		}

		public String getMenuDesc() {
			return menuDesc;
		}

		public void setMenuDesc(String menuDesc) {
			this.menuDesc = menuDesc;
		}

		public int getMenuLevel() {
			return menuLevel;
		}

		public void setMenuLevel(int menuLevel) {
			this.menuLevel = menuLevel;
		}

		public int getCreator() {
			return creator;
		}

		public void setCreator(int creator) {
			this.creator = creator;
		}

		public String getCreateDate() {
			return createDate;
		}

		public void setCreateDate(String createDate) {
			this.createDate = createDate;
		}

		public int getModifier() {
			return Modifier;
		}

		public void setModifier(int modifier) {
			Modifier = modifier;
		}

		public String getModifyDate() {
			return ModifyDate;
		}

		public void setModifyDate(String modifyDate) {
			ModifyDate = modifyDate;
		}

		
		
		
}
