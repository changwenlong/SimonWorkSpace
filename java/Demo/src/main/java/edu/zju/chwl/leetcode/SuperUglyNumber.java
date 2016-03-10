package edu.zju.chwl.leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/super-ugly-number/
 * 递归实现
 * @author chwl
 * @Date 2016年3月6日 下午3:01:42
 */
public class SuperUglyNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int nthSuperUglyNumber(int n, int[] primes) {
        if(n==1) return 1;
        int[] dp =new int[n+1];
        dp[1]=1;
        int len=primes.length;
        int[] ps= new int[len];
        Arrays.fill(ps, 1);
        for(int i=2;i<=n;i++){
        	dp[i]=getMin(primes,ps,dp);
        }
        return dp[n];
    }

	private int getMin(int[] primes, int[] ps,int[] dp) {
		int min = Integer.MAX_VALUE;
		for(int i=0;i<primes.length;i++){
			if(primes[i]*dp[ps[i]]<min){
				min=primes[i]*dp[ps[i]];
			}
		}
		//所有最小值位置都必须加1
		for(int i=0;i<primes.length;i++){
			if(primes[i]*dp[ps[i]]==min){
				ps[i]++;
			}
		}
		return min;
	}

}
