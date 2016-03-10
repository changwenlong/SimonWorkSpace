package edu.zju.chwl.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * https://leetcode.com/problems/substring-with-concatenation-of-all-words/
 * 
 * @author a590450
 * @date 3 Mar 2016 13:32:07
 */
public class SubstringWithConcatenationOfAllWords {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(findSubstring("abcbaabcbaabc",new String[]{"abc","cba"}));
		System.out.println(findSubstring("wordgoodgoodgoodbestword",new String[]{"word","good","best","good"}));
	}

	public static List<Integer> findSubstring(String s, String[] words) {
		int sLen = s.length();
		if(s==null||sLen==0||words==null||words.length==0){
			return Collections.emptyList();
		}
		HashMap<String, Integer> keyMap = new HashMap<String,Integer>();
		for(String word:words){
			Integer value = keyMap.get(word);
			if(value!=null){
				keyMap.put(word, value+1);
			}else{
				keyMap.put(word, 1);
			}			
		}
		ArrayList<Integer> result = new ArrayList<Integer>();
		int count = words.length;
		int wordLen = words[0].length();
		int nCount =count*wordLen;
		for(int i=0;i<=sLen-nCount;i++){
			if(isContain(s.substring(i,i+nCount),(HashMap<String, Integer>) keyMap.clone(),wordLen)){
				result.add(i);
			}
		}
		return result;
	}

	private static boolean isContain(String substring,
			HashMap<String, Integer> keyMap,int wordLen) {
		int count=substring.length()/wordLen;
		for(int i=0;i<count;i++){
			String s =substring.substring(i*wordLen, (i+1)*wordLen);
			Integer value = keyMap.get(s);
			if(value==null||value==0){
				return false;
			}else{
				keyMap.put(s, value-1);
			}
		}
		return true;
	}

}
