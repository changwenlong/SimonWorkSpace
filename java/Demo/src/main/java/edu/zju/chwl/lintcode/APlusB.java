package edu.zju.chwl.lintcode;

public class APlusB {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

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
