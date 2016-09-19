package edu.zju.chwl.coder.c18;

import java.util.*;
import java.util.Map.Entry;

import org.junit.Test;

public class LongestString {
    public int getLongest(String[] str, int n) {
        TreeMap<Integer,TreeSet<String>> map = process(str);
        ArrayList<Entry<Integer, TreeSet<String>>> entrys = new ArrayList<Entry<Integer, TreeSet<String>>>(map.entrySet());
        for(int i=entrys.size()-1;i>=0;i--){
        	Entry<Integer, TreeSet<String>> entry = entrys.get(i);
        	for(String item:entry.getValue()){
        		Integer key = entry.getKey();
				dfs(item,key-1,map);
        		if(flag)
        			return key;
        	}
        }
        return -1;
    }
    
    boolean flag = false;
    private void dfs(String str, int n, TreeMap<Integer,TreeSet<String>> map){
    	if(flag)
    		return;
    	if(n==0){
    		flag=true;
    	}
    	for(int i=1;i<=n;i++){
    		TreeSet<String> set = map.get(i);
    		if(set==null)
    			continue;
    		for(String s:set){
    			if(str.startsWith(s)){
    				String strTmp = str.substring(s.length());
    				dfs(strTmp,strTmp.length(),map);
    				break;
    			}else if(s.compareTo(str)>0){
    				break;
    			}
    		}
    	}
    }
    
    private TreeMap<Integer, TreeSet<String>> process(String[] str) {
    	TreeMap<Integer, TreeSet<String>> map = new TreeMap<Integer,TreeSet<String>>();
		for(String s:str){
			int len = s.length();
			TreeSet<String> set = map.get(len);
			if(set==null)
				set = new TreeSet<String>();
			set.add(s);
			map.put(len,set);
		}
		return map;
	}

	@Test
    public void test(){
    	String[] strs = new String[]{"xaj","wegye","edldqy","fdcgxj","execs","dldqy","vofmdf","uuhoypqexecs","vlyil","gljlv","dcgxjv","lyil","f","uuhoypq","xajwegye","v","wis","dcgxj","gljlvdcgxj","gljlvwegye","e","qvda","drth"};
    	System.out.println(getLongest(strs, strs.length));;
    }
	
	@Test
    public void test1(){
    	String[] strs = new String[]{"a","b","c","ab","bc","abc"};
        TreeMap<Integer,TreeSet<String>> map = process(strs);
    	dfs("abc",3,map);
    	System.out.println(flag);
    }
}
