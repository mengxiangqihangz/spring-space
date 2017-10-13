package com.example.methodfactory;

public class AppleFactory implements InterfaceFactory{
	@Override
	public  Food getFood() {
		return new Apple();
	}
}
