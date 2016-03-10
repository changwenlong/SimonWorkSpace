package edu.zju.chwl.leetcode;

/**
 * https://leetcode.com/problems/palindrome-number/
 * @author a590450
 * @date 24 Feb 2016 17:28:15
 */
public class PalindromeNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(isPalindrome(121));
	}
	
	   public static boolean isPalindrome(int x) {
		   	int tmp =x;
	        if(x<0){
	            return false;
	        }
	        int res=0;
	        while(x!=0){
	            res = res*10+x%10;
	            x/=10;
	        }
	        System.out.println(res);
	        System.out.println(x);
	        if(res==tmp){
	            return true;  
	        }else{
	            return false;
	        }
	       
	    }

}
