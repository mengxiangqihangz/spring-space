package com.sz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.sz.dao.BankDao;

@Service
public class Child extends Parent{
	
////	@Autowired
////	@Qualifier("bankDaoImpl2")
	private BankDao bankDao;
//
//	public BankDao getBankDao() {
//		return bankDao;
//	}
//
//	public void setBankDao(BankDao bankDao) {
//		this.bankDao = bankDao;
//	}
//	public void say(){
////		bankDao.getBank();
////		this.getBankDao().getBank();
//		getBankDao();
//	}
	@Override
	public String getAddress(){
		return "beijing";
	}
	
//	public BankDao getBankDao() {
//		return bankDao;
//	}
//	public void setBankDao(BankDao bankDao) {
//		this.bankDao = bankDao;
//	}
	
}
