package com.justin.service.impl;

import org.springframework.stereotype.Service;

import com.justin.service.ITalent;

@Service("dance")
public class Dance implements ITalent {

	@Override
	public void show(String name) {
		System.out.println("优美舞蹈！");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
