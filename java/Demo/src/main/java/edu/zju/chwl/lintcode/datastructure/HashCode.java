package edu.zju.chwl.lintcode.datastructure;

import org.junit.Test;

public class HashCode {
    public int hashCode(char[] key,int HASH_SIZE) {
        int len = key.length;
        long[] dp = new long[len];
        dp[0]=1;
        dp[1]=33%HASH_SIZE;
        for(int i=2;i<len;i++){
            dp[i]=(dp[i-1]*dp[1])%HASH_SIZE;
        }
        long ret = 0;
        for(int i=0;i<len;i++){
            ret =(ret+key[i]*dp[len-1-i])%HASH_SIZE;
        }
        return (int)(ret%HASH_SIZE);
    }
    
    @Test
    public void test(){
    	System.out.println(hashCode("Wrong answer or accepted?".toCharArray(), 1000000007));
    }
}
