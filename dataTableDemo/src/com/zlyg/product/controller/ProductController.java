package com.zlyg.product.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zlyg.product.model.Goods;
import com.zlyg.product.service.IGoodsService;

@Controller
@RequestMapping("product/")
public class ProductController {
	@Autowired
	@Qualifier("goodsServiceImpl")
	IGoodsService gs;
	
	static List<Goods> listGoods;
	
	@RequestMapping("show")
	public String show (HttpSession session) {
//		ApplicationContext context=new ClassPathXmlApplicationContext("classpath*:/spring-application.xml");
//		listGoods=gs.serviceShowGoods(context);
//		session.setAttribute("pag", listGoods);
//		model.addAttribute("pag",listGoods);
		return "index";
	}
	
	@RequestMapping("ajaxhandler")
	@ResponseBody   										//对返回的对象通过HttpMessageContext转换为指定的格式
	public String detail(HttpServletRequest request) {
		
//		System.out.println("product/ajaxhandler");
		String draw = request.getParameter("draw");
        int iDisplayStart =Integer.parseInt(request.getParameter("iDisplayStart"));
        int iDisplayLength = Integer.parseInt(request.getParameter("iDisplayLength"));
        listGoods=gs.serviceShowGoods(iDisplayStart, iDisplayLength);
        int count =gs.queryDataCount();
        Map map = new HashMap();
        map.put("aaData",listGoods);
        map.put("iTotalRecords",count);  				//设置总记录条数
        map.put("iTotalDisplayRecords", count);			//设置显示的条数
//        map.put("sEcho",sEcho);
        map.put("draw",draw);						//设置关闭页面。
//        request.setAttribute("aaData", list);
        return JSONObject.fromObject(map).toString();
	}
}
