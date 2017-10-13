package com.zlyg.purchase.utils;

import java.io.StringReader;

import com.sdicons.json.mapper.JSONMapper;
import com.sdicons.json.mapper.MapperException;
import com.sdicons.json.model.JSONValue;
import com.sdicons.json.parser.JSONParser;

/**
 * @author lgj
 * 
 * 对象和json之间相互转换
 * 
 * @version 1.0 
 * 
 */
public class JsonUtils {

	/**
	 * 对象转换为json字符串
	 * 
	 * @param obj
	 * @return
	 */
	public static String objToJsonStr(Object obj) {
		JSONValue jsonV = null;
		try {
			jsonV = JSONMapper.toJSON(obj);
		} catch (MapperException e) {
			e.printStackTrace();
		}
		String jsonStr = jsonV.render(true);
		return jsonStr;
	}

	/**
	 * json字符串转换为指定类型的对象
	 * @param jsonStr
	 * @param classz
	 * @return
	 */
	public static Object jsonStrToObj(String jsonStr, Class<?> classz) {
		StringReader sr = new StringReader(jsonStr);
		JSONValue jsonV = null;
		JSONParser parser = new JSONParser(sr);

		try {
			jsonV = parser.nextValue();
			return JSONMapper.toJava(jsonV, classz);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
