package edu.zju.chwl.coder.c9;

import junit.framework.Assert;

import org.junit.Test;

public class Coins {

	public int countWays(int n) {
		return makeChange(n, 25);
	}
	
	public int countWays1(int n) {
		int[] coins=new int[]{1,5,10,25};
        int[] dp = new int[100001];       
        dp[0] = 1;
        for(int i = 0;i < 4;++i){
            for(int j = coins[i];j <= n;++j){
                dp[j] =(dp[j]+dp[j-coins[i]])%1000000007;               
            }
        }
        return dp[n];
	}

	private int makeChange(int n, int deno) {
		int next_deno = 0;
		switch (deno) {
		case 25:
			next_deno = 10;
			break;
		case 10:
			next_deno = 5;
			break;
		case 5:
			next_deno = 1;
			break;
		case 1:
			return 1;
		}
		int ways=0;
		for(int i=0;deno*i<=n;i++){
			ways=ways+(makeChange(n-(i*deno),next_deno))%1000000007;
		}
		return ways;
	}
	
	@Test
	public void test(){
		Assert.assertEquals(242, countWays(100));
	}
}
