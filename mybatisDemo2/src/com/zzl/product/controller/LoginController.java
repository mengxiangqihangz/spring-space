package com.zzl.product.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zzl.product.model.Menu;
import com.zzl.product.service.MenuService;



@Controller
@RequestMapping(value = "background")
public class LoginController {

	@Resource(name = "menuService")
	private MenuService menuService;

	/**
	 * @author geloin
	 * @date 2012-5-5 ÉÏÎç9:33:22
	 * @return
	 */
	@RequestMapping(value = "to_login")
	public ModelAndView toLogin(HttpServletResponse response) throws Exception {

		Map<String, Object> map = new HashMap<String, Object>();

		List<Menu> result = this.menuService.find();

		map.put("result", result);

		return new ModelAndView("background/menu", map);
	}
}
