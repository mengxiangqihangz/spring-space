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
 * �Ǿ�̬���ɿ��ִ��ʱ���ǣ���ִ�й��캯��֮ǰ��
 * ��̬���ɿ��ִ��ʱ���ǣ�class�ļ�����ʱִ�С�
 * ִ�е�ʱ�䲻ͬ����ɵĽ���ǣ��Ǿ�̬���ɿ���Զ��ִ�У�ֻҪ��ʼ��һ������ͻ�ִ�У����Ǿ�̬���ɿ�ֻ������װ�ص�ʱ��ִ��һ�Σ�һ��������ʼ����ľ�̬������ֵ��
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
