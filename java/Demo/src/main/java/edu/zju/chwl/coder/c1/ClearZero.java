package edu.zju.chwl.coder.c1;

import org.junit.Test;

public class ClearZero {
	
    public int[][] clearZero(int[][] mat, int n) {
        boolean[] rows=new boolean[300];
        boolean[] columns=new boolean[300];
        int m = mat.length;
        for(int i=0;i<m;i++){
        	for(int j=0;j<n;j++){
        		if(mat[i][j]==0){
        			rows[i]=true;
        			columns[j]=true;
        		}
        	}
        }
        for(int i=0;i<m;i++){
        	for(int j=0;j<n;j++){
        		if(rows[i]||columns[j]){
        			mat[i][j]=0;
        		}
        	}
        }
        return mat;
    }
    
    @Test
    public void test(){
    	int[][] mat={{1,2,3},{0,1,2},{0,0,1}};
    	printArr(clearZero(mat,3));
    }

	public void printArr(int[][] mat) {
		for(int i=0;i<mat.length;i++){
    		int[] arr=mat[i];
    		for(int j=0;j<arr.length;j++){
    			System.out.print(arr[j]+" ");
    		}
    		System.out.println();
    	}
	}
}
