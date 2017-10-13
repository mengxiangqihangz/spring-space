package com.zlyg.purchase.controller.sys;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zlyg.purchase.common.PageNavigation;
import com.zlyg.purchase.model.sys.SysMenu;
import com.zlyg.purchase.service.sys.IMenuService;

/**
 * 菜单控制类
 * @author Administrator
 *
 */
@Controller
@RequestMapping("sys/menu/")
public class MenuController {
	
	@Autowired
	private IMenuService menuService;
	/**
	 * 菜单信息
	 * @param model
	 * @param menu
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	@RequestMapping("menuList")
	public String list (Model model,SysMenu menu,String pageNo,String pageSize){
		PageNavigation<SysMenu> pa = new PageNavigation<>(pageNo,pageSize);
		pa = menuService.list(pa);
		model.addAttribute("page",pa);
		model.addAttribute("menu", "menu");
		return "sys/menuList";
	}

}
