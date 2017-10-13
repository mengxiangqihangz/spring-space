package com.example.abstractfactory;

public class Main {
	public static void main(String[] args) {
		// �ù���������ˮ��
		AbstractFactory abstractFactory = new GoodFoodFactory() ;
		
		Food food1 = abstractFactory.getApple();
		Food food2 = abstractFactory.getOrange();
		
		food1.showValue();
		food2.showValue();
		
		// ������������ˮ��
        AbstractFactory abstractFactory1 = new BadFoodFactory() ;// ֻ��Ҫ�ı乤�����ɡ�����֪��ʲô�г��󹤳�ģʽ�˰ɣ�
		
		Food food3 = abstractFactory1.getApple();
		Food food4 = abstractFactory1.getOrange();
		
		food3.showValue();
		food4.showValue();
	}
}
