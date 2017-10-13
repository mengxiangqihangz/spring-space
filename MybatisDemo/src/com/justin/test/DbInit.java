package com.justin.test;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DbInit {
	private final static SqlSessionFactory sqlSessionFactory;
	
	public static SqlSessionFactory getSqlsessionfactory() {
		return sqlSessionFactory;
	}
/**
 * 非静态自由块的执行时间是：在执行构造函数之前。
 * 静态自由块的执行时间是：class文件加载时执行。
 * 执行的时间不同，造成的结果是：非静态自由块可以多次执行，只要初始化一个对象就会执行，但是静态自由块只会在类装载的时候执行一次，一般用来初始化类的静态变量的值。
 */
	static{
		String resource = "mybatis-config.xml";
		Reader reader = null;
		try {
			reader = Resources.getResourceAsReader(resource);
		} catch (IOException e) {
			e.printStackTrace();
		}
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
	}
	
	
}
