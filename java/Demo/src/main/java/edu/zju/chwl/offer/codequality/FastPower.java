package edu.zju.chwl.offer.codequality;

import junit.framework.Assert;

import org.junit.Test;

/**
 * http://www.lintcode.com/en/problem/fast-power/
 * @author chwl
 * @Date 2016年3月21日 下午11:41:11
 */
public class FastPower {
    public int fastPower(int a, int b, int n) {
    	//n>=0
        if(n==0){
            return 1%b;
        }
        if(n==1){
            return a%b;
        }
        long result = fastPower(a,b,n>>>1)%b;
        result=result*result%b;//result*result可能超过Integer大范围
        if((n&1)==1){
            result=result*a%b;
        }
        return (int)result;
    }
    
    @Test
    public void testPower(){
    	Assert.assertEquals(2, fastPower(2,3,31));
    	Assert.assertEquals(5249911, fastPower(109, 10000007, 1000001));
    }
}
