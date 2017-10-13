package com.zlyg.purchase.controller.sys;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zlyg.purchase.common.PageNavigation;
import com.zlyg.purchase.dao.sys.IPermissionDao;
import com.zlyg.purchase.dao.sys.IPermissionRoleDao;
import com.zlyg.purchase.model.SysTree;
import com.zlyg.purchase.model.sys.SysPri;
import com.zlyg.purchase.model.sys.SysPriId;
import com.zlyg.purchase.model.sys.SysRole;
import com.zlyg.purchase.model.sys.SysUser;
import com.zlyg.purchase.service.sys.IMenuService;
import com.zlyg.purchase.service.sys.IPermissionService;
import com.zlyg.purchase.service.sys.IRoleService;
import com.zlyg.purchase.utils.JsonUtils;


@Controller
@RequestMapping("sys/roler/")
public class RoleController {

	
	@Autowired
	private IRoleService roleService ;
	
	@Autowired
	private IMenuService menuService;
	
	@Autowired
	private IPermissionDao permissionDao;
	
	@Autowired
	private IPermissionService permissionService;
	
	
	
	
	/**
	 * 角色列表
	 * @param model
	 * @param user
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("rolist")
	public String list (Model model,SysUser user,String pageNo,String pageSize) throws Exception {
		
		//点击权限表时根据页面传过来的页码返回数据库里的内容
	     PageNavigation<SysRole> pa = new PageNavigation<>(pageNo,pageSize);
		pa = roleService.list(pa);
		model.addAttribute("page", pa);
		
		//传递权限表立内容用于角色的添加与编辑
		List<SysPri> pri = new ArrayList<>();
		pri =roleService.getPri();
		model.addAttribute("pri",pri);
		
		//绑定一个键值对，用于leftmenu里的光标选择
		model.addAttribute("menu", "role");
		
		//忘记干啥的了--！好像是用于隐藏什么的··
		model.addAttribute("hh", "0");
		
	
		model.addAttribute("jsonTree", permissionDao.getAll());
		
		return "sys/rolist";
	}
	/**
	 * 增加角色
	 * @param role
	 * @return
	 */
	@RequestMapping("add")
	@ResponseBody
	public String add (SysRole role,SysPriId priId) {
		boolean tag= false;
		System.out.println("-----添加用户信息------");
		System.out.println(role);
		
//		List<SysPri> dataPri = new ArrayList<SysPri>();
//		SysPri pri1 = new SysPri();
//		pri1.setPriId("1001");
//		SysPri pri2 = new SysPri();
//		pri2.setPriId("1002");
//		SysPri pri3 = new SysPri();
//		pri3.setPriId("1003");
//		dataPri.add(pri1);
//		dataPri.add(pri2);
//		dataPri.add(pri3);
//		role.setDataPri(dataPri);
		tag = roleService.adduser(role,priId);
		if(tag){
			return "1";
		}else{
			return null;			
		}
	}
	
	
	@RequestMapping("delete")
	@ResponseBody
	public String delete (String id) {
		
		boolean tag= false;
		System.out.println("-----删除用户信息------");
		System.out.println(id);
		tag = roleService.deluser(id);
		if(tag){
			return "1";
		}else{
			return null;			
		}
	}
	
	// 根据ID查询
		@RequestMapping("/get/{id}")
		@ResponseBody
		public String getUserById( Model  model,@PathVariable Integer id) throws IOException{
			System.out.println("查询结果：" + id);
			
			SysRole u = new SysRole ();
			u=roleService.getuser(id.toString());
			
			try {
				List<SysTree> treeList = permissionService.getAll(id);
				u.setTreeList(treeList);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return JsonUtils.objToJsonStr(u);
			
		}
		
		@RequestMapping("edit")
		@ResponseBody
		public String edit (SysRole role,SysPriId priId) {
			boolean tag= false;
			System.out.println("-----编辑用户信息------");
			System.out.println(role);
			tag = roleService.edituser(role,priId);
			if(tag){
				return "1";
			}else{
				return null;			
			}
		}
	
}
