package edu.zju.chwl.leetcode;

import java.math.BigInteger;
import java.util.Arrays;

import org.junit.*;

/**
 * https://leetcode.com/problems/super-ugly-number/
 * 递归实现
 * @author chwl
 * @Date 2016年3月6日 下午3:01:42
 */
public class SuperUglyNumber {
	
    public BigInteger nthSuperUglyNumber(int n, int[] primes) {
        if(n==1) return BigInteger.ONE;
        BigInteger[] dp =new BigInteger[n+1];
        dp[1]=BigInteger.ONE;
        int len=primes.length;
        int[] ps= new int[len];
        Arrays.fill(ps, 1);
        for(int i=2;i<=n;i++){
        	dp[i]=getMin(primes,ps,dp);
        }
        return dp[n];
    }

	private BigInteger getMin(int[] primes, int[] ps,BigInteger[] dp) {
		BigInteger min = dp[ps[0]].multiply(BigInteger.valueOf(primes[0]));
		for(int i=1;i<primes.length;i++){
			BigInteger res = dp[ps[i]].multiply(BigInteger.valueOf(primes[i]));
			if(res.compareTo(min)<0){
				min=res;
			}
		}
		//所有最小值位置都必须加1
		for(int i=0;i<primes.length;i++){
			BigInteger res = dp[ps[i]].multiply(BigInteger.valueOf(primes[i]));
			if(res.compareTo(min)==0){
				ps[i]++;
			}
		}
		return min;
	}
	
	@Test
	public void test(){
		for(int i=1;i<2335;i++){
			System.out.println(i+":"+nthSuperUglyNumber(i+1,new int[]{2,3}));;
		}
	}
	
	@Test
	public void test1(){
		int count=1;
		for(int i=2;i<4000;i++){
			if(i%2==0||i%3==0){
				System.out.println(count+":"+i);
				count++;
			}
		}
	}

}
