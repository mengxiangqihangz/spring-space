package com.example.abstractfactory;

public class Main {
	public static void main(String[] args) {
		// 好工厂生产的水果
		AbstractFactory abstractFactory = new GoodFoodFactory() ;
		
		Food food1 = abstractFactory.getApple();
		Food food2 = abstractFactory.getOrange();
		
		food1.showValue();
		food2.showValue();
		
		// 坏工厂生产的水果
        AbstractFactory abstractFactory1 = new BadFoodFactory() ;// 只需要改变工厂即可。这下知道什么叫抽象工厂模式了吧！
		
		Food food3 = abstractFactory1.getApple();
		Food food4 = abstractFactory1.getOrange();
		
		food3.showValue();
		food4.showValue();
	}
}
