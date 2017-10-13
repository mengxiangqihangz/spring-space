package com.zlyg.purchase.controller.sys;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zlyg.purchase.model.sys.SysUser;
import com.zlyg.purchase.service.sys.IUserService;

/**
 * @author justin
 * 
 * 登陆控制器类
 * @version 1.0
 * 
 */
@Controller
@RequestMapping("sys/")
public class LoginController {
	
	@Autowired
	private IUserService userService;
	
	@RequestMapping("login")
	public String login (Model model,SysUser user) {
		
	/*	
		for (SysUser userData : userService.getUser()) {
			//判定用户名
			if(!user.getUserName().equals(userData.getAccount())&&user.getPwd().equals(userData.getPwd())){
				return "redirect:/sys/jsp/login";
				//还要增加报错信息
			}
//			if(!user.getPwd().equals(userData.getPwd())){
//				return "redirect:/sys/jsp/login";
//				//还要增加报错信息
//			}
			
			
		}*/
		/*if (user.getUserName().equals("admin") && user.getPwd().equals("123")) {
			System.out.println("登陆了");
			return "redirect:/sys/user/list";
		}
		return "redirect:/sys/jsp/login";*/
		System.out.println("1111111111");
		int i=userService.judgeLogin(user);
		if(i==1){
			System.out.println("登陆了");
		return "redirect:/sys/user/list";
		}
			
		return "redirect:/sys/jsp/login";
	}
	
	/**
	 * 页面跳转
	 * @param jspName
	 * @return
	 */
	@RequestMapping("/jsp/{jspName}")
	public String toJsp(@PathVariable String jspName){
		System.out.println("JSP TO -->>" +jspName);
		return jspName;
	}
}
