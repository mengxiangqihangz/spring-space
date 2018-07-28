package com.sz.dao.impl;

import org.springframework.stereotype.Repository;

import com.sz.dao.BankDao;


@Repository
public class BankDaoImpl implements BankDao{
	
	public String getBank(){
		return "π§…Ã";
		
	}
}
