package edu.zju.chwl.jingdong;

import org.junit.Test;

public class GoUpstairs {
	public int countWays(int n) {
        if(n<=3){
            return n-1;
        }
        long[] dp=new long[n+1];
        dp[1]=0;
        dp[2]=1;
        dp[3]=2;
        for(int i=4;i<=n;i++){
            dp[i]=(dp[i-1]+dp[i-2])%1000000007;
        }
        return (int)dp[n];
    }
	
	@Test
	public void test(){
		System.out.println(countWays(88));
	}
}
