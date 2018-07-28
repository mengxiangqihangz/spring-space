package com.zzl.product.dao.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import com.zzl.product.dao.PersonService;
import com.zzl.product.model.PersonBean;



@Repository
public class PersonServiceImpl implements PersonService {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	

	@Override
	public void save(PersonBean personBean) {
		jdbcTemplate.update("insert into person(name,pwd) values(?,?)", new Object[]{personBean.getName(),personBean.getPwd()}, 
				new int[]{java.sql.Types.VARCHAR,java.sql.Types.INTEGER});
	}
	@Override
	public void update(PersonBean person) {
		jdbcTemplate.update("update person set name=? where id=?", new Object[]{person.getName(),person.getId()}, 
				new int[]{java.sql.Types.VARCHAR,java.sql.Types.INTEGER});
	}
//	queryForInt与queryForLong：这两个方法非常相似，只是他们的返回值上存在差异。
//	Long queryForLong（String sql）
//	Long queryForLong（String sql,Object[] args）
//	Long queryForLong（String sql,Object[] args,int[] argTypes）
//	为什么是int[]
	
	public void personQuery(PersonBean personBean){
		Long count=jdbcTemplate.queryForLong("select count(*) from person where id=?", new Object[]{personBean.getId()}, new int[]{java.sql.Types.VARCHAR});
		System.out.println(count);
		
	}
/*====================query则可以返回集合/对象===========================*/
/*====================queryForObject返回的都是数量/个数===========================*/	
/*====================queryForObject返回的都是对象===========================*/
//	Object queryForObject(String sql,class requiredType)
//	Object queryForObject(String sql,Object[] args,class requiredType
//	Object queryForObject(String sql,Object[] args,int[] argTypes,class requiredType)
//	requiredType 表面了相应函数的返回值类型。对于该参数来说实际上是有限制的，不能设定为自定义类型。如PersonBean
//	Object queryForObject(String sql,Object[] args,int[] argTypes,RowMapper rowMapper)
//	Object queryForObject(String sql,Object[] args,RowMapper rowMapper)
//	Object queryForObject(String sql,RowMapper rowMapper)
//	
//	public List<Goods> daoShowGoods(ApplicationContext context) {
//		String sql="SELECT goods.goods_id,goods.goods_name,goods.goods_price,goods.goods_information,"
//				+ "goods_remainNum,goods_picture,category.category_name,sysuser.mobile FROM "
//				+ "goods,category,sysuser WHERE goods.category_id=category.category_id AND goods.merchant_id=sysuser.merchant_id";
//																								
//		jdbcTemplate=(JdbcTemplate) context.getBean("jdbcTemplate_goods");	
//		return (List<Goods>) jdbcTemplate.query(sql, 
//				new ParameterizedRowMapper<Goods>() {
//					public Goods mapRow(ResultSet rs,int rowNum) throws SQLException{
//						Goods goods=new Goods();
//						goods.setGid(rs.getInt(1));
//						goods.setGname(rs.getString(2));
//						goods.setGprice(rs.getInt(3));
//						goods.setGinformation(rs.getString(4));
//						goods.setGremainNum(rs.getInt(5));
//						goods.setGpicture(rs.getString(6));
//						goods.setCategory(rs.getString(7));
//						goods.setSysmobile(rs.getString(8));
//						System.out.println(rs.getInt(1));
//						return goods;
//					}
//				}
//		);	
//	}
	@Override
	public PersonBean getPerson(int id) {
//		return (PersonBean)jdbcTemplate.query("select * from person where id=?", new Object[]{id}, 
//				new int[]{java.sql.Types.INTEGER},new PersonRowMapper() );
		return null;
	}

	@Override
	public List<PersonBean> getPersonBean() {
//		return (List<PersonBean>)jdbcTemplate.query("select * from person", 
//				new PersonRowMapper() );
		return null;
	}

	@Override
	public void delete(int personid) {
		jdbcTemplate.update("delete from person  where id=?", new Object[]{personid}, 
				new int[]{java.sql.Types.INTEGER});
	}

}
