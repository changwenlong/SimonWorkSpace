package edu.zju.chwl.lintcode.dpII;


import edu.zju.chwl.util.Tools;

public class EditDistance {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Tools.print(new EditDistance().minDistance("sea", "ate"));
	}

    public int minDistance(String word1, String word2) {
    	if(word1==null||word2==null){
    		return 0;
    	}
    	int x=word1.length(),y=word2.length();
    	int[][] results=new int[x+1][y+1];
    	for(int i=0;i<=x;i++){
    		results[i][0]=i;
    	}
    	for(int j=0;j<=y;j++){
    		results[0][j]=j;
    	}
    	for(int i=1;i<=x;i++){
    		for(int j=1;j<=y;j++){
    			if(word1.charAt(i-1)==word2.charAt(j-1)){
    				results[i][j]=Math.min(Math.min(results[i-1][j-1], results[i][j-1]+1), results[i-1][j]+1);
    			}else{
    				results[i][j]=Math.min(Math.min(results[i-1][j-1], results[i][j-1]), results[i-1][j])+1;
    			}
    			Tools.print("f["+i+"]["+j+"]::"+results[i][j]);
    		}
    	}
    	return results[x][y];
    }
}
