package com.zzl.product.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.zzl.product.mapper.MenuMapper;
import com.zzl.product.model.Menu;
import com.zzl.product.service.MenuService;

@Repository(value = "menuService")
@Transactional
public class MenuServiceImpl implements MenuService{
	
	@Resource(name = "menuMapper")
	private MenuMapper menuMapper;

	/*
	 * (non-Javadoc)
	 * @see com.geloin.spring.service.MenuService#find()
	 */
	@Override
	public List<Menu> find() {
		String sql = "select * from tb_system_menu";
		return this.menuMapper.operateReturnBeans(sql);
	}
}
