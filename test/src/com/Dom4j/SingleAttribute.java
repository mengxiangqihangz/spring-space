package com.Dom4j;

import java.util.HashMap;
import java.util.Map;

/**
 * 单例类 存储类的实例化的类
 * 
 */

public class SingleAttribute {
	private static Map<String, Object> mp = new HashMap<String, Object>();
	private final static SingleAttribute att = new SingleAttribute();

	private SingleAttribute() {
	}

	public static SingleAttribute getClasz() {
		return att;
	}

	/**
	 * 将传进来的键值储存在Map里 param String，String return Map
	 * 
	 */
	public static void Add(String key, Object object) {
		mp.put(key, object);

	}

	/**
	 * 根据传进来的键来返回类的实例 param String key return Map
	 * 
	 * @param Object
	 * 
	 */

	public static Object getclass(String key) {

		return mp.get(key);

	}

}
