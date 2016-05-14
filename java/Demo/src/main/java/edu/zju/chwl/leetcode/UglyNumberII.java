package edu.zju.chwl.leetcode;


/**
 * https://leetcode.com/problems/ugly-number-ii/
 * @author chwl
 * @Date 2016年3月6日 下午2:01:39
 */
public class UglyNumberII {

	public static void main(String[] args) {
		// System.out.println(kthPrimeNumber(1));

		System.out.println(nthPrimeNumber(3));

		System.out.println(nthPrimeNumber(599));

	}
	
	public static long nthPrimeNumber(int n) {
		if(n==1){
			return 1;
		}
		int[] dp = new int[n+1];
		dp[1]=1;
		int p2=1,p3=1,p5=1;
		for(int i=2;i<=n;i++){
			dp[i]=Math.min(Math.min(2*dp[p2],3*dp[p3]), 5*dp[p5]);
			if(dp[i]==2*dp[p2]){
				p2++;
			}
			if(dp[i]==3*dp[p3]){
				p3++;
			}
			if(dp[i]==5*dp[p5]){
				p5++;
			}
		}
		return dp[n];
	}
}
