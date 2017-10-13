package com.zzl.product.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.zzl.product.model.User;

public class Test {

    public static void main(String[] args) throws IOException {
        //mybatis�������ļ�
        String resource = "conf.xml";
        //ʹ�������������mybatis�������ļ�����Ҳ���ع�����ӳ���ļ���
//        getClass()��ȡ�õ�ǰ����������Class���� 
//        getClassLoader()��ȡ�ø�Class�������װ����---��װ���������Java�ַ��ļ����ַ��������ڴ棬������Class�����
//        1. Class.getResourceAsStream(String path) �� path ���ԡ�/'��ͷʱĬ���ǴӴ������ڵİ���ȡ��Դ���ԡ�/'��ͷ���Ǵ�
//        ClassPath���»�ȡ����ֻ��ͨ��path����һ������·�������ջ�����ClassLoader��ȡ��Դ�� 
//        2. Class.getClassLoader.getResourceAsStream(String path) ��Ĭ�����Ǵ�ClassPath���»�ȡ��path�����ԡ�/'��ͷ����������
//        ClassLoader��ȡ��Դ�� 
//        3. ServletContext. getResourceAsStream(String path)��Ĭ�ϴ�WebAPP��Ŀ¼��ȡ��Դ��Tomcat��path�Ƿ��ԡ�/'��ͷ����ν��

        InputStream is = Test.class.getClassLoader().getResourceAsStream(resource);
//		    ����sqlSession�Ĺ���
//        ��ʹ��mybatis���ʱ����һ������Ҫ����SqlSessionFactory���ʵ�����൱���ǲ������ӳأ���ͨ������SqlSessionFactoryBuilder���ʵ����build���������
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        
        //�����ע������һ�֡��������ֽ������������ַ�����
        //ʹ��MyBatis�ṩ��Resources�����mybatis�������ļ�����Ҳ���ع�����ӳ���ļ� ��
        //Reader reader = Resources.getResourceAsReader(resource); 
        //����sqlSession�Ĺ���
        //SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        
        //������ִ��ӳ���ļ���sql��sqlSession
        SqlSession session = sessionFactory.openSession();
/**
 * ӳ��sql�ı�ʶ�ַ�����
 * me.gacl.mapping.userMapper��userMapper.xml�ļ���mapper��ǩ��namespace���Ե�ֵ��
 * getUser��select��ǩ��id����ֵ��ͨ��select��ǩ��id����ֵ�Ϳ����ҵ�Ҫִ�е�SQL
 */
//        String statement = "userMapper.getUser";//ӳ��sql�ı�ʶ�ַ���
//        //ִ�в�ѯ����һ��Ψһuser�����sql
//      User user = session.selectOne(statement, 1);
//      System.out.println(user);
        
        User us=new User();
        us.setName("����");
        us.setAge(800);
        String state="userMapper.insertUser";
        int i=session.insert(state, us);
        System.out.println(i);
        
    }
}