package com.example.simplefactory;

public class Main {
	public static void main(String[] args) {
		Food food1 = Factory.get("apple");
		Food food2 = Factory.get("orange");
		
		food1.showValue();
//		food2.showValue();
	}
}
