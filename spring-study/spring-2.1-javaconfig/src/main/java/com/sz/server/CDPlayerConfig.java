package com.sz.server;

import org.junit.Test;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sz.entity.CDPlayer;
import com.sz.entity.CompactDisc;
import com.sz.entity.SgtPeppers;

@Configuration
public class CDPlayerConfig {
	
	
	
	
	@Bean
	public CompactDisc sgtPeppers(){
		
		return new SgtPeppers();
		
	}
	
	public CDPlayer cdPlayer(){
		return new CDPlayer(sgtPeppers());
	}
	
	@Test
	public void say(){
		cdPlayer();
	}
	
}
