package com.zlyg.product.service;

import java.util.List;

import org.springframework.context.ApplicationContext;

import com.zlyg.product.model.Goods;



public interface IGoodsService {
	public List<Goods> serviceShowGoods(int iDisplayStart, int iDisplayLength);
	public int queryDataCount();
}
