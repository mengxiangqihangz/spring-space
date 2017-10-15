package com.zdy.cn.dao.imp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SingleColumnRowMapper;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zdy.cn.connection.ConnectionFactory;
import com.zdy.cn.dao.IUserInfoDao;
import com.zdy.cn.model.UserInfo;

@Service
@Transactional(propagation=Propagation.REQUIRED,rollbackFor=java.lang.Exception.class,readOnly=true)
public class UserInfoDaoImp implements IUserInfoDao{
	
	@Autowired
	@Qualifier("connectionFactory")
	private ConnectionFactory factory;
	
	public UserInfoDaoImp(){
		
	}
	
	@Autowired
	@Qualifier("jdbcTemplate")
	private JdbcTemplate template;
	
	public Connection getConnection() throws Exception{
		return factory.getConnection("mysql");
	}

	@Override
	public boolean login(String sql) throws Exception{
		int count = template.queryForInt(sql);
		if(count>0){
			return true;
		}else{
			return false;
		}
//		Statement st = getConnection().createStatement();
//		ResultSet rs = st.executeQuery(sql);		
//		return rs.next();
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=java.lang.Exception.class,readOnly=false)
	public boolean regist(String sql) throws Exception{
		
		int count = template.update(sql);
		
//		Statement st = getConnection().createStatement();
//		int count = st.executeUpdate(sql);	
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
	public List<UserInfo> findAll(String sql) throws Exception{
		List<Map<String,Object>> list1 = template.queryForList(sql);
		List<UserInfo> list = new ArrayList<UserInfo>();
		for (Map<String, Object> map : list1) {
			UserInfo user = new UserInfo();
			user.setId(Integer.parseInt(map.get("id").toString()));
			user.setName(map.get("name").toString());
			user.setPwd(map.get("pwd").toString());
			user.setAge(Integer.parseInt(map.get("age").toString()));
			user.setAddr(map.get("addr").toString());
			list.add(user);
		}
		
//		Statement st = getConnection().createStatement();
//		ResultSet rs = st.executeQuery(sql);
//		List<UserInfo> list = new ArrayList<UserInfo>();
//		while(rs.next()){
//			UserInfo user = new UserInfo();
//			int id= rs.getInt("id");
//			String name = rs.getString("name");
//			String pwd = rs.getString("pwd");
//			int age = rs.getInt("age");
//			String addr = rs.getString("addr");
//			user.setId(id);
//			user.setName(name);
//			user.setPwd(pwd);
//			user.setAddr(addr);
//			user.setAge(age);
//			list.add(user);
//		}
		return list;
	}

	@Override
	public UserInfo edit(String sql) throws Exception {
		return template.queryForObject(sql, new SingleColumnRowMapper<UserInfo>(){

			@Override
			public UserInfo mapRow(ResultSet rs, int count)
					throws SQLException {
				UserInfo user = new UserInfo();
				user.setId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setPwd(rs.getString(3));
				user.setAge(rs.getInt(4));
				user.setAddr(rs.getString(5));
				return user;
			}
			
		});
//		Statement st = getConnection().createStatement();
//		ResultSet rs = st.executeQuery(sql);
//		UserInfo user = new UserInfo();
//		while(rs.next()){			
//			int id= rs.getInt("id");
//			String name = rs.getString("name");
//			String pwd = rs.getString("pwd");
//			int age = rs.getInt("age");
//			String addr = rs.getString("addr");
//			user.setId(id);
//			user.setName(name);
//			user.setPwd(pwd);
//			user.setAddr(addr);
//			user.setAge(age);
//		}
//		return user;
	}

	@Override
	public boolean update(String sql) throws Exception {
		
//		String sql2 = "insert into userinfo(name,pwd,age,addr) values(?,?,?,?)";
		
		int count = template.update(sql);
//		Statement st = getConnection().createStatement();
//		int count = st.executeUpdate(sql);	
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
	

}
