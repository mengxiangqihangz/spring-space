package com.tgb.web.controller.service;

import java.util.List;

import com.tgb.web.controller.dao.IRecommendDAO;
import com.tgb.web.controller.entity.Recommend;

public class RecommendManager implements IRecommendManager {
	
	private IRecommendDAO recommendDao;

	public void setRecommendDao(IRecommendDAO recommendDao) {
		this.recommendDao = recommendDao;
	}
	


	@Override
	public List<Recommend> getAllRecommend() {
		return recommendDao.getAllRecommend();
	}


	@Override
	public boolean delRecommend(String id) {
		return recommendDao.delRecommend(id);
	}


	@Override
	public Recommend getRecommend(String id) {
		return recommendDao.getRecommend(id);
	}


	@Override
	public boolean updateRecommend(Recommend recommend) {
		return recommendDao.updateRecommend(recommend);
	}

	@Override
	public void addRecommend(Recommend recommend) {
		recommendDao.addRecommend(recommend);
	}




	@Override
	public Recommend getRecommendByName(String name) {
		return recommendDao.getRecommendByName(name);
	}



	@Override
	public List<Recommend> getAllRecommendByName(String name) {
		// TODO Auto-generated method stub
		return recommendDao.getAllRecommendByName(name);
	}



}
