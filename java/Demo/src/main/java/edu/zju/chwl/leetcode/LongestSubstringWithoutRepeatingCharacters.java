package edu.zju.chwl.leetcode;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * 
 * @author chwl
 * @Date 2016年2月23日 下午9:14:53
 */
public class LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("abcabcbdb"));
		System.out.println(lengthOfLongestSubstring("bb"));
		System.out.println(lengthOfLongestSubstring("bcd"));
		System.out.println(lengthOfLongestSubstring("b"));
		System.out.println(lengthOfLongestSubstring("aab"));
	}

	public static int lengthOfLongestSubstring(String s) {
		if(s==null||s.isEmpty()){
			return 0;
		}
		char[] arr=s.toCharArray();
		int[] counts=new int[256];
		int start=0,max=0,end;
		for(end=0;end<arr.length;end++){
			if(++counts[arr[end]]==2){
				int len=end-start;
				max=max>len?max:len;
				for(;counts[arr[start]]==1;start++){
					counts[arr[start]]--;
				}
				counts[arr[start]]--;
				start++;
			}
		}
		int tmp=end-start;
		max=max>tmp?max:tmp;
		return max;
	}

}
