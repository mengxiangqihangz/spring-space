package com.tgb.web.controller.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import com.tgb.web.controller.entity.Fur;


public class FurDAO implements IFurDAO  {

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addFur(Fur fur) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean delFur(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Fur> getAllFur() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Fur getFur(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Fur getFurByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateFur(Fur fur) {
		// TODO Auto-generated method stub
		return false;
	}

	


	
	

}
