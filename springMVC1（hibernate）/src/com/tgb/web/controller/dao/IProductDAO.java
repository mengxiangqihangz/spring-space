package com.tgb.web.controller.dao;

import java.util.List;
import com.tgb.web.controller.entity.Product;
import com.tgb.web.controller.util.Page;

public interface IProductDAO {

	public List<Product> getAllProduct();

	public boolean delProduct(String id);

	public void addProduct(Product product);

	public Product getProduct(String id);
	
	public List<Product> getProduct3();
	
	public List<Product> getAllProductByPage(String username, Page page);

	public boolean updateProduct(Product product);

}
