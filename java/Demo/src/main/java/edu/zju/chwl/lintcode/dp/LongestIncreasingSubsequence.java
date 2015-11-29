package edu.zju.chwl.lintcode.dp;

import java.util.Arrays;

import edu.zju.chwl.util.Tools;

public class LongestIncreasingSubsequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tools.print(new LongestIncreasingSubsequence().longestIncreasingSubsequence(new int[]{4, 2, 4, 5, 3, 7}));
	}
	
	/**
	 * state: f[i] 以i结尾的递增子串的最大长度
	 * function: f[i]=MAX{f[j]+1},j<i && nums[j]<=nums[i]
	 * initialize: f[i]=1
	 * answer: max{f[i]}
	 * @param nums
	 * @return
	 */
    public int longestIncreasingSubsequence(int[] nums) {
        // write your code here
    	if(nums==null||nums.length==0){
    		return 0;
    	}
    	int len=nums.length;
    	int max=Integer.MIN_VALUE;
    	int[] results=new int[len];
    	Arrays.fill(results, 1);
    	for(int i=1;i<len;i++){
    		for(int j=0;j<i;j++){
    			if(nums[j]<=nums[i]){
    				results[i]=Math.max(results[i], results[j]+1);
    			}
    		}
    		Tools.print("f["+i+"]::"+results[i]);
    		max=max>results[i]?max:results[i];
    	}
    	return max;
    }

}
