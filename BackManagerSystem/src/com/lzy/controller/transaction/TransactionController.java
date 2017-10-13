package com.lzy.controller.transaction;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("transaction/")
public class TransactionController {
	
	@RequestMapping("transaction")
	public String transaction(){
		System.out.println("transaction/transaction");
		return "transaction/transaction";
	}
	
	@RequestMapping("amounts")
	public String amounts(){
		System.out.println("transaction/amounts");
		return "transaction/amounts";
	}
	
	@RequestMapping("covermanagement")
	public String covermanagement(){
		System.out.println("transaction/covermanagement");
		return "transaction/covermanagement";
	}
	
	@RequestMapping("orderform")
	public String orderform(){
		System.out.println("transaction/orderform");
		return "transaction/orderform";
	}
	
	@RequestMapping("orderhandling")
	public String orderhandling(){
		System.out.println("transaction/orderhandling");
		return "transaction/orderhandling";
	}
	
}
