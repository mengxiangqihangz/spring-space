package com.proxyPattern.dynamicProxy;

import java.lang.reflect.InvocationHandler;  
import java.lang.reflect.Method;  
import java.lang.reflect.Proxy;  
  
public class LogHandler implements InvocationHandler {  
     
    private Object targetObject;  

    public Object newProxyInstance(Object targetObject) {  
        this.targetObject = targetObject;  
        return Proxy.newProxyInstance(targetObject.getClass().getClassLoader(),  
                               targetObject.getClass().getInterfaces(), this);  
    }  
      
    public Object invoke(Object proxy, Method method, Object[] args)  
            throws Throwable {  
        Object ret = null;  
              
        try {  
            System.out.println("���ڽ��в���ǰ��׼����������");  
            //����Ŀ�귽��  
            ret = method.invoke(targetObject, args);  //ִ�� ����Ĵ˷���������Ϊargs
           System.out.println("�����ɹ������ڽ���ȷ�ϴ�����");  
        } catch (Exception e) {  
            e.printStackTrace();  
            System.out.println("error-->>" + method.getName());  
            throw e;  
        }  
        return ret;  
    }  
}  
