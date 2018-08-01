package com.tgb.web.controller.service;

import java.util.List;

import com.tgb.web.controller.dao.IFurDAO;
import com.tgb.web.controller.entity.Fur;

public class FurManager implements IFurManager {

	private IFurDAO furDao;

	public void setFurDao(IFurDAO furDao) {
		this.furDao = furDao;
	}

	@Override
	public void addFur(Fur fur) {
		furDao.addFur(fur);
	}

	@Override
	public List<Fur> getAllFur() {
		return furDao.getAllFur();
	}

	@Override
	public boolean delFur(String id) {
		return furDao.delFur(id);
	}

	@Override
	public Fur getFur(String id) {
		return furDao.getFur(id);
	}

	@Override
	public boolean updateFur(Fur fur) {
		return furDao.updateFur(fur);
	}

	@Override
	public Fur getFurByName(String name) {
		// TODO Auto-generated method stub
		return furDao.getFurByName(name);
	}

}
