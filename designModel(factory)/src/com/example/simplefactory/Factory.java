package com.example.simplefactory;

public class Factory {
	
	public static Food get(String name){
		if(name.equals("apple")){
			return new Apple();
		}else if(name.equals("orange")){
			return new Orange();
		}else{
			return null;
		}
	}
}
