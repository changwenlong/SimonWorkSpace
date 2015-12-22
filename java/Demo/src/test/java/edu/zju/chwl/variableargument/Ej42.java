package edu.zju.chwl.variableargument;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class Ej42 {

	@Test
	public void test() {
		System.out.println(Arrays.asList(new int[]{1,2}));
		System.out.println(Arrays.asList(1,2));
		System.out.println((Arrays.asList(new Integer[]{1,2}) instanceof List<?>));
	}

	public static <T> List<T> gather(T... args){
		return Arrays.asList(args);
	}
	
	@Test
	public void test2() {
		System.out.println(gather(new Integer[]{1,2}));
	}
	
	@Test
	public void testCollectionsAddAll() {
		List<Integer> list=new ArrayList<Integer>();
		list.add(1);
		System.out.println(Collections.addAll(list,new Integer[]{1,2})+""+list);
	}
	
	public static List<Integer> asList(int...args){
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		for(int arg:args){
			arrayList.add(arg);
		}
		return arrayList;
	}
	
	@Test
	public void testAsList() {
		System.out.println(asList(new int[]{1,2}));
	}
}
