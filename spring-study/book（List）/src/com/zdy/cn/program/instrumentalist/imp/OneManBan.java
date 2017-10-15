package com.zdy.cn.program.instrumentalist.imp;

import java.util.Collection;

import com.zdy.cn.program.instrument.IInstrument;
import com.zdy.cn.program.instrumentalist.IPerformer;

public class OneManBan implements IPerformer{
	public OneManBan(){		
	}
	
	private Collection<IInstrument> instruments;
	
	public Collection<IInstrument> getInstruments() {
		return instruments;
	}

	public void setInstruments(Collection<IInstrument> instruments) {
		this.instruments = instruments;
	}

	@Override
	public void perform() {
		// TODO Auto-generated method stub
		for(IInstrument instrument:instruments){
			instrument.play();
		}
	}

}
