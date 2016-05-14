package edu.zju.chwl.offer.thoughtofsolution;

import junit.framework.Assert;

import org.junit.Test;

/**
 * http://www.lintcode.com/en/problem/string-permutation/
 * @author chwl
 * @Date 2016年3月24日 下午10:49:33
 */
public class StringPermutation {

    public boolean stringPermutation(String a, String b) {
        if(a==null&&b==null){
        	return true;
        }else if(a==null||b==null){
        	return false;
        }
        if(a.length()!=b.length()){
        	return false;
        }
        int[] hash = new int[256];
        for(char ch:a.toCharArray()){
        	hash[ch]++;
        }
        for(char ch:b.toCharArray()){
        	if(--hash[ch]<0){
        		return false;
        	}
        }
        return true;
    }

	@Test
	public void testNull(){
		Assert.assertFalse(stringPermutation(null, ""));
		Assert.assertFalse(stringPermutation("",null));
		Assert.assertTrue(stringPermutation(null,null));
	}
	
	@Test
	public void testStringPermutation(){
		Assert.assertTrue(stringPermutation("abcd","bcad"));
		Assert.assertFalse(stringPermutation("abcd","baad"));
	}
	
	@Test
	public void testLengthNotEqual(){
		Assert.assertFalse(stringPermutation("abcd","bcade"));
	}
}
