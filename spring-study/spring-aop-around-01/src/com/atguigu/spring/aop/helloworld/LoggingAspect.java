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

//�����������Ϊ���棺��Ҫ����������IOC�����У�������Ϊһ�����档
@Aspect
@Component
public class LoggingAspect {
/**
 * ProceedingJoinPoint��joinPoint��һ��proceed�����ķ���
 */
	@Pointcut("execution(public int com.atguigu.spring.aop.helloworld.ArithmeticCalculator.*(int,int))")
	public void arithmeticCalculatorPointcut(){}
	
	/**
	 * ��������ʱһ��ǰ��֪ͨ����Ŀ�귽����ʼ֮ǰִ��
	 * @param joinPoint
	 */
//	//@Before("execution(public int com.atguigu.spring.aop.helloworld.ArithmeticCalculator.add(int,int))")
//	//@Before("execution(public int com.atguigu.spring.aop.helloworld.ArithmeticCalculator.*(int,int))")
//	@Before("arithmeticCalculatorPointcut()")
//	public void beforMethod(JoinPoint joinPoint){
//		String methodName=joinPoint.getSignature().getName();	//getSignature�õ�����ע�ķ����Ķ���ͨ��getName�õ�������
//		List<Object> args=Arrays.asList(joinPoint.getArgs());	//����ע�������β��б�������һ��
//		System.out.println(joinPoint.getTarget().toString()); 	//getTarget() getThis()�����������ǵõ����� ��ע�㷽�� �Ķ��󣬼����ĸ���������˱���ע�ķ���
//		System.out.println(joinPoint.getThis().toString());
//		System.out.println("the method "+methodName+" begins"+args);
//	}
	/**
	 * ����֪ͨ����Ŀ�귽��ִ�к������Ƿ����쳣����ִ��֪ͨ��
	 * �ں���֪ͨ�л����ܷ���Ŀ�귽��ִ�еĽ����
	 */
	
//	@After("execution(public int com.atguigu.spring.aop.helloworld.ArithmeticCalculator.*(int,int))")
//	public void afterMethod(JoinPoint joinPoint){
//		String methodName=joinPoint.getSignature().getName();
//		System.out.println("the method "+methodName+" ends");
//	}
//	
	/**
	 * ����֪ͨ
	 * �ڷ�����������ʱִ��
	 * ����֪ͨ�ǿ��Է��ʵ������ķ���ֵ�ġ�
	 * @param joinPoint
	 * @param result
	 */
//	@AfterReturning(value="execution(public int com.atguigu.spring.aop.helloworld.ArithmeticCalculator.*(int,int))",returning="result")
//	public void AfterReturningMethod(JoinPoint joinPoint,Object result){
//		String methodName=joinPoint.getSignature().getName();
//		System.out.println("the method "+methodName+" ���Ϊ "+result);
//	}
	/**
	 * �쳣֪ͨ
	 * ��Ŀ�귽�������쳣ʱ��ִ�еĴ���
	 * ���Է��ʵ��쳣�Ķ����ҿ���ָ�������ض��쳣ʱ��ִ��֪ͨ���룬����Ϊ����NullPointerExceptionʱִ������Ĵ��롣
	 * @param joinPoint
	 * @param ex
	 */
//	@AfterThrowing(value="execution(public int com.atguigu.spring.aop.helloworld.ArithmeticCalculator.*(int,int))",throwing="ex")
//	public void AfterThrowingMethod(JoinPoint joinPoint,NullPointerException ex){
//		String methodName=joinPoint.getSignature().getName();
//		System.out.println("the method"+methodName+"�������쳣�ǣ�"+ex);
//	}
	
	/**
	 * ����֪ͨ
	 * ��ҪЯ��ProceedingJoinPoint���͵Ĳ���
	 * �����ڶ�̬����ȫ���̣�ProceedingJoinPoint���͵Ĳ������Ծ����Ƿ�ִ��Ŀ�귽����
	 * �һ���֪ͨ�����з���ֵ������ֵ��ΪĿ�귽���ķ���ֵ
	 * @return 
	 */
	@Around("execution(public int com.atguigu.spring.aop.helloworld.ArithmeticCalculator.*(int,int))")
	public Object aroundMethod(ProceedingJoinPoint pjp){
		
		Object result=null;	
		String methodName=pjp.getSignature().getName();
		List<Object> args=Arrays.asList(pjp.getArgs());
//		try {
//			Object m=pjp.proceed();
//			System.out.println(m+"--------");//��������ܵõ�������
//		} catch (Throwable e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		//ִ��Ŀ�귽��
		try {
			//ǰ��֪ͨ
			System.out.println("the method "+methodName+" begins with "+args);
			//ִ�з��� 
			result=pjp.proceed();			//ͨ������ִ��Ŀ���������ӵ㴦�ķ�����
			//
			System.out.println("the method "+methodName+" ends with "+result);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//return 100;
		return result;	//�������з���ֵ������֪ͨ�ķ���Ҳ�����з���ֵ���˷���ֵ���Ƿ���ִ�еĽ����
						//���Բ��Ƿ�ʵ�ʷ���ִ�еĽ�������緵��100�������б��˷���֪ͨ�ķ�������ֵ����100����ʵ�ʷ�������Ľ����result�����
						//����int result=i+j����ʵ�൱�뽫i+j���ڻ���֪ͨ��ִ�С�����֪ͨ���صĽ�����Ƿ���ִ�еĽ����
						//�൱�� result=aroundMethod��i+j�����Ǳߵ�result�õ�������ߵķ���ֵ��
	}
	
}
