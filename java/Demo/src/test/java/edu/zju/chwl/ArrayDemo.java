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

}
