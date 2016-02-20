package edu.zju.chwl.leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/palindrome-partitioning-ii/
 * @author a590450
 * @date 19 Feb 2016 16:26:08
 */
public class PalindromePartitioningII {
	
	public static void main(String[] args){
		PalindromePartitioningII p = new PalindromePartitioningII();
		System.out.println(p.minCut("aabcdcb"));
	}

    public int minCut(String s) {
        if(s==null||s.isEmpty()){
        	return 0;
        }
        int len=s.length()+1;
        int[] dp=new int[len];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0]=-1;dp[1]=0;
        
        //创建二维数组 标识子串是否为回文串
        boolean[][] isPalindrome=new boolean[len][len];
        for(int i=0;i<len;i++){
    		isPalindrome[i][i]=true;
    	}
        for(int i=len-2;i>=0;i--){
    		for(int j=i+1;j<len-1;j++){
    			if(s.charAt(i)==s.charAt(j)){
    				if((j-1<=i+1)||isPalindrome[i+1][j-1]){
    					isPalindrome[i][j]=true;
    				}
    			}else{
    				isPalindrome[i][j]=false;
    			}
    		}
    	}
        
        for(int i=2;i<len;i++){
        	for(int j=0;j<i;j++){
        		if(isPalindrome[j][i-1]){
        			dp[i]=Math.min(dp[i], dp[j]+1);
        		}
        	}
        }
        return dp[len-1];
        
    }

    /**
     * 若使用isPalindrome函数 leetcode上会出现超时现象
     * @param s
     * @return
     */
    public boolean isPalindrome(String s){    	
    	int len=s.length();
        for(int i=0;i<len/2;i++){
        	if(s.charAt(i)!=s.charAt(len-1-i)){
        		return false;
        	}
        }
        return true;
    }
}
