package com.atguigu.spring.aop.packagee;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class ArithmeticCalculatorLoggingProxy {
	
//	//Ҫ����Ķ���
//	private ArithmeticCalculator target;
//	
//	public ArithmeticCalculatorLoggingProxy(ArithmeticCalculator target){
//		this.target=target;
//	}
//	
//	public ArithmeticCalculator getLoggingProxy(){
//		ArithmeticCalculator proxy=null;
//		//����������ĸ���������������
//		ClassLoader loader=target.getClass().getClassLoader();
//		//�����������ͣ�����������Щ������
//		Class[] interfaces=new Class[]{ArithmeticCalculator.class};
//		//�����ô���������еķ���ʱ����ִ�еķ���
//		InvocationHandler h=new InvocationHandler() {
//			/**
//			 * proxy:���ڷ��ص��Ǹ��������һ������£���invoke�����ж���ʹ�øö���
//			 * method�����ڱ����õķ���
//			 * args�����÷���ʱ������Ĳ���
//			 */
//			@Override
//			public Object invoke(Object proxy, Method method, Object[] args)
//					throws Throwable {
//				System.out.println(proxy.getClass().getName());
////				System.out.println(proxy.toString());
//				// TODO Auto-generated method stub
//				String methodName=method.getName();
//				//��־
//				System.out.println("the method "+methodName+" begins with"+Arrays.asList(args));
//				//ִ�з���
//				try{
//					//ǰ��֪ͨ
//					Object result=method.invoke(target, args);
//					//����֪ͨ
//						System.out.println("the method "+methodName+" ends with"+result);
//						return result;
//				}catch(Exception e){
//					e.printStackTrace();
//					//�쳣֪ͨ�����Է��ʵ��������쳣
//				}
//				//����֪ͨ����Ϊ�������ܳ��쳣�����Է��ʲ��������ķ���ֵ��
//				//��־
////				System.out.println("the method "+methodName+" ends with"+result);
////				return result;
//			
//			};
//		
//		proxy=(ArithmeticCalculator) Proxy.newProxyInstance(loader, interfaces, h);
//		
//		return proxy;
//	}
}
