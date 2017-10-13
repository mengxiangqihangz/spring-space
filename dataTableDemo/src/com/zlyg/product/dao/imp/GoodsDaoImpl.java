package com.zlyg.product.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.stereotype.Repository;

import com.zlyg.product.dao.IGoodsDao;
import com.zlyg.product.model.Goods;



@Repository
public class GoodsDaoImpl implements IGoodsDao {
	List<Goods> listGoods=new ArrayList<>();
	Connection conn;
	PreparedStatement pps;
	ResultSet res;
	@Autowired
	JdbcTemplate jdbcTemplate;
	@Override
	public List<Goods> daoShowGoods(int iDisplayStart, int iDisplayLength) {
		String sql="SELECT goods.goods_id,goods.goods_name,goods.goods_price,goods.goods_information,"
				+ "goods_remainNum,goods_picture,category.category_name,sysuser.mobile FROM "
				+ "goods,category,sysuser WHERE goods.category_id=category.category_id AND goods.merchant_id=sysuser.userid "
				+ "limit " +iDisplayStart+","+iDisplayLength;
																								
			    
		return (List<Goods>) jdbcTemplate.query(sql, 
			new ParameterizedRowMapper<Goods>() {
				public Goods mapRow(ResultSet rs,int rowNum) throws SQLException{
					Goods goods=new Goods();
					goods.setGid(rs.getInt(1));
					goods.setGname(rs.getString(2));
					goods.setGprice(rs.getInt(3));
					goods.setGinformation(rs.getString(4));
					goods.setGremainNum(rs.getInt(5));
					goods.setGpicture(rs.getString(6));
					goods.setCategory(rs.getString(7));
					goods.setSysmobile(rs.getString(8));
//					System.out.println(rs.getInt(1));
					return goods;
				}
			}
		);	
	}
	@Override
	public int queryDataCount(){
		String sql="select count(*) from goods";
		return jdbcTemplate.queryForInt(sql);
	};
	

	
}
