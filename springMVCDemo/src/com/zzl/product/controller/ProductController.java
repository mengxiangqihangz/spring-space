package com.zzl.product.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("product/")
public class ProductController {
	
//	@RequestMapping("show")�����show���൱��Person person=new Person�����е�person����һ�����ñ�����
//��ӳ�䵽�����еĴ�������
	@RequestMapping("show")
	public String showProduct(){
		return "home";
	}

}
