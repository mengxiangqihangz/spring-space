package com.tgb.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tgb.web.controller.entity.Product;
import com.tgb.web.controller.service.IProductManager;
import com.tgb.web.controller.util.Page;



@Controller
@RequestMapping("/product")
public class ProductController {
 
	@Resource(name="productManager")
	private IProductManager productManager;
	
	@RequestMapping("/toAddProduct")
	public String toAddProduct(){
		return "/addProduct";
	}
	
	@RequestMapping("/addProduct")
	public String addProduct(Product product){
		System.err.println(product.getProName());
		productManager.addProduct(product);
		
		return "redirect:/product/getAllProduct";
	}
	
	@RequestMapping("/getAllProduct")
	public String getAllProduct(HttpServletRequest request){
		List<Product> product = productManager.getAllProduct();
		
		request.setAttribute("product", product);
		
		return "/productManager";
	}
	
	@RequestMapping("/getAllProductByPage")
	public String getAllProductByPage(HttpServletRequest request){
		Page p = new Page();
		List<Product> product = productManager.getAllProductByPage("", p);
		
		request.setAttribute("product", product);
		
		return "/productManager";
	}
	@RequestMapping("/delProduct")
	public void delUser(String id,HttpServletResponse response){
		String result = "{\"result\":\"error\"}";
		if(productManager.delProduct(id)){
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
	
	@RequestMapping("/getProduct")
	public String getUser(String id,HttpServletRequest request){
		Product product = productManager.getProduct(id);
		
		request.setAttribute("product", product);
		return "/editProduct";
	}
	
	@RequestMapping("/updateProduct")
	public String updateProduct(Product product,HttpServletRequest request){
		System.out.println(product.getProName()+"   "+product.getProO());
		if(productManager.updateProduct(product)){
			product = productManager.getProduct(product.getId());
			request.setAttribute("product", product);
			return "/editProduct";
		}else{
			return "/error";
		}
		
	}
}
