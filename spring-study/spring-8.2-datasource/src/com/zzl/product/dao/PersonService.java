package com.zzl.product.dao;
import java.util.List;

import com.zzl.product.model.PersonBean;



public interface PersonService {


	public void save(PersonBean person);
	public void personQuery(PersonBean person);
	public void update(PersonBean person);

	public PersonBean getPerson(int id);
	
	public List<PersonBean> getPersonBean();
	
	public void delete(int personid);
	

}
