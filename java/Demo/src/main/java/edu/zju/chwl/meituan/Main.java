package edu.zju.chwl.meituan;

/**
 * 非相邻数字和： 数组构成环 从里面取不相邻的数 使得和最大
 * http://blog.csdn.net/claire7/article/details/46849033
 * 贪心 
 * @author chwl
 * @Date 2016年9月11日 下午6:40:49
 */
public class Main {

	public static void main(String[] args) {
		nums = new int[]{1,3,4};
		System.out.println(getMaxSum(nums.length));
	}
	
	public static int[] nums;
	
	public static int f(int n){
		if(n==0) return nums[0];
		if(n<=0) return 0;
		return Math.max(f(n-2)+nums[n], f(n-1));
	}
	
	public static int fc(int n){
		if(n==1) return nums[1];
		if(n<=1) return 0;
		return Math.max(fc(n-2)+nums[n], fc(n-1));
	}
	
	public static int getMaxSum(int n){
		return Math.max(f(n-2), fc(n-1));
	}

}
