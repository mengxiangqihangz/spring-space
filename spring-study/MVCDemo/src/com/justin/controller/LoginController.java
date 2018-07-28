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
		if ("admin".equals(user.getUserName())  && "123".equals(user.getUserPwd())) {
			return "index";
		}
		return "login";
	}
}
