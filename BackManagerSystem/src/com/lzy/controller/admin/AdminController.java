package com.lzy.controller.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.lzy.model.LoginRecords;
import com.lzy.model.SysUser;
import com.lzy.service.admin.IAdminService;
import com.lzy.service.sys.IUserService;

import net.sf.json.JSONObject;


@SessionAttributes("sysUser")
@Controller
@RequestMapping("admin/")
public class AdminController {
	
	@Autowired
	IUserService userService;
	@Autowired
	IAdminService adminService;
	
	
	@RequestMapping("info")
	public String info (Model model,HttpServletRequest request,SysUser user) throws Exception {
		System.out.println("admin/info");
		String userId = request.getParameter("userId");
		SysUser user1 = userService.userinfor(userId);
		System.out.println(user1.getUserName());
		System.out.println(user1.getUserPwd());
		System.out.println(user1.getUserId());
		model.addAttribute("sysUser", user1);
		return "admin/info";
	}
	
	@RequestMapping("ajaxhandler")
	@ResponseBody
	public String ajaxHandler(HttpServletRequest request) throws Exception{
		System.out.println("admin/ajaxhandler");
		String userId = request.getParameter("userId");  
//		String sEcho = request.getParameter("sEcho");
		String draw = request.getParameter("draw");
        int iDisplayStart =Integer.parseInt(request.getParameter("iDisplayStart"));
        int iDisplayLength = Integer.parseInt(request.getParameter("iDisplayLength"));
        System.out.println(iDisplayStart);
        System.out.println(userId);
        System.out.println(iDisplayLength);
        List<LoginRecords> list = userService.loadInforList(iDisplayStart, iDisplayLength, userId);
        int count =userService.queryDataCount(userId);
        Map map = new HashMap();
        map.put("aaData",list);
        map.put("iTotalRecords",count);
        map.put("iTotalDisplayRecords", count);
//        map.put("sEcho",sEcho);
        map.put("draw",draw);
//        request.setAttribute("aaData", list);
        return JSONObject.fromObject(map).toString();
			
	}
	

	@RequestMapping("changepwd")
	@ResponseBody
	public String changepwd (Model model, HttpServletRequest request, SysUser user) throws Exception {
		System.out.println(user.getUserPwd());
		System.out.println(user.getUserId());
		System.out.println("admin/changepwd");
		if(adminService.changepwd(user)){
			return "login";
		}
		return "admin/info";
	}
	
	@RequestMapping("competence")
	public String competence (Model model,HttpSession session,SysUser user) {
		System.out.println("admin/competence");
		return "admin/competence";
	}
	
	@RequestMapping("save")
	@ResponseBody
	public String save (Model model,HttpSession session,SysUser user) throws Exception {
		System.out.println("admin/save");
		System.out.println(user.getUserId());
		System.out.println(user.getUserName());
		System.out.println(user.getSex());
		System.out.println(user.getAge());
		System.out.println(user.getMobile());
		System.out.println(user.getEmail());
		System.out.println(user.getQq());
		System.out.println(user.getAddr());
		if(adminService.save(user)){
			return"1";
		}
		return "0";
	}
	
	@RequestMapping("admin")
	public 	String admin(){
		System.out.println("admin/admin");
		return "admin/admin";
	}
}
