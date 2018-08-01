package com.zdy.cn.controller;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.zdy.cn.util.ReflactUtil;

public class BaseController extends HttpServlet{
	
	List<BeanModel> listBM = new ArrayList<BeanModel>();

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String reqestPath=request.getServletPath();
		BeanModel bean=null;
		for (BeanModel bm : listBM) {
			if(bm.getPath().equals(reqestPath)){
				bean=bm;
				break;
			}
		}
		try {
			Class modelClass = Class.forName(bean.getClassName());
			Object obj = modelClass.newInstance();
			Method[] methods = modelClass.getDeclaredMethods();
			Method method=null;
			for (Method mth : methods) {
				if(mth.getName().equals(bean.getMethod())){
					method = mth;
					break;
				}
			}
			Class[] parameterTypes = method.getParameterTypes();
			Object[] parameterValues=new Object[parameterTypes.length];
			for (int i=0;i<parameterTypes.length;i++) {				
				if(parameterTypes[i].getName().equals(HttpServletRequest.class.getName())){
					parameterValues[i]=request;
				}
				if(parameterTypes[i].getName().equals(HttpServletResponse.class.getName())){
					parameterValues[i]=response;
				}
			}
			Object result = method.invoke(obj, parameterValues);
			if(result!=null){
				for (Object object : bean.getForward().keySet()) {
					if(object.equals(result)){
						request.getRequestDispatcher(bean.getForward().get(object)).forward(request, response);
//						response.sendRedirect(bean.getForward().get(object));
					}
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		//获取项目文件绝对路径config.getServletContext().getRealPath("/");
 		String path = config.getServletContext().getRealPath("/")+config.getInitParameter("config");
		try {
			parseXml(path);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.init(config);
	}
	
	private void parseXml(String path) throws Exception{
		
		SAXReader reader = new SAXReader();
		Document doc = reader.read(new File(path));
		Element beans = doc.getRootElement();
		List<Element> listBean = beans.elements();
		for (Element bean : listBean) {
			BeanModel bm = new BeanModel();
			ReflactUtil.parseObj(bm, bean,0);
			listBM.add(bm);
		}
	}

}
