package com.tgb.web.controller.service;

import java.util.List;

import com.tgb.web.controller.entity.Recommend;


public interface IRecommendManager {

	public void addRecommend(Recommend recommend);
	
	public List<Recommend> getAllRecommend();
	
	public List<Recommend> getAllRecommendByName(String name);
	
	public boolean delRecommend(String id);
	
	public Recommend getRecommend(String id);
	
	public Recommend getRecommendByName(String name);
	
	public boolean updateRecommend(Recommend recommend);

}
