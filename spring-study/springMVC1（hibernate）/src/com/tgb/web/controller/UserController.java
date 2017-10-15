package com.tgb.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tgb.web.controller.entity.User;
import com.tgb.web.controller.service.IUserManager;

@Controller
@RequestMapping("/user")
public class UserController {

	@Resource(name = "userManager")
	private IUserManager userManager;

	@RequestMapping("/toAddUser")
	public String toAddUser() {
		return "/addUser";
	}

	@RequestMapping("/addUser")
	public String addUser(User user) {
		System.err.println(user.getUserName());
		userManager.addUser(user);

		return "redirect:/user/getAllUser";
	}

	
	
	@RequestMapping("/addRegUser")
	public String addRegUser(User user, HttpServletRequest request) {
		System.err.println(user.getUserName());
		userManager.addUser(user);
		HttpSession session = request.getSession();
		session.setAttribute("usersession", user.getUserName());
		return "redirect:/index";
	}
	@RequestMapping("/getAllUser")
	public String getAllUser(HttpServletRequest request) {
		List<User> user = userManager.getAllUser();

		request.setAttribute("user", user);

		return "/userManager";
	}

	@RequestMapping("/delUser")
	public void delUser(String id, HttpServletResponse response) {
		String result = "{\"result\":\"error\"}";
		if (userManager.delUser(id)) {
			result = "{\"result\":\"success\"}";
		}
		PrintWriter out = null;
		response.setContentType("application/json");

		try {
			out = response.getWriter();
			out.write(result);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@RequestMapping("/getUser")
	public String getUser(String id, HttpServletRequest request) {
		User user = userManager.getUser(id);

		request.setAttribute("user", user);
		return "/editUser";
	}

	@RequestMapping("/checkUser")
	public String getUserByName(String userName, String password,
			HttpServletRequest request) {
		User user = userManager.getUserByName(userName);
		HttpSession session = request.getSession();
	
		if (user.getPassword().equals(password)) {
			request.setAttribute("user", user);
			session.setAttribute("usersession", user.getUserName());
			return "redirect:/index";
		} else {
			return "/login";
		}

	}

	@RequestMapping("/updateUser")
	public String updateUser(User user, HttpServletRequest request) {

		if (userManager.updateUser(user)) {
			user = userManager.getUser(user.getId());
			request.setAttribute("user", user);
			return "/editUser";
		} else {
			return "/error";
		}

	}
	
	
	@RequestMapping("/logout")
	public String alterUserSatus(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.removeAttribute("usersession");
		return "redirect:/index";


	}
}
