package edu.zju.chwl.finaldemo;

import java.util.*;

import org.junit.Test;

public final class FinalDemo {//final类不可被继承
	public static final List<Integer> classList = new ArrayList<Integer>();//不可修改，要么在静态代码块中初始化,要么直接初始化
	public final List<Integer> instanceList = new ArrayList<Integer>();//不可修改，要么在构造代码块中初始化,要么构造函数中初始化，要么直接初始化
	
	public final void finalFunc(){//final方法在子类中不可被覆盖
		System.out.println("final function");
	}
	
	public static final void staticFinalFunc(){
		System.out.println("static final function");
	}
	
	public void func(final List<Integer> finalList){//final形参
		final List<Integer> list = new ArrayList<Integer>(finalList);//final局部变量
		list.add(4);
		System.out.println(list);
	}
	
	@Test
	public void test(){
		finalFunc();
		staticFinalFunc();
		func(new ArrayList<Integer>(Arrays.asList(new Integer[]{1,2,3})));
	}
}
