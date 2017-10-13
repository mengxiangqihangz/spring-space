package test;

import test.ClassTset;

public class ClassTest1 extends ClassTset {

	public static void Rom() {
		System.out.println("5");
	}

	{

		System.out.println("8");
	}

	public ClassTest1() {

		System.out.println("9");

		new ClassTset();
	}

	static {
		System.out.println("4");
	}

	public static void main(String[] args) {
		Rom();
		new ClassTest1();

	}

}
