package edu.zju.chwl.coder.c1;

import java.util.Arrays;

import org.junit.*;

public class CheckDifferent {

	/**
	 * 借助散列表
	 * @param iniString
	 * @return
	 */
    public boolean checkDifferent(String iniString) {
    	if(iniString.length()>256){
    		return false;
    	}
        boolean[] hash=new boolean[256];
        Arrays.fill(hash, false);
        for(int i=0;i<iniString.length();i++){
        	if(hash[iniString.charAt(i)]){
        		return false;
        	}
        	hash[iniString.charAt(i)]=true;
        }
        return true;
    }
    
    /**
     * 使用位运算 空间使用为原来的1/8 
     * @param iniString 假设只有A-Z
     * @return
     */
    public boolean checkDifferent1(String str) {
    	if(str.length()>256){
    		return false;
    	}
        int checker=0;
        for(int i=0;i<str.length();i++){
        	int val = str.charAt(i)-'a';
        	if(((1<<val)&checker)!=0){
        		return false;
        	}
        	checker|=(1<<val);
        }
        return true;
    }
    
    @Test
    public void testCheckDifferent(){
    	Assert.assertFalse(checkDifferent("acbdbesy"));
    	Assert.assertTrue(checkDifferent("aeiou"));
    }
    
    @Test
    public void testCheckDifferent1(){
    	Assert.assertFalse(checkDifferent1("BarackObama"));
    	Assert.assertTrue(checkDifferent1("aeiou"));
    }
}
