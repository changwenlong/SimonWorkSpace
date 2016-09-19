package edu.zju.chwl.tencent;

import java.util.*;

import org.junit.Test;

public class GrayCode {
    public String[] getGray(int n) {
        int size = 1<<n;
        String[] strs = new String[size];
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
        	sb.append("0");
        }
        strs[0]=sb.toString();
        HashMap<String, Boolean> map = new HashMap<String,Boolean>();
        map.put(strs[0], true);
        for(int i=1;i<size;i++){
        	strs[i]=getNext(map,strs[i-1],n);
        }
        return strs;
    }
    
    public String getNext(Map<String,Boolean> map,String str,int n){
    	for(int i=n-1;i>=0;i--){
    		char[] chars = str.toCharArray();
    		chars[i]=(chars[i]=='0')?'1':'0';
    		String s = new String(chars);
    		if(map.get(s)==null){
    			map.put(s, true);
    			return s;
    		}
    	}
    	return null;
    }
    
    @Test
    public void test(){
    	String[] gray = getGray(2);
    	System.out.println(gray);
    }
}
