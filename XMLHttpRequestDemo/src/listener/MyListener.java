package listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class MyListener implements ServletRequestListener {

	@Override
	public void requestDestroyed(ServletRequestEvent event) {
		// TODO Auto-generated method stub
		System.out.println("请求结束");
	}

	@Override
	public void requestInitialized(ServletRequestEvent event) {
		// TODO Auto-generated method stub
		System.out.println("客户端开始请求");
		String path=event.getServletContext().getContextPath();
		System.out.println(path);
	}

	

}
