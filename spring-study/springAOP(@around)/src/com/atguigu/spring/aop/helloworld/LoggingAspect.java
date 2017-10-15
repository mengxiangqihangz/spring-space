package com.atguigu.spring.aop.helloworld;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//把这个类声明为切面：需要把这个类放入IOC容器中，再声明为一个切面。
@Aspect
@Component
public class LoggingAspect {
/**
 * ProceedingJoinPoint比joinPoint多一个proceed（）的方法
 */
	@Pointcut("execution(public int com.atguigu.spring.aop.helloworld.ArithmeticCalculator.*(int,int))")
	public void arithmeticCalculatorPointcut(){}
	
	/**
	 * 声明方法时一个前置通知：在目标方法开始之前执行
	 * @param joinPoint
	 */
//	//@Before("execution(public int com.atguigu.spring.aop.helloworld.ArithmeticCalculator.add(int,int))")
//	//@Before("execution(public int com.atguigu.spring.aop.helloworld.ArithmeticCalculator.*(int,int))")
//	@Before("arithmeticCalculatorPointcut()")
//	public void beforMethod(JoinPoint joinPoint){
//		String methodName=joinPoint.getSignature().getName();	//getSignature得到被关注的方法的对象。通过getName得到方法名
//		List<Object> args=Arrays.asList(joinPoint.getArgs());	//被关注方法的形参列表。可以是一个
//		System.out.println(joinPoint.getTarget().toString()); 	//getTarget() getThis()两个方法都是得到调用 关注点方法 的对象，即又哪个对象调用了被关注的方法
//		System.out.println(joinPoint.getThis().toString());
//		System.out.println("the method "+methodName+" begins"+args);
//	}
	/**
	 * 后置通知：在目标方法执行后（无论是否发生异常），执行通知。
	 * 在后置通知中还不能访问目标方法执行的结果。
	 */
	
//	@After("execution(public int com.atguigu.spring.aop.helloworld.ArithmeticCalculator.*(int,int))")
//	public void afterMethod(JoinPoint joinPoint){
//		String methodName=joinPoint.getSignature().getName();
//		System.out.println("the method "+methodName+" ends");
//	}
//	
	/**
	 * 返回通知
	 * 在方法正常结束时执行
	 * 返回通知是可以访问到方法的返回值的。
	 * @param joinPoint
	 * @param result
	 */
//	@AfterReturning(value="execution(public int com.atguigu.spring.aop.helloworld.ArithmeticCalculator.*(int,int))",returning="result")
//	public void AfterReturningMethod(JoinPoint joinPoint,Object result){
//		String methodName=joinPoint.getSignature().getName();
//		System.out.println("the method "+methodName+" 结果为 "+result);
//	}
	/**
	 * 异常通知
	 * 在目标方法出现异常时会执行的代码
	 * 可以访问到异常的对象，且可以指定出现特定异常时再执行通知代码，下面为出现NullPointerException时执行下面的代码。
	 * @param joinPoint
	 * @param ex
	 */
//	@AfterThrowing(value="execution(public int com.atguigu.spring.aop.helloworld.ArithmeticCalculator.*(int,int))",throwing="ex")
//	public void AfterThrowingMethod(JoinPoint joinPoint,NullPointerException ex){
//		String methodName=joinPoint.getSignature().getName();
//		System.out.println("the method"+methodName+"发生的异常是："+ex);
//	}
	
	/**
	 * 环绕通知
	 * 需要携带ProceedingJoinPoint类型的参数
	 * 类似于动态代理全过程：ProceedingJoinPoint类型的参数可以决定是否执行目标方法。
	 * 且环绕通知必须有返回值，返回值即为目标方法的返回值
	 * @return 
	 */
	@Around("execution(public int com.atguigu.spring.aop.helloworld.ArithmeticCalculator.*(int,int))")
	public Object aroundMethod(ProceedingJoinPoint pjp){
		
		Object result=null;	
		String methodName=pjp.getSignature().getName();
		List<Object> args=Arrays.asList(pjp.getArgs());
//		try {
//			Object m=pjp.proceed();
//			System.out.println(m+"--------");//这个并不能得到方法名
//		} catch (Throwable e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		//执行目标方法
		try {
			//前置通知
			System.out.println("the method "+methodName+" begins with "+args);
			//执行方法 
			result=pjp.proceed();			//通过反射执行目标对象的连接点处的方法；
			//
			System.out.println("the method "+methodName+" ends with "+result);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//return 100;
		return result;	//若方法有返回值。则环绕通知的方法也必须有返回值。此返回值才是方法执行的结果，
						//可以不是非实际方法执行的结果，比如返回100。则所有被此方法通知的方法返回值都是100，而实际方法处理的结果由result输出。
						//比如int result=i+j，其实相当与将i+j放在环绕通知中执行。环绕通知返回的结果就是方法执行的结果。
						//相当于 result=aroundMethod（i+j）。那边的result得到的是这边的返回值。
	}
	
}
