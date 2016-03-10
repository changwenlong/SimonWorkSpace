package edu.zju.chwl.lintcode.datastructure;

/**
 * http://www.lintcode.com/en/problem/ugly-number/
 * 递归实现
 * @author chwl
 * @Date 2016年3月6日 下午2:01:39
 */
public class UglyNumber {

	public static void main(String[] args) {
	    System.out.println(dp(1));

		System.out.println(dp(3));

		System.out.println(dp(599));

	}

	
	public static long dp(int k) {
		long[] dp =new long[k+1];
		dp[0]=1;
		int p3=0,p5 =0,p7 =0;
		for(int i=1;i<=k;i++){
			dp[i]=Math.min(Math.min(3*dp[p3],5*dp[p5]), 7*dp[p7]);
			if(dp[i]==3*dp[p3]) p3++;
			if(dp[i]==5*dp[p5]) p5++;
			if(dp[i]==7*dp[p7]) p7++;
		}
		return dp[k];
	}
}
