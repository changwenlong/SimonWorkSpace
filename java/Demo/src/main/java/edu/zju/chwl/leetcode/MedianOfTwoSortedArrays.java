package edu.zju.chwl.leetcode;

import java.util.ArrayList;
import java.util.Collections;

public class MedianOfTwoSortedArrays {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A=new int[]{1,2,3};
		int[] B=new int[]{4,5};
		System.out.println(findMedianSortedArrays(A,B));

	}

    public static double findMedianSortedArrays(int[] A, int[] B) {
    	ArrayList<Integer> list=new ArrayList<Integer>();
        for(int item:A){
        	list.add(item);
        }
        for(int item:B){
        	list.add(item);
        }
        Collections.sort(list);
        if(list.size()%2==1){
            return list.get(list.size()/2);
        }else{
            return ((double)(list.get(list.size()/2-1)+list.get(list.size()/2)))/2;
        }
        
    }
}
