package edu.zju.chwl.map;

import java.util.HashMap;

import org.junit.Test;

public class TestHashMap {

		@Test
		public void test() {
			HashMap<String, Student> hashMap = new HashMap<String,Student>();
			Student stu=new Student("tom",26);
			hashMap.put("tom", stu);
			HashMap<String, String> cloneHashMap=(HashMap<String, String>) hashMap.clone();
			stu.setName("tony");
			System.out.println("hashMap:"+hashMap);
			System.out.println("cloneHashMap:"+cloneHashMap);
		}
		
		class Student{
			private String name;
			private int age;
			
			Student(String name,int age){
				this.name=name;
				this.age=age;
			}
			
			public void setName(String name){
				this.name=name;
			}
			
			@Override
			public String toString(){
				return "name:"+name+",age:"+age;
			}
			
		}
}
