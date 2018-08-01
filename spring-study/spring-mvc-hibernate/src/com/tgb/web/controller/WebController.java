package com.tgb.web.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tgb.web.controller.entity.Film;
import com.tgb.web.controller.entity.Recommend;
import com.tgb.web.controller.service.IFilmManager;
import com.tgb.web.controller.service.IRecommendManager;

@Controller
public class WebController {

	@Resource(name = "filmManager")
	private IFilmManager filmManager;

	@Resource(name = "recommendManager")
	private IRecommendManager recommendManager;

	@RequestMapping("/toAddProduct")
	public String toAddProduct() {
		return "/addProduct";
	}

	@RequestMapping("/index")
	public String getAllProduc3(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("usersession") == null) {
			List<Film> filmlist = filmManager.getFilm3();
			request.setAttribute("filmlist", filmlist);
		} else {

			String name = session.getAttribute("usersession").toString();
			List<Recommend> recommendlist = recommendManager
					.getAllRecommendByName(name);
			StringBuffer sb = new StringBuffer();
			for (Recommend r : recommendlist) {
				sb.append(r.getFilmID());
				sb.append(",");
			}
			System.out.println(sb.toString());
			List<Film> filmlist = filmManager.getFilm3();

			request.setAttribute("filmlist", filmlist);
			
		}
		
		List<Film> toplist = filmManager.getFilmByScore5();
		request.setAttribute("toplist", toplist);
		return "/index";

	}

}
