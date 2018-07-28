package com.zzl.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zzl.product.dao.PersonService;
import com.zzl.product.model.PersonBean;

@Controller
@RequestMapping("product/")
public class ProductController {
	
	@Autowired
	PersonService personServiceImpl;
	
	
//	@RequestMapping("show")�����show���൱��Person person=new Person�����е�person����һ�����ñ�����
//	��ӳ�䵽�����еĴ�������
	@RequestMapping("show")
	public String showProduct(){
		
		PersonBean personBean=new PersonBean();
	/*	personBean.setName("����");
		personBean.setPwd(123);
		personServiceImpl.save(personBean);*/
		personBean.setId(2);
		personServiceImpl.personQuery(personBean);
		return "home";
	}
}
