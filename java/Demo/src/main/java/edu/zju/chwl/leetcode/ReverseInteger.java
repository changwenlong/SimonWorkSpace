package edu.zju.chwl.leetcode;

/**
 * https://leetcode.com/problems/reverse-integer/
 * 
 * @author chwl
 * @Date 2016年2月23日 下午10:06:11
 */
public class ReverseInteger {

	public static void main(String[] args) {
		System.out.println(reverse(321));
		System.out.println(reverse(-2147483648));
		System.out.println(reverse(1534236469));
	}
	
	public static int reverse(int x) {
		int result=0;
		while(x!=0){
			//overflow
			if(result*10.0>Integer.MAX_VALUE||result*10.0<Integer.MIN_VALUE){
				result=0;
			}else{
				result = (result*10)+x%10;				
			}
			x/=10;
		}
		return result;
    }

}
