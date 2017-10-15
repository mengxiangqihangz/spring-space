package com.tgb.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tgb.web.controller.entity.Film;
import com.tgb.web.controller.service.IFilmManager;


@Controller
@RequestMapping("/film")
public class FilmController {
 
	@Resource(name="filmManager")
	private IFilmManager filmManager;
	
	@RequestMapping("/toAddFilm")
	public String toAddProduct(){
		return "/addFilm";
	}
	
	@RequestMapping("/addFilm")
	public String addProduct(Film film){
		filmManager.addFilm(film);
		
		return "redirect:/product/getAllProduct";
	}
	
	@RequestMapping("/getAllFilm")
	public String getAllFilm(HttpServletRequest request){
		List<Film> film = filmManager.getAllFilm();
		
		request.setAttribute("film", film);
		
		return "/filmManager";
	}
	

	@RequestMapping("/delFilm")
	public void delFilm(String id,HttpServletResponse response){
		String result = "{\"result\":\"error\"}";
		if(filmManager.delFilm(id)){
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
	
	@RequestMapping("/getFilm")
	public String getFilm(String id,HttpServletRequest request){
		Film film = filmManager.getFilm(id);
		
		request.setAttribute("film", film);
		return "/editFilm";
	}
	
	@RequestMapping("/updateFilm")
	public String updateProduct(Film film, HttpServletRequest request){
		if(filmManager.updateFilm(film)){
			film = filmManager.getFilm(film.getId());
			request.setAttribute("film", film);
			return "/editProduct";
		}else{
			return "/error";
		}
		
	}
}
