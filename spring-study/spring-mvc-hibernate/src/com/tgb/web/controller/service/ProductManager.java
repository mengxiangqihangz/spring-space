package com.tgb.web.controller.service;

import java.util.List;

import com.tgb.web.controller.dao.IProductDAO;
import com.tgb.web.controller.entity.Product;
import com.tgb.web.controller.util.Page;

public class ProductManager implements IProductManager {
	
	private IProductDAO productDao;
	
	
	public void setProductDao(IProductDAO productDao) {
		this.productDao = productDao;
	}


	@Override
	public List<Product> getAllProduct() {
		return productDao.getAllProduct();
	}


	@Override
	public boolean delProduct(String id) {
		return productDao.delProduct(id);
	}


	@Override
	public Product getProduct(String id) {
		return productDao.getProduct(id);
	}


	@Override
	public boolean updateProduct(Product product) {
		return productDao.updateProduct(product);
	}

	@Override
	public void addProduct(Product product) {
		productDao.addProduct(product);
	}


	@Override
	public List<Product> getAllProductByPage(String username, Page page) {
		// TODO Auto-generated method stub
		return productDao.getAllProductByPage(username, page);
	}


	@Override
	public List<Product> getProduct3() {
		// TODO Auto-generated method stub
		return productDao.getProduct3();
	}


}
