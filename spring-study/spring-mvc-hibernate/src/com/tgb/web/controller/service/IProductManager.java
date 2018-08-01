package com.tgb.web.controller.service;

import java.util.List;

import com.tgb.web.controller.entity.Product;
import com.tgb.web.controller.util.Page;


public interface IProductManager {

	public List<Product> getAllProduct();
	
	public boolean delProduct(String id);
	
	public Product getProduct(String id);
	
	public boolean updateProduct(Product product);
	
	public void addProduct(Product product);	
	
	public List<Product> getProduct3();
	
	public List<Product> getAllProductByPage(String username, Page page);
}
