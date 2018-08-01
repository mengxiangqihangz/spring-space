package com.tgb.test;


import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tgb.mapper.UserMapper;
import com.tgb.model.User;


/**如果代码想用Junit测试框架来测试,则Spring提供了对Junit支持，还可以使用注解的方式
 只需要在相应的Test类前面加上如下两个注解
 



 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/config/spring-common.xml")
public class UserTest {

	@Autowired
	private UserMapper userMapper;
	
	@Test
	public void testAdd(){
		
		User user = new User(100, "23", "jiuqiyuliang");
		userMapper.save(user);
		
	}
	
	@Test
	public void testFindAll(){
		List<User> findAllList = userMapper.findAll();
		System.out.println("哈哈哈"+findAllList.size());
	}
	
	@Test
	public void testFindById(){
		User user = userMapper.findById(5);
		System.out.println(user.getId());
		System.out.println(user.getUserName());
	}


	@Test
	public void testUpdate(){
		
		User user = new User(2, "23", "yuliang");
		userMapper.update(user);
	}
	
	@Test
	public void testDelete(){
		userMapper.delete(1);
	}
}
