package edu.zju.chwl.interview;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
/**
 * 知道spring中的AOP吗？
 * 使用了什么设计模式？
 * java实现动态代理，用那两个类可实现动态代理；
 * 实现简单的动态代理。
 */
public class DynamicProxy implements InvocationHandler{
	private Object proxy;
	public DynamicProxy(Object proxy) {
		this.proxy=proxy;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		beforeMethod();
		Object obj=method.invoke(this.proxy, args);
		afterMethod();
		return obj;
	}
	
	public void beforeMethod(){
		System.out.println("print before method");
	}
	
	public void afterMethod(){
		System.out.println("print after method");
	}
	
	public static void main(String[] args) {
		Calculator cal=new CalculatorImpl();
		Calculator proxy=(Calculator)Proxy.newProxyInstance(cal.getClass().getClassLoader(),
				cal.getClass().getInterfaces(), new DynamicProxy(cal));
		proxy.calculate(4,2);
	}

}

interface Calculator {
    public int calculate( int a , int b);
}

class CalculatorImpl implements Calculator{
	@Override
	public int calculate(int a, int b) {
		int result=a/b;
		System.out.println("a/b="+result);
		return result;
	}
	
}
