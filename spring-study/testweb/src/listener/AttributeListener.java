package listener;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;

public class AttributeListener implements ServletRequestAttributeListener {

	@Override
	public void attributeAdded(ServletRequestAttributeEvent event) {
		// TODO Auto-generated method stub
		String name = event.getName();
		Object obj = event.getSource();
		Object obj1 = event.getValue();
		System.out.println(name);
		System.out.println(obj);
		System.out.println(obj1);
	}

	@Override
	public void attributeRemoved(ServletRequestAttributeEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attributeReplaced(ServletRequestAttributeEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
