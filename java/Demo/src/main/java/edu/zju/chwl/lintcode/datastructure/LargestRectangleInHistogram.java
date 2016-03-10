package edu.zju.chwl.lintcode.datastructure;

import java.util.Stack;

/**
 * http://www.lintcode.com/en/problem/largest-rectangle-in-histogram/
 * 
 * @author a590450
 * @date 3 Mar 2016 16:21:59
 */
public abstract class LargestRectangleInHistogram {
	public static void main(String[] args) {
		System.out.println(largestRectangleArea(new int[]{2,1,5,6,2,3}));
		System.out.println(largestRectangleArea(new int[]{5,4,1,2}));	
	}
	
    public static int largestRectangleArea(int[] height) {
        if(height==null||height.length==0){
        	return 0;
        }
        int len = height.length+2;
        int[] arr = new int[len];
        for(int i=1;i<len-1;i++){
        	arr[i]=height[i-1];
        }
        int max=0;
        Stack<Integer> s=new Stack<Integer>();
        s.push(0);
        for(int i=1;i<len;i++){
        	while(!s.isEmpty()&&arr[s.peek()]>arr[i]){
        		Integer index = s.pop();
        		int value=arr[index]*(i-s.peek()-1);
        		max = max>value?max:value;
        	}
        	s.push(i);
        }
        return max;
    }
    
}
