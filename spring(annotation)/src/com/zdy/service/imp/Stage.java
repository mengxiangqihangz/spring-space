package com.zdy.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.zdy.service.IStage;
import com.zdy.service.ITalent;

@Component("sta")//可以标明（）中的东西。不标默认为类小写第一个字母stage
public class Stage implements IStage {
	
	@Autowired
	@Qualifier("dance")
	public ITalent talent;
	
	public void setTalent(ITalent talent) {
		this.talent = talent;
	}
	@Override
	public void show() {
		// TODO Auto-generated method stub
		System.out.println("这里是个美丽的舞台");
		talent.perform();
	}

}
