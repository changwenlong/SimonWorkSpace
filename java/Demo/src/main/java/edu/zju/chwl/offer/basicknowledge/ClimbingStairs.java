package edu.zju.chwl.offer.basicknowledge;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * https://leetcode.com/problems/climbing-stairs/
 * dp
 * @author a590450
 * @date 15 Mar 2016 17:50:23
 */
public class ClimbingStairs {

    public int climbStairs(int n) {
        if(n<3){
        	return n;
        }
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3;i<=n;i++){
        	dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
    
    @Test
    public void zeroStair(){
    	assertEquals(0, climbStairs(0));
    }
    
    @Test
    public void oneStair(){
    	assertEquals(1, climbStairs(1));
    }
    
    @Test
    public void twoStair(){
    	assertEquals(2, climbStairs(2));
    }
    
    @Test
    public void treeStair(){
    	assertEquals(3, climbStairs(3));
    }
}
