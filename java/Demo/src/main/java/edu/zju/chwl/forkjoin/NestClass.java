package edu.zju.chwl.forkjoin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class NestClass {
	
	public StringBuilder ss = new StringBuilder();
	
	public void func(){
		class LocalNestClass{
			public void nestFunc(){
				System.out.println(ss);
			}
		}
		
		LocalNestClass localNestClass = new LocalNestClass();
		localNestClass.nestFunc();
	}
	
	public void func1(){
		StringBuilder sb = new StringBuilder();
		class LocalNestClass{
			public void nestFunc(){
				System.out.println(sb);
			}
		}
		sb.append("func1");
		LocalNestClass localNestClass = new LocalNestClass();
		localNestClass.nestFunc();
	}
	
	public void func2(){
		StringBuilder sb = new StringBuilder();
		
		Collections.sort(new ArrayList<Integer>(),new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				sb.append("compare");
				return 0;
			}
		});
		System.out.println(sb);
	}
	
	public static void main(String[] args) {
		NestClass nestClass = new NestClass();
		nestClass.ss.append("string build");
		nestClass.func();
		nestClass.func1();
		nestClass.func2();
	}
	
}
