package cn.com;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import cn.com.Dao.DaoImpl;
import cn.com.source.Spitter;


/**
 * 这里展现了4种连接数据库的方式
 * 1. controller中的 连接mysql 和oracle数据库
 * 2. spring 的jdbcTemplate 执行sql
 * 3. DaoImpl中的 直接从c3p0的数据源中 获取连接。  ---------c3p0数据源是带连接池的。
 * 
 * 
 * @author liangpro
 *
 */
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
//		jdbcTemplate=(JdbcTemplate) app.getBean("jdbcTemplate");
//	}
	
	
	@Test
	public void testUpdate(){
		String sql="update spitter set spittername=? where spitterpassword=?";
		jdbcTemplate.update(sql, "lisi","456");
	}
	
//		Spitter spit=(Spitter) app.getBean("spitter");
//		
//		DaoImpl dao=(DaoImpl) app.getBean("daoimp");
//		dao.addSpitter(spit);


}
