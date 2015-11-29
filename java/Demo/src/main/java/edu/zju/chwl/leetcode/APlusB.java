package edu.zju.chwl.leetcode;

public class APlusB {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a=5,b=7;

	}

	public static int aplusb(int a, int b) {
		// write your code here, try to do it without arithmetic operators.
		int c=(a&b)<<1;
		int d=a^b;
		if((c&d)==0){
			return c|d;
		}else{
			return aplusb(c,d);
		}
	}
	


}
