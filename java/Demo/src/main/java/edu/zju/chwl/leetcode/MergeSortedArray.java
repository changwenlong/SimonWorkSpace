package edu.zju.chwl.leetcode;

import java.util.Arrays;

public class MergeSortedArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A=new int[]{1,2,6,0,0};
		mergeSortedArray(A,3,new int[]{4,5},2);
		for(int item:A){
			System.out.println(item);
		}
	}

    public static void mergeSortedArray(int[] A, int m, int[] B, int n) {
        for(int i=m;i<m+n;i++){
        	A[i]=B[i-m];
        }        
        Arrays.sort(A);
    }
}
