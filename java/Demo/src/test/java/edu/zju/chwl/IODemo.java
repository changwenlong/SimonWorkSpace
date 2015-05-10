package edu.zju.chwl;


import java.io.*;
import java.util.*;

import org.junit.Test;

public class IODemo {

	@Test
	public void test() {
		File path=new File(".");
		System.out.println(path.getName());
	}
	
	public void getRandom(){
		Random r=new Random();
		Set<Integer> set=new HashSet<Integer>();
		while(set.size()<900){
			set.add(r.nextInt(1001));
		}
		System.out.println(set);
	}
	
	

}
