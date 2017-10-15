package cn.com.Dao;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import cn.com.source.Spitter;

public class PeopleDao {
	private SimpleJdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplat(SimpleJdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	private static String sql="insert into spitter(username,password) values (?,?)";
	public void addSpitter(Spitter spit){
//		jdbcTemplate.update(sql, spit.getUsername(),spit.getPassword());
	}
}
