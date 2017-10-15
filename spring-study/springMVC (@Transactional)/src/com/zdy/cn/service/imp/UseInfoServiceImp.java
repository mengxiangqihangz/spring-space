package com.zdy.cn.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.zdy.cn.dao.IUserInfoDao;
import com.zdy.cn.dao.imp.UserInfoDaoImp;
import com.zdy.cn.model.UserInfo;
import com.zdy.cn.service.IUserInfoService;

@Service
public class UseInfoServiceImp implements IUserInfoService{

	@Autowired
	@Qualifier("userInfoDaoImp")
	IUserInfoDao userInfoDao;
	
	public UseInfoServiceImp(){
	}
	
	public boolean login(UserInfo user) throws Exception{
		String sql = "select count(*) from userinfo where name='"+user.getName()+"' and pwd='"+user.getPwd()+"'";
		return userInfoDao.login(sql);
	}

	public boolean regist(UserInfo user) throws Exception{
		String sql = "insert into userinfo (name,pwd,age,addr) values('"+user.getName()+"','"+user.getPwd()+"',"+user.getAge()+",'"+user.getAddr()+"')";
		return userInfoDao.regist(sql);
	}
	
	public List<UserInfo> findAll() throws Exception{
		String sql = "select id,name,pwd,age,addr from userinfo";
		return userInfoDao.findAll(sql);
	}
	
	public UserInfo edit(String id) throws Exception{
		String sql = "select id,name,pwd,age,addr from userinfo where id='"+id+"'";
		return userInfoDao.edit(sql);
	}

	@Override
	public boolean update(UserInfo user) throws Exception {
		String sql = "update userinfo set name='"+user.getName()+"',pwd='"+user.getPwd()+"',age="+user.getAge()+",addr='"+user.getAddr()+"' where id='"+user.getId()+"'";
		return userInfoDao.update(sql);
	}

}
