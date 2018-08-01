package com.zzl.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@RequestMapping("hello")
	public String getString(){
		return "Hello World";
	}
	
	/**
	 * 返回POJO
	 * @return
	 */
	@RequestMapping("user")
	public User getUser(){
		User user = new User();
		return user;
	}
	
	
	@RequestMapping("map")
	public Map getMap(){
		
//		Map map = new HashMap();
//		map.put("name", "zhangsan");
//		map.put("age", 12);
//		return map;
		
		/**
		 * 返回基本类型json格式数据
		 */
		Map map = new HashMap();
		User u1 = new User();
		u1.setName("zhangsan");
		u1.setAge(16);
		User u2 = new User();
		u2.setName("lisi");
		u2.setAge(28);
		map.put("u1", u1);
		map.put("u2", u2);
		return map;
	}
	
	
}
