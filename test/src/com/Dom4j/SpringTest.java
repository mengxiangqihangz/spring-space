package com.Dom4j;

public class SpringTest extends Dom {

	public void say() {
		System.out.println("不用new，我一样可以打印出来，6不6？");

	}

	public static void main(String[] args) throws Exception {

		SpringTest s;
		SpringFactory sf;
        SSS a;
		s = (SpringTest) SingleAttribute.getclass("SpringTest");// 只需复制粘贴即可

		sf = (SpringFactory) SingleAttribute.getclass("SpringFactory");
		a = (SSS) SingleAttribute.getclass("SSS");
		s.say();
		sf.talk();
         a.s();
	}

}
