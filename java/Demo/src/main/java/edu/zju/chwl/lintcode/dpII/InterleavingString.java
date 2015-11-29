package edu.zju.chwl.lintcode.dpII;

import edu.zju.chwl.util.Tools;

public class InterleavingString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tools.print(new InterleavingString().isInterleave("aabcc", "dbbca", "aadbbcbcac"));
		Tools.print(new InterleavingString().isInterleave("aabcc", "dbbca", "aadbbbaccc"));
	}

    public boolean isInterleave(String s1, String s2, String s3) {
       	if(s1==null){
    		if(s2==null){
    			return s3==null;
    		}else{
    			return s2.equals(s3);
    		}
    	}else if(s2==null){
    		return s1.equals(s3);
    	}
    	int x=s1.length(),y=s2.length();
    	if(s3.length()!=(x+y)){
    		return false;
    	}
    	boolean[][] results=new boolean[x+1][y+1];
    	for(int i=1;i<=x;i++){
    		results[i][0]=s1.substring(0, i).equals(s3.substring(0, i));
    	}
    	for(int j=0;j<=y;j++){
    		results[0][j]=s2.substring(0, j).equals(s3.substring(0, j));
    	}
    	for(int i=1;i<=x;i++){
    		for(int j=1;j<=y;j++){
    			results[i][j]=(results[i-1][j]&&s1.charAt(i-1)==s3.charAt(i+j-1))||
    					(results[i][j-1]&&s2.charAt(j-1)==s3.charAt(i+j-1));
    		}
    	}
    	return results[x][y];
    }
}
