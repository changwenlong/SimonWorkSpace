package edu.zju.chwl.dynamicProxy;

import java.lang.reflect.Proxy;

public class ProxyFactory {

	public static Object getProxy(Object proxObj,LogHandler h){
		h.setProxObj(proxObj);
		Object o=Proxy.newProxyInstance(proxObj.getClass().getClassLoader(), 
				proxObj.getClass().getInterfaces(), h);		
		return o;
	}
	
	public static void main(String[] args){
		Calculator c=(Calculator)ProxyFactory.getProxy(new CalculatorImpl(), 
				new LogHandler());
		c.calculate(20, 1);
	}
}
