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
		
		//1. ��ȡ application ��Ӧ�� Map ����
		Map<String, Object> applicationMap = ActionContext.getContext().getApplication();
		applicationMap.put("applicationKey", "applicationValue");
		
		//2. ��ȡ session ��Ӧ�� Map ����
		Map<String, Object> sessionMap = ActionContext.getContext().getSession();
		sessionMap.put("sessionKey", "sessionValue");
		
		/**
		 * ���԰� HttpSession ��Ӧ�� Map ����ǿתΪ SessionMap ����
		 * ���Ե��� SessionMap �� invalidate() �������� HttpSession ����
		 */
		if(sessionMap instanceof SessionMap){
			SessionMap<String, Object> sp = (SessionMap<String, Object>) sessionMap;
			sp.invalidate();
		}
		
		//3. ��ȡ request ��Ӧ�� Map ����
		/**
		 * public Object get(Object key): 
		 * ActionContext ����û���ṩ���� getRequest() 
		 * �����ķ�������ȡ HttpServletRequest ��Ӧ�� Map ����. 
		 * Ҫ�õ� HttpServletRequest ��Ӧ�� Map ����, ����ͨ��Ϊ get() �������� ��request�� ����ʵ��
		 */
		ActionContext actionContext = ActionContext.getContext();
		
		Map<String, Object> requestMap = (Map<String, Object>) actionContext.get("request");
		requestMap.put("requestKey", "requestValue");
		
		//4. ��ȡ request ���������Ӧ�� Map ����
		Map<String, Object> parameterMap = 
				ActionContext.getContext().getParameters();
		String [] values = (String[]) parameterMap.get("name");
		System.out.println("name: " + values[0]);  
		
		return "success";
	}
	
}
