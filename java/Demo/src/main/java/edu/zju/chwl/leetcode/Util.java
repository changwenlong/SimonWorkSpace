package edu.zju.chwl.leetcode;

public class Util {

    public static boolean[][] getPalindromeArr(String s){
    	int len = s.length();
    	char[] charArr=s.toCharArray();
    	boolean[][] palindrome=new boolean[len][len];
    	for(int i=0;i<len;i++){
    		palindrome[i][i]=true;
    	}
    	for(int i =len-2;i>=0;i--){
    		for(int j=i+1;j<len;j++){
    			if(charArr[i]==charArr[j]){
    				if((i+1>=j-1)||palindrome[i+1][j-1]){
    					palindrome[i][j]=true;
    				}
    			}
    		}
    	}
    	return palindrome;
    }
}
