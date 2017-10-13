package com;


public class Test {
	public static void main(String[] args) {
//		String str="aldfkj|ladsjk";
//		String[] s=str.split("\\|");
		String str="aldfkj.ladsjk";
		String[] s=str.split("\\.");
		for (String string : s) {
			System.out.println(string);
			
		}
	}
}
