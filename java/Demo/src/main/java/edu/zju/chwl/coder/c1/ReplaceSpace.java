package edu.zju.chwl.coder.c1;

import org.junit.*;

public class ReplaceSpace {
    public String replaceSpace(String str, int length) {
        int size = 0;
        for(int i=0;i<length;i++){
        	if(str.charAt(i)==' '){
        		size+=2;
        	}
        }
        //增加长度
        char[] content = new char[length+size];
        System.arraycopy(str.toCharArray(), 0, content, 0, length);
        int count=0;
        for(int i=length-1;i>=0;i--){
        	int pos=i+size-2*count;
        	if(content[i]==' '){
        		content[pos]='0';
        		content[pos-1]='2';
        		content[pos-2]='%';
        		count++;
        	}else{
        		content[pos]=content[i];
        	}       	
        }
        return new String(content);
    }
    
    @Test
    public void test(){
    	Assert.assertEquals("Mr%20John%20Smith",replaceSpace("Mr John Smith", 13));
    }
}
