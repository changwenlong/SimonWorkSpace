package edu.zju.chwl.jvm;


public class JvmStack {
	public static void main(String[] args) {
		try {
			recursion();
		} catch (Throwable e) {
			System.out.println("deep of stack is "+count);
			e.printStackTrace();
		}
	}
	
	static int count=0;
	
	public static void recursion(){
		count++;
		recursion();
	}
}
