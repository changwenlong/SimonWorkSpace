package edu.zju.chwl.coder.c5;

/**
 * 观察到：numbers[i][0]=i%2
 * @author chwl
 * @Date 2016年5月15日 下午6:35:41
 */
public class Finder {
    public int findMissing(int[][] numbers, int n) {
    	if(numbers[0][0]!=0){
    		return 0;
    	}
        for(int i=0;i<n;i++){
        	if(i%2!=numbers[i][0]){
        		return getValue(numbers[i]);
        	}
        }
        return n;
    }

	private int getValue(int[] nums) {
		int sum=0;
		for(int i=0;i<nums.length;i++){
			sum+=(nums[i]<<i);
		}
		return sum-1;
	}
}
