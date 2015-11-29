package edu.zju.chwl.leetcode.binarysearch;

public class SearchInsertPosition {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(searchInsert(new int[]{1,3,5,6},5));
		System.out.println(searchInsert(new int[]{1,3,5,6},2));
		System.out.println(searchInsert(new int[]{1,3,5,6},7));
		System.out.println(searchInsert(new int[]{1,3,5,6},0));
	}
	
	public static int searchInsert(int[] A, int target) {
        int result=A.length;
    	for(int i=0;i<result;i++){
    		if(target<=A[i]){
    			return i;
    		}
    	}
    	return result;
    }

    public static int searchInsert1(int[] A, int target) {
        // write your code here
    	int low=0;
    	int high=A.length-1;
    	if(high==-1){
    		return 0;
    	}
    	return search(low,high,A,target);
    }

	public static int search(int low, int high, int[] A, int target) {
		int mid=(low+high)/2;
		if(A[mid]==target){
			return mid;
		}else if(A[mid]<target){
			if(mid+1>high){
				return mid+1;
			}else{
				return search(mid+1,high,A,target);
			}
		}else{
			if(mid-1<low){
				return mid;
			}else{
				return search(low,mid-1,A,target);
			}
			
		}
	}
}
