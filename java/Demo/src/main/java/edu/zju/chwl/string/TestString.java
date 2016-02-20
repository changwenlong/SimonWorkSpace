package edu.zju.chwl.string;

import edu.zju.chwl.util.Tools;

public class TestString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String a="abc";
		String b="abc";
		String c=new String("abc");
		String d=c.intern();
		String e="ab"+"c";
		Tools.println(a==b);
		Tools.println(a==c);
		Tools.println(a==d);
		Tools.println(a==e);
		testInteger();
	}
	
	public static void testInteger(){
		Integer a=127;
		Integer b=127;
		Integer c=new Integer(127);
		Integer d=Integer.valueOf(c);
		Tools.println(a==b);
		Tools.println(a==c);
		Tools.println(a==d);
	}

}
