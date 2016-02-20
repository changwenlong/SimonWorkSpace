package edu.zju.chwl.lintcode.binarysearch;

public class BinarySearch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		int val=binarySearch(new int[]{1,3,5,7},7);
//		System.out.println(val);
		int[] arr=new int[]{1,3,5,6};
		System.out.println(insertLocation(arr,5));
		System.out.println(insertLocation(arr,2));
		System.out.println(insertLocation(arr,7));
		System.out.println(insertLocation(arr,0));
	}
	
    public static int binarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        int start = 0, end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                end = mid;  
            } else if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (nums[start] == target) {
            return start;
        }
        if (nums[end] == target) {
            return end;
        }
        return -1;
    }
    
    public static int insertLocation(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int start = 0, end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;  
            } else if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (nums[start] == target) {
            return start;
        }else if (nums[end] == target) {
            return end;
        }else if(target<nums[start]){
        	return start;
        }else if(target>nums[end]){
        	return end+1;
        }else{
        	return end;
        }
    }

}
