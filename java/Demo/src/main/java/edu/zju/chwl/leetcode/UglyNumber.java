package edu.zju.chwl.leetcode;


/**
 * https://leetcode.com/problems/ugly-number/
 * @author chwl
 * @Date 2016年3月6日 下午2:01:39
 */
public class UglyNumber {

	public static void main(String[] args) {
	    System.out.println(isUgly(1));

		System.out.println(isUgly(3));
		
		System.out.println(isUgly(4));

	}

    public static boolean isUgly(int num) {
    	if(num==0){
    		return false;
    	}
        while(num!=1){
        	if(num%2!=0&&num%3!=0&&num%5!=0){
        		return false;
        	}
        	if(num%2==0){
        		num/=2;
        	}
        	if(num%3==0){
        		num/=3;
        	}
        	if(num%5==0){
        		num/=5;
        	}
        }
        return true;
    }
	
}
