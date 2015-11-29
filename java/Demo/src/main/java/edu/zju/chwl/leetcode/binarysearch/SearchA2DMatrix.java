package edu.zju.chwl.leetcode.binarysearch;

import edu.zju.chwl.util.Tools;

public class SearchA2DMatrix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tools.print(new SearchA2DMatrix().searchMatrix(new int[][]{ {1, 3, 5, 7},
			    {10, 11, 16, 20},
			    {23, 30, 34, 50}}, 2));
	}
	
    public boolean searchMatrix(int[][] matrix, int target) {
        // write your code here
    	if(matrix==null||matrix.length==0){
    		return false;
    	}
    	int col=matrix[0].length;
    	int row=matrix.length;
    	int start=0,end=col*row-1;
    	while(start+1<end){
    		int mid=start+(end-start)/2;
    		if(matrix[mid/col][mid%col]==target){
    			return true;
    		}else if(matrix[mid/col][mid%col]>target){
    			end=mid;
    		}else{
    			start=mid;
    		}
    	}
    	if(matrix[start/col][start%col]==target){
    		return true;
    	}
    	if(matrix[end/col][end%col]==target){
    		return true;
    	}
    	return false;
    }

}
