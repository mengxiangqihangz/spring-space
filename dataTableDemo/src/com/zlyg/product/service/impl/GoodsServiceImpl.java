package com.zlyg.product.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.zlyg.product.dao.IGoodsDao;
import com.zlyg.product.model.Goods;
import com.zlyg.product.service.IGoodsService;

@Service
public class GoodsServiceImpl implements IGoodsService{
	
	@Autowired
	@Qualifier("goodsDaoImpl")
	private IGoodsDao goodsDaoImpl;
	
	@Override
	public List<Goods> serviceShowGoods(int iDisplayStart, int iDisplayLength) {
		 
		return goodsDaoImpl.daoShowGoods(iDisplayStart, iDisplayLength);
		
	}
	public int queryDataCount(){
		return goodsDaoImpl.queryDataCount();
	}
}
