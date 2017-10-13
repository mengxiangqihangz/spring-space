package test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Protocol implements InvocationHandler {
	private Object obj;

	private void inform() {
		System.out.println("底下的傻逼就知道买买买");
	}

	public Object bind(Object object) {
		this.obj = object;
		return Proxy.newProxyInstance(object.getClass().getClassLoader(),
				object.getClass().getInterfaces(), this);
	}

	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		inform();
		Object result=null;
		result=method.invoke(obj, args);
		return result;
	}

}
