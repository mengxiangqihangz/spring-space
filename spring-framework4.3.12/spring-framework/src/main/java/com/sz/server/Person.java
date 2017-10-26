package com.sz.server;

import com.sz.entity.Work;

public class Person {
	
	public Work work;
	
	public void doWork(){
		work.say();
	}

	public Work getWork() {
		return work;
	}

	public void setWork(Work work) {
		this.work = work;
	}

	
	
	
}
