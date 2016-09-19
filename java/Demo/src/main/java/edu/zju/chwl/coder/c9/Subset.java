package edu.zju.chwl.coder.c9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

import org.junit.Test;

public class Subset {
    public ArrayList<ArrayList<Integer>> getSubsets(int[] A, int n) {
    	Integer[] nums = new Integer[n];
    	for(int i=0;i<n;i++){
    		nums[i]=new Integer(A[i]);
    	}
    	Arrays.sort(nums,Collections.reverseOrder());
    	ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
    	getSubsets(lists, new ArrayList<Integer>(), nums, n, 0);
    	Collections.sort(lists, new Comparator<ArrayList<Integer>>() {
			@Override
			public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
				StringBuilder sb1 = new StringBuilder();
				for(Integer item:o1){
					sb1.append(item);
				}
				StringBuilder sb2 = new StringBuilder();
				for(Integer item:o2){
					sb2.append(item);
				}
				return sb2.toString().compareTo(sb1.toString());
			}
		});
    	return lists;
    }
    
    /**
     * 采用回溯法实现
     * @param lists
     * @param list
     * @param arr
     * @param n
     * @param pos
     */
    public void getSubsets(ArrayList<ArrayList<Integer>> lists,ArrayList<Integer> list,
    		Integer[] arr,int n,int pos){
    	for(int i=pos;i<n;i++){
    		list.add(arr[i]);
    		lists.add(new ArrayList<Integer>(list));
    		getSubsets(lists,list,arr,n,i+1);
    		list.remove(list.size()-1);
    	}
    }
    
    @Test
    public void test(){
    	System.out.println(getSubsets(new int[]{123,456,789},3));;
    }
}
