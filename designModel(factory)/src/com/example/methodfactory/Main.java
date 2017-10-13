package com.example.methodfactory;

public class Main {
	public static void main(String[] args) {
		InterfaceFactory factory1 = new OrangeFactory();
		
		InterfaceFactory factory2 = new AppleFactory();
		
		Food food1 = factory1.getFood();
		Food food2 = factory2.getFood();
		
		food1.showValue();
		food2.showValue();
	}
}
