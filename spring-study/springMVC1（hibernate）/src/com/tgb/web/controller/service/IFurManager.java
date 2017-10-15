package com.tgb.web.controller.service;

import java.util.List;

import com.tgb.web.controller.entity.Fur;


public interface IFurManager {
	public void addFur(Fur fur);
	
	public List<Fur> getAllFur();
	
	public boolean delFur(String id);
	
	public Fur getFur(String id);
	
	public Fur getFurByName(String name);
	
	public boolean updateFur(Fur fur);
}
