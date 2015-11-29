package edu.zju.chwl.lintcode.dp;

import edu.zju.chwl.util.Tools;

public class UniquePaths {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Tools.print(new UniquePaths().uniquePaths(8,68));

	}
	
    public int uniquePaths(int m, int n) {
    	if(m==0||n==0){
    		return 0;
    	}
    	int[][] sum=new int[m][n];
    	for(int i=0;i<m;i++){
    		sum[i][0]=1;
    	}
    	for(int i=0;i<n;i++){
    		sum[0][i]=1;
    	}
    	for(int i=1;i<m;i++){
    		for(int j=1;j<n;j++){
    			sum[i][j]=sum[i-1][j]+sum[i][j-1];
    		}
    	}
        return sum[m-1][n-1];
    }

}
