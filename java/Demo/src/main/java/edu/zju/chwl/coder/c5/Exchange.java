package edu.zju.chwl.coder.c5;

import org.junit.Test;

public class Exchange {
    public int exchangeOddEven(int x) {
        int even=((1<<30)-1)/3*2;
        int odd=((1<<31)-1)-even;              
        return ((x&even)>>1)+((x&odd)<<1);
    }
    
    public int exchangeOddEven1(int x) {            
        return ((x&0Xaaaaaaaa)>>1)+((x&0X55555555)<<1);
    }
    
    @Test
    public void test(){
    	System.out.println(exchangeOddEven(10));
    	System.out.println(exchangeOddEven(5));
    }
}
