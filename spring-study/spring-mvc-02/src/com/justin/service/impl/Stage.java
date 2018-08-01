package com.justin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.justin.service.IStage;
import com.justin.service.ITalent;

@Service
public class Stage implements IStage {
	@Autowired
	@Qualifier("song")
	private ITalent talent;

	public void start() {
		this.talent.show("张三");
	}
}
