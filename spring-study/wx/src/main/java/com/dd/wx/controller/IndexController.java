package com.dd.wx.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dd.wx.model.User;
import com.dd.wx.service.IUserService;

@Controller
public class IndexController {
	
	private static Logger logger = Logger.getLogger(IndexController.class);
	
	@RequestMapping("/")
	@ResponseBody
	public String index() {
		logger.info("进入index方法");
		return "Hello Spring Boot !";
	}
	
	@Value("${weixin.config.AppId}")
	public String appId;
	
	

	
	@Autowired
	private IUserService userService;
	
	@RequestMapping("/getItem")
	public String getItem(HttpServletRequest request) {
		
		String id = request.getParameter("id");
		logger.info("进入getItem方法,id:"+id);
		
		User user = userService.getUser(id);
		request.setAttribute("user", user);
		
		return "/item";
	}
	
	@RequestMapping("/getList")
	public String getList(HttpServletRequest request) {
		
		logger.info("进入getList方法");
		
		List<User> list = userService.getList();
		request.setAttribute("list", list);
		
		return "/item";
	}
	
	
	/**请求地址
	 * http://localhost:8080/insertUser?ids=aa
	 * @param request
	 * @return
	 */
	@RequestMapping("/insertUser")
	public String insertUser(HttpServletRequest request) {
		
		String ids = request.getParameter("ids");
		logger.info("进入insertUser方法,ids:"+ids);
		String[] list = ids.split(",");
		
		List<User> userList = new ArrayList<User>();
		for (int i = 0; i < list.length; i++) {
			User user = new User();
			
			user.setId(list[i]);
			user.setAge(i+"");
			user.setName("姓名"+list[i]);
			user.setSex("11");
			user.setMobile("11111");
			
			userList.add(user);
		}
		userService.insertUser(userList);
		return "/item";
	}
}
