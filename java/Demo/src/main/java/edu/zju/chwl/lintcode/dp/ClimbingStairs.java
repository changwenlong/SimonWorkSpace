package edu.zju.chwl.lintcode.dp;

import edu.zju.chwl.util.Tools;

public class ClimbingStairs {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Tools.print(new ClimbingStairs().climbStairs(3));

	}
	
    public int climbStairs(int n) {
        if(n<3){
        	return n;
        }
        int[] sum=new int[n+1];
        sum[1]=1;
        sum[2]=2;
        for(int i=3;i<n+1;i++){
        	sum[i]=sum[i-1]+sum[i-2];
        }
        return sum[n];
    }

}
