package edu.zju.chwl.leetcode;

/**
 * https://leetcode.com/problems/longest-common-prefix/
 * @author chwl
 * @Date 2016年2月27日 下午8:38:49
 */
public class LongestCommonPrefix {
	public static void main(String[] args) {
		System.out.println(longestCommonPrefix(new String[]{"aa","a"}));
	}
	
	public static String longestCommonPrefix(String[] strs) {
        if(strs==null||strs.length==0){
        	return "";
        }
        
        int pos=0;
        if(strs[0]==null||strs[0].isEmpty()){
        	return "";
        }else{
        	pos=strs[0].length();
        }
        for(int i=1;i<strs.length;i++){
        	if(strs[i]==null||strs[i].length()==0){
        		return "";
        	}
        	pos=pos<strs[i].length()?pos:strs[i].length();
        	for(int j=0;j<pos;j++){
        		if(strs[0].charAt(j)!=strs[i].charAt(j)){
        			pos=j;
        			break;
        		}
        	}
        }
        return strs[0].substring(0,pos);
    }
	
}
