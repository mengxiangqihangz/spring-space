package com.zdy.cn.springinaction.knights;

import com.zdy.cn.springinaction.quests.Quest;


public class BraveKnight implements Knight{
	
	public Quest quest;
	public BraveKnight(Quest quest){
		this.quest=quest;
	}
	@Override
	public void work() {
		// TODO Auto-generated method stub
		quest.show();
	};
	

}
