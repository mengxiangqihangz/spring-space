package com.example.abstractfactory;

public class BadFoodFactory implements AbstractFactory {
	@Override
	public Food getApple() {
		return new BadApple();
	}
	@Override
	public Food getOrange() {
		return new BadOrange();
	}
}
