package com.sz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import com.sz.dao.BankDao;

@Component
public class Parent implements ParentInterface{
	
//	@Autowired
//	@Qualifier("bankDaoImpl")
	private BankDao bankDao;
	
	@Override
	public void service(){
		System.out.println("À²À²À²À²À²À²");
		String bank = bankDao.getBank();
		String addr = getAddress();
		System.out.println(bank + ": addr = " + addr + ",ÂÌ¿¨À²À²À²À²À²");
	}
	
	public String getAddress(){
		return "ÉîÛÚ";
	}
	
	public BankDao getBankDao() {
		return bankDao;
	}

	public void setBankDao(BankDao bankDao) {
		this.bankDao = bankDao;
	}
}
