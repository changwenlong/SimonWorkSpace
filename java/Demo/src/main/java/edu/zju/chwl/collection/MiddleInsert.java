package edu.zju.chwl.collection;

import java.util.*;

public class MiddleInsert {
	public static void main(String[] args){
		ArrayList<Integer> arrayList=new ArrayList<Integer>();
		LinkedList<Integer> linkedList=new LinkedList<Integer>();
		long a,b;
		

		a=System.currentTimeMillis();
		for(int i=0;i<20000;i+=2){
			linkedList.add(0,i);
			linkedList.add(0,i+1);
		}
		b=System.currentTimeMillis()-a;
		//System.out.println(linkedList);
		System.out.println("LinkedList times:"+b+"ms");
		
		a=System.currentTimeMillis();
		for(int i=0;i<20000;i+=2){
			arrayList.add(0,i);
			arrayList.add(0,i+1);
		}
		b=System.currentTimeMillis()-a;
		//System.out.println(arrayList);
		System.out.println("ArrayList times:"+b+"ms");
	}
}
