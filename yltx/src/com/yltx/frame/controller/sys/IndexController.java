package com.yltx.frame.controller.sys;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.yltx.frame.model.sys.SysMenu;

@Controller
@RequestMapping("sys/")
public class IndexController {
	
	@RequestMapping("index")
	public ModelAndView toIndex (ModelAndView mv) {
		
		List<SysMenu> menuList = new ArrayList<>();
		for (int i = 0; i < menuList.size(); i++) {
			SysMenu menu = new SysMenu();
			menu.setMenuId(i+"001");
			menu.setMenuName("menu" + i);
			menu.setParentMenuId("0");
			menuList.add(menu);
		}
		
		mv.setViewName("main/index");
		mv.addObject("menuList", menuList);
		return mv;
	}
	
	@RequestMapping("menu")
	@ResponseBody
	public List<SysMenu> getMenuData () {
		List<SysMenu> menuList = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			SysMenu menu = new SysMenu();
			menu.setMenuId(i+"00" + (i+1));
			menu.setMenuName("menu" + i);
			menu.setParentMenuId("0");
			menuList.add(menu);
		}
		
		for (int i = 0; i < 5; i++) {
			SysMenu menu = new SysMenu();
			menu.setMenuId((i+5)+"00" + (i+1));
			menu.setMenuName("menu" + i);
			menu.setParentMenuId(i+"00" + (i+1));
			menuList.add(menu);
		}
		return menuList;
	}
	
	@RequestMapping("default")
	public ModelAndView toDefault (ModelAndView mv) {
		mv.setViewName("main/default");
		return mv;
	}
	
	@RequestMapping("user/list")
	public String list (Model model) {
		return "sys/user/list";
	}
}
