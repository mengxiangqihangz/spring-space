package com.zdy.cn.program.instrumentalist.imp;

import java.util.Collection;
import java.util.Map;

import com.zdy.cn.program.instrument.IInstrument;
import com.zdy.cn.program.instrumentalist.IPerformer;

public class OneManBan implements IPerformer{
	public OneManBan(){		
	}
	
	private Map<String,IInstrument> instruments;
	
	public Map<String,IInstrument> getInstruments() {
		return instruments;
	}

	public void setInstruments(Map<String,IInstrument> instruments) {
		this.instruments = instruments;
	}

	@Override
	public void perform() {
		// TODO Auto-generated method stub
		for(String key:instruments.keySet()){
			System.out.println(key+":");
			IInstrument oneman=(IInstrument)instruments.get(key);
			oneman.play();
		}
	}

}
