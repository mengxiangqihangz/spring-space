package com.justin.service.impl;

import org.springframework.stereotype.Service;

import com.justin.service.ITalent;

@Service
public class Song implements ITalent {

	@Override
	public void show(String name) {
		System.out.println("高歌一曲！");
	}

}
