package edu.zju.chwl.offer.skillsininterview;

import org.junit.*;

//两个数的和
public class SumOfN {


    
    public int sum(int n) {
        if(n==0){
        	return n;
        }
        return n+sum(n-1);
    }
    
    @Test
    public void test(){
    	Assert.assertEquals(15, sum(5));
    }
}

