package net.lampbrother.app;

import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


public class TestActionContext extends ActionSupport{

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	@Override
	public String execute() throws Exception {
		
		//1. 获取 application 对应的 Map 对象
		Map<String, Object> applicationMap = ActionContext.getContext().getApplication();
		applicationMap.put("applicationKey", "applicationValue");
		
		//2. 获取 session 对应的 Map 对象
		Map<String, Object> sessionMap = ActionContext.getContext().getSession();
		sessionMap.put("sessionKey", "sessionValue");
		
		/**
		 * 可以把 HttpSession 对应的 Map 对象强转为 SessionMap 对象
		 * 可以调用 SessionMap 的 invalidate() 方法销毁 HttpSession 对象
		 */
		if(sessionMap instanceof SessionMap){
			SessionMap<String, Object> sp = (SessionMap<String, Object>) sessionMap;
			sp.invalidate();
		}
		
		//3. 获取 request 对应的 Map 对象
		/**
		 * public Object get(Object key): 
		 * ActionContext 类中没有提供类似 getRequest() 
		 * 这样的方法来获取 HttpServletRequest 对应的 Map 对象. 
		 * 要得到 HttpServletRequest 对应的 Map 对象, 可以通过为 get() 方法传递 “request” 参数实现
		 */
		ActionContext actionContext = ActionContext.getContext();
		
		Map<String, Object> requestMap = (Map<String, Object>) actionContext.get("request");
		requestMap.put("requestKey", "requestValue");
		
		//4. 获取 request 请求参数对应的 Map 对象
		Map<String, Object> parameterMap = 
				ActionContext.getContext().getParameters();
		String [] values = (String[]) parameterMap.get("name");
		System.out.println("name: " + values[0]);  
		
		return "success";
	}
	
}
