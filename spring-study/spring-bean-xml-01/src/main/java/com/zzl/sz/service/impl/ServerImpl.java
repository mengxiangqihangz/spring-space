package com.zzl.sz.service.impl;

import java.util.List;

import com.zzl.sz.entity.Company;
import com.zzl.sz.entity.Person;
import com.zzl.sz.service.Server;



public class ServerImpl implements Server{
	
	private Person person;
	
	private List entity;
	
	@Override
	public String doJob() {
		System.out.println("person : [" + person.getName() + " , " + person.getAge() + "]");
		Company company = (Company) entity.get(1);
		System.out.println(company);
		return person.getName() + " , " + person.getAge();
		
	}



	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}

	public List getEntity() {
		return entity;
	}

	public void setEntity(List entity) {
		this.entity = entity;
	}
	
	
}
