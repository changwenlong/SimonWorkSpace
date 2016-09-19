package edu.zju.chwl.wangyi;

class X{
	Y y = new Y();
	X(){
		System.out.print("X");
	}
}

class Y{
	Y(){
		System.out.print("Y");
	}
}

public class Z extends X{
	Y y = new Y();
	public Z(){
		System.out.print("Z");
	}
	public static void main(String[] args) {
		Z z = new Z();
		Integer a = new Integer(1);
		Integer b = new Integer(1);
		System.out.println();
		System.out.println(a==b);
		a=1;b=1;
		System.out.println(a==b);
		final byte c=1,d=2,e;
		short f;
		f=c+d;
	}
}
