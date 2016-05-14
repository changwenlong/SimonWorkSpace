package edu.zju.chwl.offer.datastructure;

import org.junit.*;

/**
 * https://leetcode.com/problems/spiral-matrix-ii/
 * @author a590450
 * @date 25 Mar 2016 15:15:48
 */
public class SpiralMatrixII {
	
    public int[][] spiralOrder(int n) {
    	int[][] matrix = new int[n][n];
        if(n==0){
        	return matrix;
        }
        printSpiral(matrix,n,0,1);
        return matrix;
    }
    
    private void printSpiral(int[][] matrix,int count,int index,int num){
    	if(count<=0){
    		return;
    	}
    	for(int j=index;j<index+count;j++){
    		matrix[index][j]=num++;
    	}
    	for(int i=index+1;i<index+count;i++){
    		matrix[i][index+count-1]=num++;
    	}
    	for(int j=index +count-2;j>=index;j--){
    		matrix[index+count-1][j]=num++;
    	}
    	for(int i =index+count-2;i>index;i--){
    		matrix[i][index]=num++;
    	}
    	printSpiral(matrix,count-2,index+1,num);
    }
    
    @Test
    public void spiralOrder3(){
    	spiralOrder(3);
    }
     
}
