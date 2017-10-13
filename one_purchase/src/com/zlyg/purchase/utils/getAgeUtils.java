package com.zlyg.purchase.utils;

import java.util.Date;

public class getAgeUtils {
	public int getAgeByCardId(String cardId){
		int birth = Integer.parseInt(cardId.substring(6, 10));
		Date date = new Date();
		int age = date.getYear()+1900-birth+1;
		return age;
	}
}
