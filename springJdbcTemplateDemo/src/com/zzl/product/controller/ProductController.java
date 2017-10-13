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
	
	
//	@RequestMapping("show")这里的show就相当于Person person=new Person（）中的person，即一个引用变量。
//	所映射到容器中的处理方法。
	@RequestMapping("show")
	public String showProduct(){
		
		PersonBean personBean=new PersonBean();
	/*	personBean.setName("李四");
		personBean.setPwd(123);
		personServiceImpl.save(personBean);*/
		personBean.setId(2);
		personServiceImpl.personQuery(personBean);
		return "home";
	}
}
