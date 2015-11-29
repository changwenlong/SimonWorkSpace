package edu.zju.chwl.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LogHandler implements InvocationHandler {

	private Object proxObj;

	public void doBefore(){
		System.out.println("Handling before actual method execution ........");
	}
	
	public void doAfter(){
		System.out.println("Handling after actual method execution ........");
	}
	
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Exception {
		this.doBefore();
		Object o=method.invoke(proxObj, args);
		this.doAfter();
		return o;
	}

	public Object getProxObj() {
		return proxObj;
	}

	public void setProxObj(Object proxObj) {
		this.proxObj = proxObj;
	}

}
