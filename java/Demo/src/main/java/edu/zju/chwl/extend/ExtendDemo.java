package edu.zju.chwl.extend;

public class ExtendDemo{
	public static void main(String[] args){
		Fu fu=new Zi();
		fu.func();
	}
}

//子类不能重写父类的静态方法
class Zi extends Fu{
	public static void func(){
		System.out.println("zi func");
	}
}

class Fu{
	public static void func(){
		System.out.println("fu func");
	}
}
