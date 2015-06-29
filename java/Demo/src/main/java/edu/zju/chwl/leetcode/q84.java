package edu.zju.chwl.leetcode;

import java.util.*;

//有错误 之后解决
public class q84 {

	//ArrayList当堆栈用
	public static void main(String[] args) {
		int[] height={2,1,5,6,2,3};
		System.out.println(largestRectangleArea(height));
	}
	
    public static int largestRectangleArea(int[] height) {
        int[] arr=Arrays.copyOf(height, height.length+1);
		LinkedList<Integer> list=new LinkedList<Integer>();
		int i,max=0;
		for(i=0;i<arr.length;i++){
			int var=arr[i];
			if(list.isEmpty()||var>=arr[list.peekLast()]){
				list.add(i);
			}else{
				while(!list.isEmpty()&&var<arr[list.peekLast()]){
					int index=list.pollLast();
					int temp=arr[index]*(i-index);
					max=temp>max?temp:max;
				}
				list.add(i);
			}
		}
		return max;
    }

}
