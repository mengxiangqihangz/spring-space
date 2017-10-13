package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertieUtil {
	
	private static Properties pro;
	
	public PropertieUtil(){
		if(pro==null){
			pro = new Properties();
		}
	}
	
	private Properties getInstance(String path){
		try {
			pro.load(new FileInputStream(path));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return pro;
	}

	public static String getValue(String path,String key){
		PropertieUtil proUtil = new PropertieUtil();
		pro=proUtil.getInstance(path);
		String value=pro.getProperty(key);
		return value;
	}
}
