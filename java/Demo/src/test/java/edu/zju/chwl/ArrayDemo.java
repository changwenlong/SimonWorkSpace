package edu.zju.chwl;

import java.util.Arrays;

import org.junit.Test;

public class ArrayDemo {

	@Test
	public void test() {
		int[] intArr=new int[]{1,2};
		int[] copyArr=Arrays.copyOf(intArr, 2);
		System.out.println(copyArr.length);
		
	}
	
	@Test
	public void test1() {
		getStr();
	}

	public String getStr(){
		try{
			return func();
		}finally{
			System.out.println("finally");
		}
	}

	private String func() {
		String a = "func";
		System.out.println(a);
		return a;
	}
}
