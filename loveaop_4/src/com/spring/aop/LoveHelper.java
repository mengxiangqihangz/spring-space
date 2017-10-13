package com.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * 注解方式 aop通知类
 * @author luwenbin006@163.com
 *
 */
public class LoveHelper
{

    //在调用方法之前执行 执行拦截包com.spring.aop.*下所有的方法
    public void doBefore(JoinPoint point) throws Throwable
    {
        System.out.println("谈恋爱之前必须要彼此了解！");
    }
    
    //在调用方法前后执行
    public Object doAround(ProceedingJoinPoint point) throws Throwable
    {
        if(point.getArgs().length>0)
        {
            
            return point.proceed(point.getArgs());
            
        }else
        {
            
            return point.proceed();
        }
    }
    
    //在调用方法之后执行
    public void doAfter(JoinPoint point) throws Throwable
    {
        System.out.println("我们已经谈了5年了，最终还是分手了！");
        //System.out.println("我们已经谈了5年了，最终步入了结婚的殿堂！");
    }
    
    //当抛出异常时被调用
    public void doThrowing(JoinPoint point, Throwable ex)
    {
        System.out.println("doThrowing::method "
                + point.getTarget().getClass().getName() + "."
                + point.getSignature().getName() + " throw exception");
        System.out.println(ex.getMessage());
    }

}
