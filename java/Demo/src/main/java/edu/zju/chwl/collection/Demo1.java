package edu.zju.chwl.collection;

import java.util.*;

public class Demo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list1=Arrays.<Integer>asList(1,2,3,4,5);
		list1.set(1,99);
		System.out.println(list1);
		List<Integer> list2=new LinkedList<Integer>(Arrays.asList(1,2,3,4,5));
		list2.add(2,33);
		System.out.println(list2);
	}

}
