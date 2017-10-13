package com.zdy.cn.util;

import java.lang.reflect.Method;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Element;

import com.zdy.cn.controller.BeanModel;

public class ReflactUtil {

	public static String getMethodName(String name){
		return "set"+name.substring(0,1).toUpperCase()+name.substring(1);
	}
	
	public static boolean hasChild(Element element){
		List<Element> listEle = element.elements();
		if(listEle.size()>0){
			return true;
		}else{
			return false;
		}
	}
	
	public static void parseObj(BeanModel bm,Element element,int flag) throws Exception{
		//解析bean元素的属性
		List<Attribute> listAttr = element.attributes();
		for (Attribute attr : listAttr) {
			if(flag==0){
				String methodName = getMethodName(attr.getName());
				Method method = bm.getClass().getDeclaredMethod(methodName, new Class[]{String.class});
				method.invoke(bm, attr.getValue());
			}else{
				bm.getForward().put(attr.getValue(), element.getText());
			}
		}
		//解析bean元素的子元素
		if(hasChild(element)){
			List<Element> listForward = element.elements();
			for (Element forward : listForward) {
				parseObj(bm,forward,1);
			}
			
		}
	}
	
}
