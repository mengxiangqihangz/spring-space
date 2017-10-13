package com.Dom4j;

import java.io.File;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Dom {

	static {

		File file = new File("WebContent/WEB-INF/NewFile.xml");
		SAXReader reader = new SAXReader();
		Document document = null;
		try {
			document = reader.read(file);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 读取该XML
		Element root = document.getRootElement(); // 获取根节点的屬性

		List<Element> ChildElements = root.elements(); // 子節點
		for (Element children : ChildElements) { // 遍歷

			List<Attribute> attributes = children.attributes(); // 獲取子屬性對象
			for (Attribute attr : attributes) {
				//System.out.println(attr.getName() + "  " + attr.getValue());
				try {
					domj(attr.getName(), attr.getValue());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	/**
	 * 反射获取类的信息
	 * 
	 */
	public static void domj(String key, String vaule) throws Exception {
		Class<?> clasz = Class.forName(vaule);
		SingleAttribute.Add(key, clasz.newInstance());

	}

}
