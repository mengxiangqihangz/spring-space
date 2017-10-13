package com.justin.test;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.justin.dao.UserDao;
import com.justin.model.UserBean;
/**
 * 一。根据mybatis-config.xml文件。构造出sessionfactory
 * 二。
 */
public class Test{

	private static UserDao userDao;
	private static SqlSession sqlSession;
	private static SqlSessionFactory sqlSessionFactory;
	
	static{
		sqlSessionFactory = DbInit.getSqlsessionfactory();
	}
	public static void main(String[] args) {
		sqlSession = sqlSessionFactory.openSession();
		userDao =(UserDao)sqlSession.getMapper(UserDao.class);
		UserBean ub = new UserBean();
//		ub.setUserId("2000");
		ub.setUserName("aaa");
		ub.setSex("1");
		ub.setAge(30);
		ub.setAddress("dfdfdf");
//		sqlSession.insert("UserDao.insertUser", ub);
		userDao.insertUser(ub);
		System.out.println(54444444);
	}
}
