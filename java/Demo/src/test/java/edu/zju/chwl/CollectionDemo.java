package edu.zju.chwl;



import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

public class CollectionDemo {

	@Test
	public void test() {
		//Map<String,String> hashMap=new Hashtable<String,String>();
		/*Page56.samename();
		
		double a=1.1;
		double b=1.2;
		
		System.out.println(a>b?a:b);*/
		String value="a\nb\nc";
		System.out.println(value);
		value=value.replaceAll("\n", "<br>");
		System.out.println(value);
		
		
		Integer[] array=new Integer[]{1,2,3,4};
		List<Integer> list=new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		/*for(int item:list){
			System.out.println(list);
			list.remove(item);
		}*/
		Iterator<Integer> ite=list.iterator();
		while(ite.hasNext()){
			System.out.println(list);
			int item=ite.next();
			ite.remove();
		}
	}

}
