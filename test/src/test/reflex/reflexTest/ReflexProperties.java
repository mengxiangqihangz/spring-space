package test.reflex.reflexTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ReflexProperties {

	private Map<String, Object> mp = new HashMap<>();

	public Object newIns(String claszz) throws InstantiationException,
			IllegalAccessException, ClassNotFoundException {

		Class<?> csz = Class.forName(claszz);

		return csz.newInstance();
	}

	public void init(String fileName) throws Exception {
		Properties pts = new Properties();
		FileInputStream input = new FileInputStream(fileName);
		pts.load(input);
		for (String name : pts.stringPropertyNames()) {
			mp.put(name, newIns(name));

		}

	}

	public Object getObj(String name) {
		return mp.get(name);

	}
	
	
	public static void main(String[] args) throws Exception {
		
		
		ReflexProperties instance=new ReflexProperties();
		instance.init("oba.txt");
		System.out.println(instance.getObj("name"));
		
	}

}
