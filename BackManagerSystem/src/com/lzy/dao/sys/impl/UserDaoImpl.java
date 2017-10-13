package com.lzy.dao.sys.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


import com.lzy.dao.sys.IUserDao;
import com.lzy.model.LoginRecords;
import com.lzy.model.SysUser;


/**
 * @author justin
 * 用户管理服务类
 */
@Repository("userDao")
public class UserDaoImpl  implements IUserDao {
	
	SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
	String time=format.format(new Date());
	
	
	@Autowired
	private JdbcTemplate jdbcTemplate_sys;
	
	/**
	 * 验证用户是否成功登陆
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public int isLogin (SysUser user) {
//		
		String sql = "select userid from sysuser where userName= '"+user.getUserName()+"' and userPwd = '"+user.getUserPwd()+"'";
		try{
			int userId = jdbcTemplate_sys.queryForInt(sql);
			return userId;
		}catch(Exception e){
			System.out.println("用户登录出错");;
			return 0;
		}
		
	}
	/**
	 * 用户注册
	 * @param user
	 * @return
	 * @throws Exception
	 */
	
	@Override
	public boolean isregister(SysUser user) throws Exception {
		String sql1 = "select count(*) from sysuser where username = '"+user.getUserName()+"'";
		int i = jdbcTemplate_sys.update(sql1);
		if(i==0){
			user.setCreateDate(time);
			String sql = "insert into sysuser (userName, userPwd,createDate) values ('"+user.getUserName()+"', '"+user.getUserPwd()+"', '"+user.getCreateDate()+"')";
			int count = jdbcTemplate_sys.update(sql);
			if(count!=0){
				return true;
			}
		}else{
			return false;
		}
		return false;
	}
	
	/**
	 * 查询用户信息
	 * @param user
	 * @return
	 * @throws Exception
	 */

	public SysUser userinfor(String userId) throws Exception {
		String sql = "select * from sysuser where userId= "+userId;
		
		SysUser user1 = jdbcTemplate_sys.queryForObject(sql, 
				new RowMapper<SysUser>(){
					public SysUser mapRow(ResultSet re, int rowNum) throws SQLException {
						SysUser user = new SysUser();
						user.setUserId(re.getInt("userid"));
						user.setUserName(re.getString("username"));
						user.setSex(re.getString("sex"));
						user.setAge(re.getInt("age"));
						user.setEmail(re.getString("email"));
						user.setMobile(re.getString("mobile"));
						user.setQq(re.getString("qq"));
						user.setUserPwd(re.getString("userPwd"));
						user.setCreateDate(re.getString("createDate"));
						user.setAddr(re.getString("addr"));
						return user;
					}
				}
				
				);
		System.out.println("查询的用户性别:"+user1.getSex());
		System.out.println("查询的用户地址:"+user1.getAddr());
		return user1;
	}
	

	/**
	 * 记录用户登录信息
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@Override
	public void records(LoginRecords login) throws Exception {
		String sql = "insert into loginrecords (userid, userName, IP, datetime) values ("+login.getUserId()+",'"+login.getUserName()+"','"+login.getIP()+"','"+login.getLoadTime()+"')";
		jdbcTemplate_sys.execute(sql);
	}

	/**
	 * 查询用户登录信息
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<LoginRecords> loadInforList(int iDisplayStart, int iDisplayLength, String userId) {
//		int firstResult = iDisplayStart*iDisplayLength+1;
//		int maxResult = (iDisplayStart+1)*iDisplayLength;
//		String sql = "select * from (select rownum as num,t.* from (select * from loginrecords  where userid = "+userId+")t)a where a.num >="+ firstResult +" and a.num <=" + maxResult;
		
		int first = iDisplayStart*iDisplayLength;
		String sql = "select * from loginrecords where userid = "+userId+" order by count desc limit " +iDisplayStart+","+iDisplayLength;
		List<LoginRecords> loginRelist = jdbcTemplate_sys.query(sql, new RowMapper<LoginRecords>(){
			public LoginRecords mapRow(ResultSet re, int rowNum) throws SQLException {
				LoginRecords lrs = new LoginRecords();
				lrs.setCount(re.getInt("count"));
				lrs.setUserId(re.getInt("userId"));
				lrs.setGener(re.getInt("gener"));
				lrs.setContent(re.getString("content"));
				lrs.setUserName(re.getString("userName"));
				lrs.setSite(re.getString("site"));
				lrs.setIP(re.getString("IP"));
				lrs.setUserName(re.getString("userName"));
				lrs.setLoadTime(re.getString("datetime"));
				return lrs;
			}
		});
		return loginRelist;
	}
	
	/**
	 * 用户登陆信息查询条数
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public int queryDataCount(String userId) {
		String sql = "select count(*) from loginrecords where userid = "+userId;
		int count = jdbcTemplate_sys.queryForInt(sql);
		return count;
	}
	

	
	/**
	 * 首页显示用户登录信息
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public LoginRecords home(String userId) {
		
		String sql = "select * from loginrecords where userId = '"+userId+"'order by count desc limit 1";
		LoginRecords loginRecords = jdbcTemplate_sys.queryForObject(sql, new RowMapper<LoginRecords>(){
			public LoginRecords mapRow(ResultSet re, int rowNum) throws SQLException {
				LoginRecords lrs = new LoginRecords();
				lrs.setUserId(re.getInt("userId"));
				lrs.setGener(re.getInt("gener"));
				lrs.setContent(re.getString("content"));
				lrs.setSite(re.getString("site"));
				lrs.setIP(re.getString("IP"));
				lrs.setLoadTime(re.getString("datetime"));
				return lrs;
			}
		});
		return loginRecords;
	}
}
