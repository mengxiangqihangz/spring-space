package com.zdy.cn.program.instrumentalist.imp;

import com.zdy.cn.program.instrument.IInstrument;

import com.zdy.cn.program.instrumentalist.IPerformer;

public class Instrumentalist implements IPerformer{
	private String song;
	private IInstrument instrument;
	
	public Instrumentalist(){	
	}
	
	public void setSong(String song) {
		this.song = song;
	}
	public void setInstrument(IInstrument instrument) {
		this.instrument = instrument;
	}
	
	@Override
	public void perform() {
		System.out.println("playing:"+song+":");
		instrument.play();
		
	}
	
}
