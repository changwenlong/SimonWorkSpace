package edu.zju.chwl.java8.lambda;

import java.util.*;

import org.junit.Test;
/**
 * java7实现 jdk1.7
 * @author chwl
 * @Date 2016年7月17日 上午11:15:52
 */
public class ListDemo1 {
	//ArrayList<Integer> addList = new ArrayList<Integer>();
	
	@Test
	public void test() {
		ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(new Integer[]{10,2,3,4,5}));
		final ArrayList<Integer> addList = new ArrayList<Integer>();
		forEach(list,new Consumer<Integer>() {
			@Override
			public void accept(Integer i) {
				/*
				 * java7中，匿名内部类中访问局部变量addList需要加final;
				 * 但若addList定义为外围类的变量，则无需加final，因为内部类本身都会含有一个外围了的引用（外围类.this）				
				 */
				addList.add(i+10);//
			}
		});
		System.out.println(addList);
	}

	private static void forEach(ArrayList<Integer> list, Consumer<Integer> consumer) {
		for(int i:list){
			consumer.accept(i);
		}		
	}
}

interface Consumer<T>{
	void accept(T t);
}
