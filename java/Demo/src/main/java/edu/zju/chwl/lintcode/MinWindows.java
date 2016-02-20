package edu.zju.chwl.lintcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MinWindows {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new Solution().minWindow("ADOBECODEBANC","ABC"));

	}
	


}
class Solution {
    public String minWindow(String s, String t) {
        int lenS,lenT;
        lenS=s.length();
        lenT=t.length();
        if(lenT>lenS){
            return "";
        }
        List<Character> listT=new ArrayList<Character>();
        for(char ch:t.toCharArray()){
        	listT.add(ch);
    	}
        String tmpS=null;
        for(int i=lenT-1;i<lenS;i++){
        	List<Character> listS=new ArrayList<Character>();
        	String subS=s.substring(0,i+1);
        	for(char ch:subS.toCharArray()){
        		listS.add(ch);
        	}
        	if(listS.containsAll(listT)){
        		tmpS=subS;
        		break;
        	}
        }
        int j=1;
        while(!listT.contains(s.charAt(j))&&j<lenS){
        	j++;
        }
        String result=minWindow(s.substring(j,lenS),t);
        if("".equals(result)&&tmpS!=null){
        	return tmpS;
        }else if(tmpS==null){
        	return result;
        }else{
        	return result.length()<tmpS.length()?result:tmpS;
        }
        
    }
    
    public String minWindow1(String s, String t) {
    	Map<Character,List<Integer>> charMap= new HashMap<Character,List<Integer>>();
    	List<Integer> charLocationlist;
    	for(int i=0;i<s.length();i++){
    		char ch=s.charAt(i);
    		charLocationlist=charMap.get(ch);
    		if(charLocationlist==null){
    			charLocationlist=new ArrayList<Integer>();
    		}
    		charLocationlist.add(i);
    		charMap.put(ch, charLocationlist);
    	}
    	Map<Integer,Character> locationMap= new TreeMap<Integer,Character>();
        for(int i=0;i<t.length();i++){
        	charLocationlist=charMap.get(t.charAt(i));
        	if(charLocationlist==null){
        		return "";
        	}
        	for(Integer item:charLocationlist){
        		locationMap.put(item, t.charAt(i));
        	}
        }
        int min = 0,max = 0,len=Integer.MAX_VALUE,a,b;
        Map<Character,Integer> resultMap= new HashMap<Character,Integer>();
        for(Integer key:locationMap.keySet()){
        	Character ch1=locationMap.get(key);
        	resultMap.put(ch1, key);
        	if(resultMap.size()==t.length()){
            	a=Integer.MAX_VALUE;
            	b=-1;
            	for(Integer value:resultMap.values()){
            		if(value<a){
            			a=value;
            		}
            		if(value>b){
            			b=value;
            		}
            	}
        		int des=b-a;
        		if(des<len){
        			len=des;
        			min=a;
        			max=b;
        		}
        	}
        }
        if(resultMap.size()<t.length()){
        	return "";
        }
        return s.substring(min,max+1);
        
    }
    
    public String minWindow2(String s, String t) {
    	Map<Character,List<Integer>> charMap= new HashMap<Character,List<Integer>>();
    	List<Integer> charLocationlist;
    	for(int i=0;i<s.length();i++){
    		char ch=s.charAt(i);
    		charLocationlist=charMap.get(ch);
    		if(charLocationlist==null){
    			charLocationlist=new ArrayList<Integer>();
    		}
    		charLocationlist.add(i);
    		charMap.put(ch, charLocationlist);
    	}
    	Map<Integer,Character> locationMap= new TreeMap<Integer,Character>();
        for(int i=0;i<t.length();i++){
        	charLocationlist=charMap.get(t.charAt(i));
        	if(charLocationlist==null){
        		return "";
        	}
        	for(Integer item:charLocationlist){
        		locationMap.put(item, t.charAt(i));
        	}
        }
        
        int min = 0,max = 0,len=Integer.MAX_VALUE,a,b;
        Map<Character,Integer> resultMap= new HashMap<Character,Integer>();
        for(Integer key:locationMap.keySet()){
        	Character ch1=locationMap.get(key);
        	if(resultMap.get(ch1)!=null){
        		
        	}
        	resultMap.put(ch1, key);
        	if(resultMap.size()==t.length()){
            	a=Integer.MAX_VALUE;
            	b=-1;
            	for(Integer value:resultMap.values()){
            		if(value<a){
            			a=value;
            		}
            		if(value>b){
            			b=value;
            		}
            	}
        		int des=b-a;
        		if(des<len){
        			len=des;
        			min=a;
        			max=b;
        		}
        	}
        }
        if(resultMap.size()<t.length()){
        	return "";
        }
        return s.substring(min,max+1);
        
    }
}