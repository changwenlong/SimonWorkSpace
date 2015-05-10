package edu.zju.chwl;

import org.junit.Test;

public class PageDemo {


	@Test
	public void testPage56() {
		Page56.samename();
	}
	
	@Test
	public void testPage57() {
		int age=24;
		StringBuilder name=new StringBuilder("chang");
		Page57 page=new Page57();
		page.setAge(age);
		page.setName(name);
		System.out.println("before changed:\n"+page);
		age=14;
		name.append(" wen long");
		System.out.println("after changed:\n"+page);
	}
	
	@Test
	public void testPage57Obj() {
		TestObj t=new TestObj();
		System.out.println("before changed:\n"+t.getObj());
		t.changeObj(t.getObj());
		System.out.println("after changed:\n"+t.getObj());
	}
	
	@Test
	public void testPage58() {
		Page58 a=new Page58();
		//使用=赋值
		Page58 b=a;
		b.changeAge();
		b.changeName();
		b.changeSex();
		System.out.println(a);
		System.out.println(b);
	}
	
	@Test
	public void testPage58Clone() {
		Page58 a=new Page58();
		//使用=赋值
		Page58 b=(Page58)a.clone();
		b.changeAge();
		b.changeName();
		b.changeSex();
		System.out.println(a);
		System.out.println(b);
	}
	
	@Test
	public void testSwap() {
		Integer a=new Integer("1");
		Integer b=new Integer("2");
		swap(a,b);
		System.out.println(a);
		System.out.println(b);
	}
	
	public void swap(Integer a,Integer b){
		Integer temp=a;
		a=b;
		b=temp;
	}
	
	@Test
	public void testPage101() {
	}

}
