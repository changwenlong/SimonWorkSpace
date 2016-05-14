package edu.zju.chwl.coder.c1;

import org.junit.Test;

public class TransformImage {
	
    public int[][] transformImage(int[][] mat, int n) {
    	int[][] result=new int[n][n];
        for(int i=0;i<(n+1)/2;i++){
        	transformImage(result,mat,n-i*2,i);
        }
        return result;
    }
    
    public void transformImage(int[][] result,int[][] mat, int n,int start){
    	for(int i=0;i<n;i++){
    		result[i+start][start+n-1]=mat[start][i+start];
    	}
    	for(int i=0;i<n;i++){
    		result[start+n-1][start+n-1-i]=mat[i+start][start+n-1];
    	}
    	for(int i=0;i<n;i++){
    		result[i+start][start]=mat[start+n-1][i+start];
    	}
    	for(int i=0;i<n;i++){
    		result[start][start+n-1-i]=mat[start+i][start];
    	}
    }
    
    @Test
    public void test(){
    	int[][] mat={{1,2,3},{4,5,6},{7,8,9}};
    	printArr(transformImage(mat,3));
    	int[][] mat1={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
    	printArr(transformImage(mat1,4));
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
