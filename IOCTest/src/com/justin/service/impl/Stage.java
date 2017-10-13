package com.justin.service.impl;

import com.justin.service.IStage;
import com.justin.service.ITalent;

public class Stage implements IStage {
	private ITalent talent;

	public void setTalent(ITalent talent) {
		this.talent = talent;
	}

	public void start() {
		this.talent.show();
	}
}