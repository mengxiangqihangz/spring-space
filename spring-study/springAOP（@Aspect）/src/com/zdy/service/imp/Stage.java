package com.zdy.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.zdy.service.IStage;
import com.zdy.service.ITalent;

@Service("stage")
public class Stage implements IStage {
	
	@Autowired
	@Qualifier("song")
	public ITalent talent;

	@Override
	public void show() {
		// TODO Auto-generated method stub
		System.out.println("这里是个美丽的舞台");
		talent.perform();
	}

}
