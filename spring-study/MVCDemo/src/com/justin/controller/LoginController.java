package com.justin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.justin.model.SysUser;

@Controller
@RequestMapping("sys/")
public class LoginController {
	
	@RequestMapping("login")
	public String login (SysUser user) {
		System.out.println("Login!!!");
		if (user.getUserName().equals("admin")  && user.getUserPwd().equals("123")) {
			return "index";
		}
		return "login";
	}
}
