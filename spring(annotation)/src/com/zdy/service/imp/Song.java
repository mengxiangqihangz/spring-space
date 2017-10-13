package com.zdy.service.imp;



import org.springframework.stereotype.Component;

import com.zdy.service.ITalent;
@Component
public class Song implements ITalent {

	@Override
	public void perform() {
		// TODO Auto-generated method stub
		System.out.println("³ª¸è");
	}

}
