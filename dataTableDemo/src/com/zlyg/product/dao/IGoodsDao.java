package com.zlyg.product.dao;

import java.util.List;

import org.springframework.context.ApplicationContext;

import com.zlyg.product.model.Goods;



public interface IGoodsDao {
	public List<Goods> daoShowGoods(int iDisplayStart, int iDisplayLength);
	public int queryDataCount();

}
