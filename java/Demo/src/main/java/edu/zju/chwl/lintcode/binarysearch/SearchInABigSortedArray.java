package edu.zju.chwl.lintcode.binarysearch;

import edu.zju.chwl.util.Tools;

public class SearchInABigSortedArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tools.print(new SearchInABigSortedArray().searchBigSortedArray(new int[]{1, 3, 6, 9, 21}, 3));
		Tools.print(new SearchInABigSortedArray().searchBigSortedArray(new int[]{2,2,3,4,5,6,8,13,17,18}, 2));
	}
	
    public int searchBigSortedArray(int[] A, int target) {
    	if (A == null || A.length == 0) {
            return -1;
        }
    	int low=0;
    	int high=A.length-1;
    	while(low+1<high){
    		int mid=(low+high)/2;
    		if(A[mid]>=target){
    			high=mid;
    		}else{
    			low=mid;
    		}
    	}
    	if(A[low]==target){
    		return low;
    	}
    	if(A[high]==target){
    		return high;
    	}
    	return -1;
    }
}
