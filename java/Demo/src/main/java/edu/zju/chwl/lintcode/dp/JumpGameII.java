package edu.zju.chwl.lintcode.dp;

import edu.zju.chwl.util.Tools;

public class JumpGameII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Tools.print(new JumpGameII().jump(new int[]{2,3,1,1,4}));

	}
	
    public int jump(int[] A) {
    	int len=A.length;
    	int[] results=new int[len];
    	results[0]=0;
    	for(int i=1;i<len;i++){
    		results[i]=Integer.MAX_VALUE;
    	}
    	for(int i=0;i<len-1;i++){
    		for(int j=i+1;(j<=i+A[i])&&(j<len);j++){
    			results[j]=Math.min(results[j], results[i]+1);
    		}
    	}
        return results[len-1];
    }

}
