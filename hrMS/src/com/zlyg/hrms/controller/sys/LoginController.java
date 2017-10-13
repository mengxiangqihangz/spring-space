package com.zlyg.hrms.controller.sys;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zlyg.hrms.model.sys.SysUser;


/**
 * @author ly
 * 
 * @version 1.0
 * 
 */
@Controller
@RequestMapping("sys/")
public class LoginController {
	

	/**
	 * 登录控制类
	 * @return
	 */
	@RequestMapping("login")
	public String login (Model model,SysUser user) {
		if (user.getAccount().equals("admin") && user.getPwd().equals("123")) {
			return "redirect:staff/list";
		}
		return "redirect:/login.jsp";
	}
	
}
