package edu.zju.chwl.lintcode.array;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import edu.zju.chwl.util.Tools;

public class MaximumSubarrayII {

	public static void main(String[] args) throws FileNotFoundException {
		int aa=0;
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		Scanner in =new Scanner(new File("C:\\temp\\10.in"));
		while(in.hasNext()){
			aa++;
			int value = in.nextInt();
			arrayList.add(value);
		}
		Tools.println(new MaximumSubarrayII().maxTwoSubArrays(arrayList));
	}

	public int maxTwoSubArrays(ArrayList<Integer> nums) {
		int size=nums.size();
		ListMaxSum listMaxSum = getMaxSum(nums);
		Tools.println(listMaxSum);
		int start = listMaxSum.start;
		int end = listMaxSum.end;
		int maxSum = listMaxSum.maxSum;
		int frontMax=Integer.MIN_VALUE,backMax=Integer.MIN_VALUE;
		if(start!=0){
			List<Integer> frontList=nums.subList(0, start);
			frontMax=getMaxSum(frontList).maxSum;
		}
		if(end!=size){
			List<Integer> backList=nums.subList(end, size);
			backMax=getMaxSum(backList).maxSum;
		}
		int midMin;
		if((end-start)==1){
			midMin=nums.get(start)>0?0:nums.get(start);
		}else{
			midMin=getMinSum(nums.subList(start, end));
			midMin=midMin<0?-midMin:0;
		}

		Tools.println(frontMax);
		Tools.println(backMax);
		
		return maxSum+getMax(frontMax,backMax,midMin);
	}

	private int getMax(int frontMax, int backMax, int midMin) {
		int max=frontMax>backMax?frontMax:backMax;
		return max>midMin?max:midMin;
	}

	public ListMaxSum getMaxSum(List<Integer> nums) {
		int max = nums.get(0);
		int size = nums.size();
		int[] maxSum = new int[size];
		maxSum[0] = nums.get(0);
		int start = 0, end = 1,temp=0;
		for (int i = 1; i < size; i++) {
			if (maxSum[i - 1] < 0) {
				maxSum[i] = nums.get(i);
			} else {
				maxSum[i] = nums.get(i) + maxSum[i - 1];
				if (maxSum[i - 1] <= 0) {
					temp = i;
				}
			}
			if (maxSum[i] >= max) {
				max = maxSum[i];
				if(end<temp){
					start=temp;
				}
				end = i + 1;
			}
		}
		return new ListMaxSum(start, end, max);
	}
	
	public int getMinSum(List<Integer> nums) {
		int min = nums.get(0);
		int size = nums.size();
		int[] minSum = new int[size];
		minSum[0] = nums.get(0);
		for (int i = 1; i < size; i++) {
			if (minSum[i - 1] > 0) {
				minSum[i] = nums.get(i);
			} else {
				minSum[i] = nums.get(i) + minSum[i - 1];
			}
			min=min<minSum[i]?min:minSum[i];
		}
		return min;
	}

	class ListMaxSum {
		int start;
		int end;
		int maxSum;

		ListMaxSum(int start, int end, int maxSum) {
			this.start = start;
			this.end = end;
			this.maxSum = maxSum;
		}

		@Override
		public String toString() {
			return "ListMaxSum [start=" + start + ", end=" + end + ", maxSum="
					+ maxSum + "]";
		}
		
	}
}
