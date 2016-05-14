package edu.zju.chwl.coder.c1;

import org.junit.*;

public class ZipString {
	
    public String zipString(String str) {
        StringBuilder sb = new StringBuilder();
        char val = str.charAt(0);
        sb.append(val);
        int count=1;
        for(int i=1;i<str.length();i++){
        	char ch = str.charAt(i);
			if(ch!=val){
        		sb.append(count).append(ch);
        		val=ch;
        		count=1;
        	}else{
        		count++;
        	}
        }
        sb.append(count);
        String retStr = sb.toString();
		return retStr.length()>str.length()?str:retStr;
    }
    
    @Test
    public void test(){
    	Assert.assertEquals("a2b1c5a3", zipString("aabcccccaaa"));
    	Assert.assertEquals("welcometonowcoderrrrr", zipString("welcometonowcoderrrrr"));
    }
}
