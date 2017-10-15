package com.tgb.web.controller.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import com.tgb.web.controller.entity.Product;
import com.tgb.web.controller.util.Page;


public class ProductDAO implements IProductDAO  {

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addProduct(Product product) {
		sessionFactory.getCurrentSession().save(product);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getAllProduct() {
		String hql = "from Product";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		return query.list();
	}

	@Override
	public boolean delProduct(String id) {
		String hql = "delete Product p where p.id=?";
		System.out.println(id);
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, id);
		return (query.executeUpdate() > 0);
	}

	@Override
	public Product getProduct(String id) {
		String hql = "from Product p where p.id=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, id);
		
		return (Product) query.uniqueResult();
	}

	@Override
	public boolean updateProduct(Product product) {
		String hql = "update Product p set p.proID=?,p.proName=? where p.id=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, product.getProID());
		query.setString(1, product.getProName());
		query.setString(2, product.getId());
		return (query.executeUpdate() > 0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getAllProductByPage(String username, Page page) {
		String hql = "from Product p order by p.id desc";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setFirstResult(3);
		query.setMaxResults(5);
		return query.list();
	
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getProduct3() {
		String hql = "from Product p where p.proO<4 order by p.proO asc";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
		
	}


}
