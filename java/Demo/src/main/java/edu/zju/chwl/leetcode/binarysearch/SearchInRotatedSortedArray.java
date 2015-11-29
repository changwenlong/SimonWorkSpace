package edu.zju.chwl.leetcode.binarysearch;

import edu.zju.chwl.util.Tools;

public class SearchInRotatedSortedArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr=new int[]{6,8,9,1,3,5};
		Tools.print(search(arr,6));
		Tools.print(search(arr,8));
		Tools.print(search(arr,9));
		Tools.print(search(arr,5));
	}
	
    public static int search(int[] A, int target) {
        // write your code here
    	if(A==null||A.length==0){
    		return -1;
    	}
    	int start=0,end=A.length-1;
    	int firstVal=A[0];
    	while(start+1<end){
    		int mid=start+(end-start)/2;
    		if(A[mid]==target){
    			return mid;
    		}
    		if(A[mid]>firstVal){
    			if(target>A[mid]||target<firstVal){
    				start=mid;
    			}else{
    				end=mid;
    			}
    		}else{
    			if(target<A[mid]||target>firstVal){
    				end=mid;
    			}else{
    				start=mid;
    			}
    		}
    	}
    	if(A[start]==target){
    		return start;
    	}
    	if(A[end]==target){
    		return end;
    	}
    	return -1;
    }

}
