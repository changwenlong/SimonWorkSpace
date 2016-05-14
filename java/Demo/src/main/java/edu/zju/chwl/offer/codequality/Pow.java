package edu.zju.chwl.offer.codequality;

import junit.framework.Assert;

import org.junit.Test;

/**
 * https://leetcode.com/problems/powx-n/
 * 
 * O(logn)
 * 
 * power(x,n)=power(x,n>>2)*power(x,n>>2); //n is odd
 * 
 * power(x,n)=power(x,n>>2)*power(x,n>>2)*x; //n is even
 * 
 * @author a590450
 * @date 21 Mar 2016 11:17:29
 */
public class Pow {
    public double myPow(double x, int n) {
        if(Double.compare(x, 1.0)==0){
        	return x;
        }
        boolean isNeg=n<0.0;
        boolean isMin = false;
        if(n==Integer.MIN_VALUE){
        	n=Integer.MAX_VALUE;
        	isMin=true;
        }
        double result = helper(x,Math.abs(n));
        if(isMin){
        	result*=x;
        }
        if(isNeg){
        	return 1.0/result;
        }
    	return result;
    }
    
    private double helper(double x, int n) {
    	if(n==0){
    		return 1.0;
    	}
    	int tmp =n;
		double value = helper(x,n>>1);
		value*=value;
		if((tmp&1)!=0){
			value*=x;
		}
		return value;
	}

	@Test
    public void powZero(){
    	Assert.assertEquals(0, Double.compare(0.0, myPow(0.0,3)));
    }
    
    @Test
    public void powZero1(){
    	Assert.assertEquals(0, Double.compare(1.0, myPow(-1.5,0)));
    }
    
    @Test
    public void powNegitive(){
    	Assert.assertEquals(0, Double.compare(0.5, myPow(2.0,-1)));
    }
    
    @Test
    public void pow(){
    	Assert.assertEquals(0, Double.compare(32.0, myPow(2.0,5)));
    }
}
