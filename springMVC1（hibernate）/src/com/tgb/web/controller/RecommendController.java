package com.tgb.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tgb.web.controller.entity.Recommend;
import com.tgb.web.controller.service.IRecommendManager;




@Controller
@RequestMapping("/recommend")
public class RecommendController {
 
	@Resource(name="recommendManager")
	private IRecommendManager recommendManager;
	
	@RequestMapping("/toAddRecommend")
	public String toAddRecommend(){
		return "/addRecommend";
	}
	
	@RequestMapping("/addRecommend")
	public String addRecommend(Recommend recommend){
		recommendManager.addRecommend(recommend);
		
		return "redirect:/product/getAllProduct";
	}
	
	@RequestMapping("/getAllRecommend")
	public String getAllRecommend(HttpServletRequest request){
		List<Recommend> recommend = recommendManager.getAllRecommend();
		
		request.setAttribute("recommend", recommend);
		
		return "/recommendManager";
	}
	

	@RequestMapping("/delRecommend")
	public void delRecommend(String id,HttpServletResponse response){
		String result = "{\"result\":\"error\"}";
		if(recommendManager.delRecommend(id)){
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
	
	@RequestMapping("/getRecommend")
	public String getFilm(String id,HttpServletRequest request){
		Recommend recommend = recommendManager.getRecommend(id);
		
		request.setAttribute("recommend", recommend);
		return "/editRecommend";
	}
	
	@RequestMapping("/updateRecommend")
	public String updateRecommend(Recommend recommend, HttpServletRequest request){
		if(recommendManager.updateRecommend(recommend)){
			recommend = recommendManager.getRecommend(recommend.getId());
			request.setAttribute("recommend", recommend);
			return "/editRecommend";
		}else{
			return "/error";
		}
		
	}
}
