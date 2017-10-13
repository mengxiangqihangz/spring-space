package com.zdy.service.imp;

import org.springframework.stereotype.Service;

import com.zdy.service.ITalent;

@Service
public class Song implements ITalent {

	@Override
	public void perform() {
		// TODO Auto-generated method stub
		System.out.println("³ª¸è");
	}

}
