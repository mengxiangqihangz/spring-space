package com.example.methodfactory;

public class OrangeFactory implements InterfaceFactory{
	@Override
	public  Food getFood() {
		return new Orange();
	}
}
