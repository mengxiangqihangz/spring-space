package com.zlyg.purchase.service.sys.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.zlyg.purchase.common.PageNavigation;
import com.zlyg.purchase.dao.sys.IMenuDao;
import com.zlyg.purchase.dao.sys.IPermissionDao;
import com.zlyg.purchase.dao.sys.IPermissionRoleDao;
import com.zlyg.purchase.model.State;
import com.zlyg.purchase.model.SysTree;
import com.zlyg.purchase.model.sys.SysMenu;
import com.zlyg.purchase.model.sys.SysMenuRole;
import com.zlyg.purchase.service.sys.IPermissionService;

@Service
public class PermissionServiceImpl implements IPermissionService {


	
	@Autowired
	private IMenuDao menuDao;
	
	@Autowired
	@Qualifier("permissionRoleDaoImpl")
	private IPermissionRoleDao permissionRoleDaoImpl;
	
	@Autowired
	private IPermissionDao permissionDaoImpl;
	
	

	@Override
	public PageNavigation<SysMenu> list(PageNavigation<SysMenu> page) {
		return null;
	}

	@Override
	public int getRecordCount() {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public List<SysMenu> getLevelOneMenu() throws Exception {
		// TODO Auto-generated method stub
		return null;
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

	/**
	 * 查询权限数菜单
	 * 
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<SysTree> getAll() throws Exception {
		
		List<SysTree> treeList = new ArrayList<>();
		
		List<SysMenu> menuList = permissionDaoImpl.getAll();
		
		// 一级节点
		for (SysMenu sysMenu : menuList) {
			SysTree tree = new SysTree();
			if (sysMenu.getParentMenuId() == -1) {
				tree.setId(sysMenu.getId());
				tree.setText(sysMenu.getMenuName());
				tree.setHref(sysMenu.getMenuPath());
				
				tree.setState(new State());
				tree.setNodes(null);
				treeList.add(tree);
			}
		}
		
		// 二级节点
		List<SysTree> nodeTreeList = null;
		for (SysTree tree : treeList) {
			nodeTreeList = new ArrayList<>();
			for (SysMenu sysMenu : menuList) {
				if(tree.getId() != sysMenu.getParentMenuId()) {
					continue;
				}
				SysTree node = new SysTree();
				node.setId(sysMenu.getId());
				node.setText(sysMenu.getMenuName());
				node.setHref(sysMenu.getMenuPath());
				node.setState(new State());
				node.setNodes(null);
				nodeTreeList.add(node);
			}
			tree.setNodes(nodeTreeList);
		}
		
		// 三级节点（看是否需要开启，菜单树结构最高允许三层）
//		List<SysTree> threeTreeList = null;
//		if (nodeTreeList != null) {
//			for (SysTree tree : nodeTreeList) {// 便利二级节点，看是否挂了三级节点
//				threeTreeList = new ArrayList<>();
//				for (SysMenu sysMenu : menuList) {
//					// 二级节点的id是否和parent_id相等，如果相等，则为该二级节点的子节点
//					if(tree.getId() != sysMenu.getParentMenuId()) {
//						continue;
//					}
//					SysTree node = new SysTree();
//					node.setId(sysMenu.getId());
//					node.setText(sysMenu.getMenuName());
//					node.setHref(sysMenu.getMenuPath());
//					State state = new State();
//					state.setDisabled(isDisabled);
//					node.setState(state);// 最后一个节点为操作节点，默认为不启用
//					node.setNodes(null);
//					threeTreeList.add(node);
//				}
//				tree.setNodes(threeTreeList);
//			}
//		}
		
		// 设置一个超级根节点
		List<SysTree> rootList = new ArrayList<>();
		SysTree root = new SysTree();
		root.setId(-1L);
		root.setText("根节点");
		root.setHref("");
		root.setState(new State());
		root.setNodes(treeList);
		rootList.add(root);
		return rootList;
	}
	
	/**
	 * 查询包含的权限数菜单
	 * 
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<SysTree> getAll (int id) throws Exception {
		
		List<SysTree> treeList = new ArrayList<>();
		
		List<SysMenu> menuList = permissionDaoImpl.getAll();
		
		// 所有的权限菜单
		List<SysMenuRole> menuRoleList = permissionRoleDaoImpl.getMenuRoleList(id);
		int ids [] = new int [menuRoleList.size()];
		for (int i=0;i<menuRoleList.size();i++) {
			ids[i] = menuRoleList.get(i).getMenuId();
		}
		
		// 一级节点
		for (SysMenu sysMenu : menuList) {
			SysTree tree = new SysTree();
			if (sysMenu.getParentMenuId() == -1) {
				tree.setId(sysMenu.getId());
				tree.setText(sysMenu.getMenuName());
				tree.setHref(sysMenu.getMenuPath());
				
				// 是否选中
				State state = new State();
				for (int i = 0; i < ids.length; i++) {
					if (sysMenu.getId() == ids[i]){
						state.setChecked(true);
						break;
					}
				}
				tree.setState(state);
				tree.setNodes(null);
				treeList.add(tree);
			}
		}
		
		// 二级节点
		List<SysTree> nodeTreeList = null;
		for (SysTree tree : treeList) {
			nodeTreeList = new ArrayList<>();
			for (SysMenu sysMenu : menuList) {
				if(tree.getId() != sysMenu.getParentMenuId()) {
					continue;
				}
				SysTree node = new SysTree();
				node.setId(sysMenu.getId());
				node.setText(sysMenu.getMenuName());
				node.setHref(sysMenu.getMenuPath());
				
				State state = new State();
				for (int i = 0; i < ids.length; i++) {
					if (sysMenu.getId() == ids[i]){
						state.setChecked(true);
						break;
					}
				}
				node.setState(state);
				
				node.setNodes(null);
				nodeTreeList.add(node);
			}
			tree.setNodes(nodeTreeList);
		}
		
		return treeList;
	}
	
	/**
	 * 查询默认被选中的权限菜单树
	 * 
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<SysTree> getAllSelected (Long menuId) throws Exception {
		List<SysTree> treeList = new ArrayList<>();
		
		List<SysMenu> menuList = permissionDaoImpl.getAll();
		
		// 一级节点
		for (SysMenu sysMenu : menuList) {
			SysTree tree = new SysTree();
			if (sysMenu.getParentMenuId() == -1) {
				tree.setId(sysMenu.getId());
				tree.setText(sysMenu.getMenuName());
				
				tree.setHref(sysMenu.getMenuPath());
				// 判断是否默认被选中
				State state = new State ();
				if (menuId == tree.getId()) {
					state.setChecked(true);
				}
				tree.setState(state);
				tree.setNodes(null);
				treeList.add(tree);
			}
		}
		
		// 二级节点
		List<SysTree> nodeTreeList = null;
		for (SysTree tree : treeList) {
			nodeTreeList = new ArrayList<>();
			for (SysMenu sysMenu : menuList) {
				if(tree.getId() != sysMenu.getParentMenuId()) {
					continue;
				}
				SysTree node = new SysTree();
				node.setId(sysMenu.getId());
				node.setText(sysMenu.getMenuName());
				node.setHref(sysMenu.getMenuPath());
				// 判断是否默认被选中,二级节点作为父节点只能是操作权限，操作权限单独处理
				State state = new State ();
//				if (menuId == tree.getId()) {
//					state.setChecked(true);
//				}
				node.setState(state);
				node.setNodes(null);
				nodeTreeList.add(node);
			}
			tree.setNodes(nodeTreeList);
		}
		// 设置一个超级根节点
		List<SysTree> rootList = new ArrayList<>();
		SysTree root = new SysTree();
		root.setId(-1L);
		root.setText("根节点");
		root.setHref("");
		State state = new State ();
		if (menuId == -1) {
			state.setChecked(true);
		}
		root.setState(state);
		root.setNodes(treeList);
		rootList.add(root);
		return rootList;
	}
	
	/**
	 * 根据菜单编码查询出菜单信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@Override
	public SysMenu getMenuById (Long id) throws Exception {
		return null;
//		return permissionDao.getMenuById (id);
	}



	



	

}
