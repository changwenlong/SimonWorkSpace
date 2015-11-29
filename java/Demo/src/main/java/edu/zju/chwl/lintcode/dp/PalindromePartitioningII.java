package edu.zju.chwl.lintcode.dp;

import java.util.Arrays;

import edu.zju.chwl.util.Tools;

public class PalindromePartitioningII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Tools.print(new PalindromePartitioningII().minCut("aacbbb"));

	}
	
	/**
	 * state: f[i] "前i"个字符组成的字符串最少切f[i]刀，切下的所有子串都是回文串
	 * function: f[i]=MIN{f[j]}+1,j<i && j~i-1是回文串
	 * initialize： f[0]=-1,f[1]=0
	 * answer: f[s.length()]
	 * @param s
	 * @return
	 */
    public int minCut(String s) {
    	if(s==null||s.length()<2){
    		return 0;
    	}
    	int len=s.length();
    	int[] results=new int[len+1];
    	results[0]=-1;
    	results[1]=0;
    	Arrays.fill(results, 2, len+1, Integer.MAX_VALUE);
    	for(int i=2;i<=len;i++){
    		for(int j=0;j<i;j++){
    			if(isPalindrome(s.substring(j, i))){
        			results[i]=Math.min(results[j]+1, results[i]);
    			}
    		}
    		//Tools.print(i+"::"+results[i]);
    	}
        return results[len];
        
    }

	private boolean isPalindrome(String substring) {
		char[] charArr=substring.toCharArray();
		for(int i=0;i<charArr.length/2;i++){
			if(charArr[i]!=charArr[charArr.length-1-i]){
				return false;
			}
		}
		return true;
	}

}
