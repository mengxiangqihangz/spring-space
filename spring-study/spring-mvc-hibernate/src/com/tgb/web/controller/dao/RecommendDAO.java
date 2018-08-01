package com.tgb.web.controller.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import com.tgb.web.controller.entity.Recommend;

public class RecommendDAO implements IRecommendDAO  {

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addRecommend(Recommend recommend) {
		sessionFactory.getCurrentSession().save(recommend);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Recommend> getAllRecommend() {
		String hql = "from Recommend";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		return query.list();
	}

	@Override
	public boolean delRecommend(String id) {
		String hql = "delete Recommend r where r.id=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, id);
		
		return (query.executeUpdate() > 0);
	}

	@Override
	public Recommend getRecommend(String id) {
		String hql = "from Recommend r where r.id=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, id);
		
		return (Recommend) query.uniqueResult();
	}

	@Override
	public boolean updateRecommend(Recommend recommend) {
		String hql = "update Recommend r set r.userName=?,r.age=? where u.id=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
/*		query.setString(0, user.getUserName());
		query.setString(1, user.getAge());
		query.setString(2, user.getId());*/
		
		return (query.executeUpdate() > 0);
	}

	@Override
	public Recommend getRecommendByName(String name) {
		String hql = "from Recommend r where r.userName=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, name);
		
		return (Recommend) query.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Recommend> getAllRecommendByName(String name) {
		// TODO Auto-generated method stub
		String hql = "from Recommend r where r.userName=? ";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, name);
		return query.list();

	}




	

}
