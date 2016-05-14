package edu.zju.chwl.coder.c1;

import java.util.Arrays;

import org.junit.*;

public class CheckSam {
    public boolean checkSam(String str1, String str2) {
        if(str1==null||str2==null){
        	if(str1==str2) return true;
        	return false;
        }
        if(str1.length()!=str2.length()){
        	return false;
        }
        return sort(str1).equals(sort(str2));
    }
    
    public String sort(String str){
    	char[] content = str.toCharArray();
		Arrays.sort(content);
    	return new String(content);
    }
    
    @Test
    public void testCheckSam(){
    	Assert.assertTrue(checkSam("This is nowcoder", "is This nowcoder"));
    	Assert.assertFalse(checkSam("Here you are	", "Are you here"));
    }
}
