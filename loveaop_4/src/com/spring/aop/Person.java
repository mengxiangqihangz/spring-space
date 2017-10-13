package com.spring.aop;

/**
 * 人对象
 * @author luwenbin006@163.com
 *
 */
public class Person implements Love
{

    /*
     * 重写谈恋爱方法
     * @see com.spring.aop.Love#fallInLove()
     */
    public void fallInLove()
    {
        System.out.println("谈恋爱了...");
    }

}
