package com.example.abstractfactory;

public class GoodFoodFactory implements AbstractFactory {
	@Override
	public Food getApple() {
		return new GoodApple();
	}
	@Override
	public Food getOrange() {
		return new GoodOrange();
	}
}
