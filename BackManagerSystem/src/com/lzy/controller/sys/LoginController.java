package com.lzy.controller.sys;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lzy.model.LoginRecords;
import com.lzy.model.SysUser;
import com.lzy.service.sys.IUserService;



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
	
	SimpleDateFormat formart = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	@Autowired
	private IUserService userService;
	
	@RequestMapping("login")
	public String login (Model model,HttpSession session,SysUser user) {
		System.out.println("sys/login");
		return "login";
	}
	
	@RequestMapping("sumbit")
	public String submit (Model model,HttpSession session,SysUser user) {
		System.out.println("sys/sumbit");
		return "register";
	}
	
	
	@RequestMapping("register")
	public String register (Model model,HttpServletRequest request) throws Exception {
		System.out.println("sys/register");
		String name = request.getParameter("userName");
		String first = request.getParameter("userPwd");
		String second = request.getParameter("reuserPwd");
		System.out.println(name + first + second);
		if(name==null||name==""||first==null||first==""){
				request.setAttribute("msg", "用户名或密码为空！");
				return "register";
		}else if(!first.equals(second)){
				request.setAttribute("msg", "两次输入的密码不一致！");
				return "register";
		}else{
				SysUser user = new SysUser();
				user.setUserName(name);
				user.setUserPwd(first);
				if(userService.isregister(user)){
					return "login";
				}else{
					request.setAttribute("msg", name+"已被注册，请选择登录或重新输入！");
					return "register";
				}
		}
	}
	
	@RequestMapping("index")
	public String index(Model model, HttpServletRequest request, HttpSession session, SysUser user) throws Exception {
			int userId = userService.isLogin(user);
			System.out.println("sys/index");
			System.out.println(userId);
			if(userId!=0){
				user.setUserId(userId);
				request.setAttribute("sysUser", user);
				LoginRecords login = new LoginRecords();
				login.setLoadTime(formart.format(new Date()));
				login.setUserId(userId);
				login.setIP(request.getLocalAddr());
				login.setUserName(user.getUserName());
				userService.records(login);
				return "index";
			}else{
				request.setAttribute("msg", "输入的登录名或密码错误，请重新输入！");
				return "login";
				
		}
	}
	
	
	@RequestMapping("home")
	public String home (Model model, HttpServletRequest request, SysUser user) {
		System.out.println("sys/home");
		String userId = request.getParameter("userId");
		LoginRecords lrs = userService.home(userId);
		model.addAttribute("loginRecords", lrs);
		return "home";
	}
	
	
}
