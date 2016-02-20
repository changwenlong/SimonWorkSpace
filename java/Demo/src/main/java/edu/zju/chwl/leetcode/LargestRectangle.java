package edu.zju.chwl.leetcode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/largest-rectangle-in-histogram/
 * 借助stack实现
 * @author chwl
 * @Date 2016年2月20日 下午2:04:23
 */
public class LargestRectangle {

	public static void main(String[] args) {
		LargestRectangle r = new LargestRectangle();
		System.out.println(r.largestRectangleArea(new int[]{2,1,2}));

	}
	
	public int largestRectangleArea(int[] height) {
		if(height==null||height.length==0){
			return 0;
		}
		int len = height.length;
		//给定数组前后各加一个0形成新的数组
		int[] arr = new int[len+2];
		for(int i=0;i<len;i++){
			arr[i+1]=height[i];
		}
		Stack<Integer> stack = new Stack<Integer>();
		int max = 0;
		for(int i=0;i<len+2;i++){
			while(!stack.isEmpty()&&arr[i]<arr[stack.peek()]){
				int index = stack.pop();
				int h = arr[index];
				//注意此处计算以h为高的宽度：i-stack.peek()-1
				int area = h * (i-stack.peek()-1);
				max = max>area?max:area;
			}
			stack.push(i);
		}
		return max;
	}

}
