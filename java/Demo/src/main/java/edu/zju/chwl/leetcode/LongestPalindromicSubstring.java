package edu.zju.chwl.leetcode;
/**
 * https://leetcode.com/problems/longest-palindromic-substring/
 * @author chwl
 * @Date 2016年2月23日 下午11:20:38
 */
public class LongestPalindromicSubstring {

	public static void main(String[] args) {
		System.out.println(longestPalindrome("ababa"));
		System.out.println(longestPalindrome("caabbaabaab"));
		System.out.println(longestPalindrome("dabacab"));
		System.out.println(longestPalindrome("ccccc"));
		System.out.println(longestPalindrome("aaaaa"));
	}
	
    public static String longestPalindrome(String s) {
        if(s==null||s.isEmpty()){
        	return "";
        }
        int start=0,count=1;
        int len = s.length();
    	char[] charArr=s.toCharArray();
    	boolean[][] palindrome=new boolean[len][len];
    	for(int i=0;i<len;i++){
    		palindrome[i][i]=true;
    	}
    	for(int i =len-2;i>=0;i--){
    		for(int j=i+1;j<len;j++){
    			if(charArr[i]==charArr[j]){
    				if((i+1>=j-1)||palindrome[i+1][j-1]){
    					palindrome[i][j]=true;
    					if(j-i+1>count){
    						count=j-i+1;
    						start=i;
    					}
    				}
    			}
    		}
    	}
        return s.substring(start,start+count);
    }
    
    public static boolean[][] isPalindrome(String s){
    	int len = s.length();
    	char[] charArr=s.toCharArray();
    	boolean[][] palindrome=new boolean[len][len];
    	for(int i=0;i<len;i++){
    		palindrome[i][i]=true;
    	}
    	for(int i =len-2;i>=0;i++){
    		for(int j=i+1;i<len;j++){
    			if(charArr[i]==charArr[j]){
    				if(i+1>=j-1&&palindrome[i+1][j-1]){
    					palindrome[i][j]=true;
    				}
    			}
    		}
    	}
    	return palindrome;
    }

}
