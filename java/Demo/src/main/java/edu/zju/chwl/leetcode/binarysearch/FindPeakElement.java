package edu.zju.chwl.leetcode.binarysearch;

import edu.zju.chwl.util.Tools;

public class FindPeakElement {
	
	public static void main(String[] args){
		int[] arr=new int[]{1, 2, 1, 3, 4, 5, 7, 6};
		Tools.print(findPeak(arr));
		
	}
	
    public static int findPeak(int[] A) {
        // write your code here
    	int start=0,end=A.length;
    	while(start+1<end){
    		int mid=start+(end-start)/2;
    		if(A[mid]<A[mid+1]){
    			start=mid;
    		}else{
    			end=mid;
    		}
    	}
    	return A[start]>A[end]?start:end;
    }

}
