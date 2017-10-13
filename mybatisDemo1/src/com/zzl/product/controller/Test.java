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
        //mybatis的配置文件
        String resource = "conf.xml";
        //使用类加载器加载mybatis的配置文件（它也加载关联的映射文件）
//        getClass()：取得当前对象所属的Class对象 
//        getClassLoader()：取得该Class对象的类装载器---类装载器负责从Java字符文件将字符流读入内存，并构造Class类对象
//        1. Class.getResourceAsStream(String path) ： path 不以’/'开头时默认是从此类所在的包下取资源，以’/'开头则是从
//        ClassPath根下获取。其只是通过path构造一个绝对路径，最终还是由ClassLoader获取资源。 
//        2. Class.getClassLoader.getResourceAsStream(String path) ：默认则是从ClassPath根下获取，path不能以’/'开头，最终是由
//        ClassLoader获取资源。 
//        3. ServletContext. getResourceAsStream(String path)：默认从WebAPP根目录下取资源，Tomcat下path是否以’/'开头无所谓，

        InputStream is = Test.class.getClassLoader().getResourceAsStream(resource);
//		    构建sqlSession的工厂
//        在使用mybatis框架时，第一步就需要产生SqlSessionFactory类的实例（相当于是产生连接池），通过调用SqlSessionFactoryBuilder类的实例的build方法来完成
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        
        //下面的注释是另一种。上面是字节流，下面是字符流。
        //使用MyBatis提供的Resources类加载mybatis的配置文件（它也加载关联的映射文件 ）
        //Reader reader = Resources.getResourceAsReader(resource); 
        //构建sqlSession的工厂
        //SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        
        //创建能执行映射文件中sql的sqlSession
        SqlSession session = sessionFactory.openSession();
/**
 * 映射sql的标识字符串，
 * me.gacl.mapping.userMapper是userMapper.xml文件中mapper标签的namespace属性的值，
 * getUser是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
 */
//        String statement = "userMapper.getUser";//映射sql的标识字符串
//        //执行查询返回一个唯一user对象的sql
//      User user = session.selectOne(statement, 1);
//      System.out.println(user);
        
        User us=new User();
        us.setName("张三");
        us.setAge(800);
        String state="userMapper.insertUser";
        int i=session.insert(state, us);
        System.out.println(i);
        
    }
}