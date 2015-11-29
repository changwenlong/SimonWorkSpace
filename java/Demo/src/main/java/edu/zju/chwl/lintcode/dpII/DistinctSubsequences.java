package edu.zju.chwl.lintcode.dpII;

import edu.zju.chwl.util.Tools;

public class DistinctSubsequences {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Tools.print(new DistinctSubsequences().numDistinct("aba", "a"));

	}
	
    public int numDistinct(String str1, String str2) {
    	if(str1==null){
    		return 1;
    	}else if(str2==null){
    		return 0;
    	}
    	int x=str1.length(),y=str2.length();
    	if(x>y){
    		return numDistinct(str2,str1);
    	}
    	int[][] results=new int[x+1][y+1];
    	for(int i=1;i<=x;i++){
    		results[i][0]=0;
    	}
    	for(int j=0;j<=y;j++){
    		results[0][j]=1;
    	}
    	for(int i=1;i<=x;i++){
    		for(int j=1;j<=y;j++){
    			if(str1.charAt(i-1)==str2.charAt(j-1)){ 					
    				results[i][j]=results[i-1][j-1]+results[i][j-1];
    			}else{
    				results[i][j]=results[i][j-1];
    			}
    			//Tools.print("f["+i+"]["+j+"]::"+results[i][j]);
    		}
    	}
    	return results[x][y];
    }

}
