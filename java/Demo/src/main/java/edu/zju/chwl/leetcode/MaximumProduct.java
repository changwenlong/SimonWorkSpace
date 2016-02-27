package edu.zju.chwl.leetcode;

/**
 * https://leetcode.com/problems/maximum-product-subarray/
 * 保存以nums[i]結尾的乘积的最大最小值，用作计算以nums[i+1]结尾的乘积的最大最小值
 * @author chwl
 * @Date 2016年2月20日 下午3:11:30
 */
public class MaximumProduct {

	public static void main(String[] args) {		
		System.out.println(maxProduct(new int[]{2,3,-2,-4}));;
	}
	
	public static int maxProduct(int[] nums) {
		if(nums==null||nums.length==0){
			return 0;
		}
		int max = nums[0];
		int prevMax=nums[0];
		int prevMin=nums[0];
		for(int i=1;i<nums.length;i++){
			int maxProd=prevMax*nums[i];
			int minProd=prevMin*nums[i];
			prevMax=Math.max(nums[i], Math.max(maxProd, minProd));
			prevMin=Math.min(nums[i], Math.min(maxProd, minProd));
			max=max>prevMax?max:prevMax;
		}
        return max;
    }

}
