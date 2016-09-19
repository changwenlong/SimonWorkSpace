package edu.zju.chwl.java8.lambda;

import java.util.*;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

/**
 * java8新特性 jdk1.8
 * @author chwl
 * @Date 2016年7月17日 上午11:10:56
 */
public class ListDemo {

	@Test
	public void testLambda(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(new Integer[]{10,2,3,4,5}));
		ArrayList<Integer> addList = new ArrayList<Integer>();
		list.forEach(i->{
			addList.add(i+10);
			//addList=null;
			});//lambda表达式实现
		/*list.forEach(new Consumer<Integer>() {
			@Override
			public void accept(Integer i) {
				addList.add(i+10);//java8中，匿名内部类中访问局部变量addList不需要加final		
			}
		});*/
		System.out.println(addList);
	}
	
	@Test
	public void testRunnable() throws InterruptedException{
		ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(new Integer[]{10,2,3,4,5}));
		Thread t = new Thread(new Runnable(){
			@Override
			public void run() {
				try {
					TimeUnit.SECONDS.sleep(2);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				list.add(1);//java8中，匿名内部类中访问局部变量list不需要加final		
				System.out.println(list);
			}			
		});
		t.start();
		t.join();
		System.out.println(list);
	}

}
