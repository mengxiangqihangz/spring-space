package cn.com;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import cn.com.Dao.DaoImpl;
import cn.com.source.Spitter;

public class JdbcTest {
	
	private static ApplicationContext app=null;
	private static JdbcTemplate jdbcTemplate;
	public static void main(String[] args) {
		app=new ClassPathXmlApplicationContext("applicationContext.xml");
		jdbcTemplate=(JdbcTemplate) app.getBean("jdbcTemplate");
		String sql="update spitter set spittername=? where spitterpassword=?";
		jdbcTemplate.update(sql, "lisi","456");
	}
	
	
//	{
//		app=new ClassPathXmlApplicationContext("applicationContext.xml");
//		JdbcTemplate jdbcTemplate=(JdbcTemplate) app.getBean("jdbcTemplate");
//	}
//	
//	@Test
//	public void testUpdate(){
//		String sql="update spitter set spittername=? where spitterpassword=?";
//		jdbcTemplate.update(sql, "lisi","456");
//	}
	
//		Spitter spit=(Spitter) app.getBean("spitter");
//		
//		DaoImpl dao=(DaoImpl) app.getBean("daoimp");
//		dao.addSpitter(spit);


}
