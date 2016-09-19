package edu.zju.chwl.stack;

import java.util.*;
import java.util.concurrent.*;


public class InvokeStack {
	
	public static LinkedList<String> stack = new LinkedList<String>();

	public static void main(String[] args) {
		new InvokeStack().methodA();

	}

	public static String getMethodName() {
		StackTraceElement[] elements = Thread.currentThread().getStackTrace();
		StackTraceElement element = elements[2];
		String methodName = element.getClassName()+"."+element.getMethodName();		
		return methodName;
	}
	
	public void methodA(){
		stack.push(getMethodName());
		methodB();
		methodC();
		System.out.println(stack.pop());
	}
	
	public void methodB(){
		stack.push(getMethodName());
		methodD();
		System.out.println(stack.pop());
	}

	public void methodC(){
		stack.push(getMethodName());
		methodD();
		System.out.println(stack.pop());
	}

	public void methodD(){
		stack.push(getMethodName());
		sleepOneSec();
		System.out.println(stack.pop());
	}
	
	public void sleepOneSec(){
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
		}
	}

}
