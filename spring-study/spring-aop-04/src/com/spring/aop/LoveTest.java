package com.spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.aop.Love;

/**
 * aop测试方法类
 * @author luwenbin006@163.com
 *
 */
public class LoveTest
{

    public static void main(String[] args)
    {
        //加载spring配置文件
        ApplicationContext appCtx = new ClassPathXmlApplicationContext("applicationContext.xml");
        //得到person对象
        Love love = (Love) appCtx.getBean("person");
        //调用谈恋爱方法
        love.fallInLove();
    }
}