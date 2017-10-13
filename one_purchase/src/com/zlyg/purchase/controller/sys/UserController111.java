/*package com.zlyg.purchase.controller.sys;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zlyg.purchase.common.PageNavigation;
import com.zlyg.purchase.model.sys.SysRole;
import com.zlyg.purchase.model.sys.SysUser;
import com.zlyg.purchase.service.sys.IRoleService;
import com.zlyg.purchase.service.sys.IUserService;
import com.zlyg.purchase.utils.JsonUtils;

*//**
 * @author justin
 * 
 * 用户信息控制器类
 * @version 1.0
 * 
 *//*
@Controller
@RequestMapping("sys/user/")
public class UserController111 {
	@Autowired
	private IUserService userService;
	
	
	@RequestMapping("list")
	public String list (Model model,SysUser user,String pageNo,String pageSize) {
		
	     PageNavigation<SysUser> pa = new PageNavigation<>(pageNo,pageSize);
	     
	     model.addAttribute("role",userService.getRole());
	     
		pa = userService.list(pa);
		//绑定信息··键值关系
		model.addAttribute("page", pa);
		model.addAttribute("menu", "user");
		return "sys/list";
	}
	
	@RequestMapping("add")
	@ResponseBody
	public String add (SysUser user) {
		boolean tag= false;
		System.out.println("-----添加用户信息------");
		System.out.println(user);
		tag = userService.adduser(user);
		if(tag){
			return "1";
		}else{
			return null;			
		}
	}
	
	@RequestMapping("edit")
	@ResponseBody
	public String edit (SysUser user) {
		boolean tag= false;
		System.out.println("-----编辑用户信息------");
		System.out.println(user);
		tag = userService.edituser(user);
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
		tag = userService.deluser(id);
		if(tag){
			return "1";
		}else{
			return null;			
		}
	}
	
	@RequestMapping("findList")
	public String findList (Model model,SysUser user,String pageNo,String pageSize) {
		System.out.println(user);
	     PageNavigation<SysUser> pa = new PageNavigation<>(pageNo,pageSize);
		
		pa = userService.findList(pa,user);
		model.addAttribute("page", pa);
		return "sys/list";
	}
	
	// 根据ID查询
	@RequestMapping("/get/{id}")
	@ResponseBody
	public void getUserById(HttpServletResponse rs,Model model,@PathVariable Integer id) throws IOException{
		System.out.println("查询结果：" + id);
		
		SysUser u = new SysUser ();
		u=userService.getuser(id.toString());
//		SysRole role = new SysRole();
//		model.addAttribute("role", role);
		
		String str = JsonUtils.objToJsonStr(u);
		rs.setCharacterEncoding("utf-8");
		PrintWriter pw = rs.getWriter();
		pw.write(str);
		pw.flush();
		pw.close();
				
	}
	
	*//**
	 * 页面跳转
	 * @param jspName
	 * @return
	 *//*
	@RequestMapping("/jsp/{jspName}")
	public String toJsp(@PathVariable String jspName){
		System.out.println("JSP TO -->>" +jspName);
		return jspName;
	}
}
*/