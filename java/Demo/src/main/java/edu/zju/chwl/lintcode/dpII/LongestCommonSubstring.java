package edu.zju.chwl.lintcode.dpII;

import edu.zju.chwl.util.Tools;

public class LongestCommonSubstring {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Tools.print(new LongestCommonSubstring().longestCommonSubstring("www.lintcode.com code", "www.ninechapter.com code"));
	}
	
    public int longestCommonSubstring(String word1, String word2) {
    	if(word1==null||word2==null){
    		return 0;
    	}
    	int x=word1.length(),y=word2.length();
    	int[][] results=new int[x+1][y+1];
    	int max=Integer.MIN_VALUE;
    	for(int i=1;i<=x;i++){
    		for(int j=1;j<=y;j++){
    			if(word1.charAt(i-1)==word2.charAt(j-1)){
    				results[i][j]=results[i-1][j-1]+1;
    			}
    			max=max>results[i][j]?max:results[i][j];
    			Tools.print("f["+i+"]["+j+"]::"+results[i][j]);
    		}
    	}
    	return max;
    }
}
