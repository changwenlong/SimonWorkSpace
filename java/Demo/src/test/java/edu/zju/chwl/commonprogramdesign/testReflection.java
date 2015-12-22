package edu.zju.chwl.commonprogramdesign;

import java.util.Collections;
import java.util.Set;

import org.junit.Test;

public class testReflection {

	@Test
	public void test() {
		Class<?> clazz = null;
		String[] strs=new String[]{"1","1","3","5","4","2"};
		try {
			clazz=Class.forName("java.util.TreeSet");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Set<String> s = null;
		try {
			s=(Set<String>) clazz.newInstance();
			Collections.addAll(s, strs);
			System.out.println(s);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}

}
