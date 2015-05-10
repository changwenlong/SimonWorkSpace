package edu.zju.chwl;

public class Child extends Father {
	static{
		System.out.println("child static");
	}
	Child(){
		System.out.println("child constructor");
	}
	public void test(){
		System.out.println("child call");
	}
	public static void main(String[] args){
		Father child=new Child();
		child.test();
	}
}

class Father {
	static{
		System.out.println("father static");
	}
	Father(){
		System.out.println("father constructor");
	}
	public void test(){
		System.out.println("father call");
	}
}
