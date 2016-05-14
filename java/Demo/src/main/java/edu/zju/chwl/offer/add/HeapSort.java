package edu.zju.chwl.offer.add;

import org.junit.*;

public class HeapSort {
	
	@Test
	public void test(){
		int[] nums = new int[]{5,3,8,7,1,4,6,2};
		heapSort(nums);
		Assert.assertEquals("{1,2,3,4,5,6,7,8}", printArray(nums));
	}
	
	public String printArray(int[] nums){
		if(nums==null|nums.length==0){
			return "";
		}
		StringBuilder sb = new StringBuilder();
		sb.append("{").append(nums[0]);
		for(int i=1;i<nums.length;i++){
			sb.append(",").append(nums[i]);
		}
		sb.append("}");
		return sb.toString();		
	}

	public void heapSort(int[] nums){
		if(nums==null|nums.length==0){
			return;
		}
		//构造初始化堆
		initConstruct(nums);
		//调整堆
		for(int i=nums.length-1;i>0;i--){
			swap(nums,0,i);
			adjust(nums,i);			
		}
		System.out.println(nums);
	}

	//调整堆
	private void adjust(int[] nums,int len) {
		adjust(nums,len,0);	
	}

	//构造初始化堆
	private void initConstruct(int[] nums) {
		int len = nums.length;
		int notLeaf=(len-2)/2;
		for(int i=notLeaf;i>=0;i--){			
			adjust(nums,len,i);		
		}
	}

	//构造堆
	private void adjust(int[] nums, int len, int start) {
		int left = start*2+1;
		int right = start*2+2;
		int minIndex=start;
		if(left<len&&nums[left]>nums[minIndex]){
			minIndex=left;
		}
		if(right<len&&nums[right]>nums[minIndex]){
			minIndex=right;
		}
		if(minIndex!=start){
			swap(nums,start,minIndex);
			adjust(nums,len,minIndex);
		}
	}

	//数组元素交换
	private void swap(int[] nums, int i, int j) {
		int temp=nums[i];
		nums[i]=nums[j];
		nums[j]=temp;		
	}
	
}
