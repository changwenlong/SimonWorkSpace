package edu.zju.chwl.leetcode;

import java.util.*;

import org.junit.*;

public class RepeatedDNASequences {

    public List<String> findRepeatedDnaSequences(String s) {
    	ArrayList<String> list = new ArrayList<String>();
        if(s==null||s.length()<11){
        	return list;
        }
        LinkedHashMap<String, Integer> map = new LinkedHashMap<String,Integer>();
        for(int i=0;i<=s.length()-10;i++){
        	String subStr = s.substring(i,i+10);
        	if(map.containsKey(subStr)){
        		map.put(subStr, map.get(subStr)+1);
        	}else{
        		map.put(subStr,1);
        	}
        }
        for(String str:map.keySet()){
        	if(map.get(str)>=2){
        		list.add(str);
        	}
        }
        return list;
    }
    
    @Test
    public void testFunc(){
    	Assert.assertEquals("[AAAAACCCCC, CCCCCAAAAA]", findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT").toString());
    }
}
