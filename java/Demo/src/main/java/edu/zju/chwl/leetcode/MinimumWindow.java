package edu.zju.chwl.leetcode;

import java.util.Arrays;
/**
 * https://leetcode.com/problems/minimum-window-substring/
 * @author chwl
 * @Date 2016年2月20日 下午8:25:23
 */
public class MinimumWindow {

	public static void main(String[] args) {
		System.out.println(minWindow("ADOBECODEBANC","ABC"));

	}
	
	//1.Use a hash array to store character appear times in string t.
	//2.Use two pointers to try all the possible window which includes t.
	//3.In the beginning, start and end pointer points to the start of string s,
	//and then move end until including all the characters in t, check whether
	//can move start pointer. If so, move start pointer. 
	//4.Continue the process until end pointer reaches the end of string s.
	//time complexity: O(n)
	public static String minWindow(String s, String t) {
		if(s==null||t==null||s.isEmpty()||t.isEmpty()||t.length()>s.length()){
			return "";
		}
		int[] hash = new int[128];
		int count = t.length();
		for(int i=0;i<count;i++){
			hash[t.charAt(i)]++;
		}
		int[] hashCopy= Arrays.copyOf(hash, hash.length);
		int start=0,end=0;
		String res = "";
		while(end<s.length()){
			if(hash[s.charAt(end)]>0){
				if(hashCopy[s.charAt(end)]-->0){
					count--;
				}
			}
			if(count==0&&hash[s.charAt(end)]>0){
				while(true){
					if(hash[s.charAt(start)]==0){
						start++;
					}else{
						if(hashCopy[s.charAt(start)]<0){
							hashCopy[s.charAt(start)]++;
							start++;
						}else{
							break;
						}
					}
				}
				if("".equals(res)){
					res=s.substring(start,end+1);
				}else{
					String temp=s.substring(start,end+1);
					res=res.length()<temp.length()?res:temp;
				}
			}
			end++;
		}		
		return res;
	}

}
