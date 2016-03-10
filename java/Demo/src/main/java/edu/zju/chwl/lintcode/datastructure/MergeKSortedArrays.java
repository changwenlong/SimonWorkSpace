package edu.zju.chwl.lintcode.datastructure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * http://www.lintcode.com/en/problem/merge-k-sorted-arrays/
 * 归并排序实现
 * @author a590450
 * @date 1 Mar 2016 17:25:53
 */
public class MergeKSortedArrays {
	
	public static void main(String[] args){
		List<Integer> result = mergekSortedArrays(new int[][]{new int[]{1,3,5,7},new int[]{2,4,6},new int[]{0, 8, 9, 10, 11}});
		for(int item:result){
			System.out.println(item);
		}
	}

    /**
     * @param arrays k sorted integer arrays
     * @return a sorted array
     */
    public static List<Integer> mergekSortedArrays(int[][] arrays) {
        if(arrays==null||arrays.length==0){
        	return Collections.emptyList();
        }        
        int[] ints=helper(arrays,0,arrays.length-1);
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int item:ints){
        	list.add(item);
        }
        return list;
    }
    
    private static int[] helper(int[][] arrays,int start,int end){
    	if(start==end){
    		return arrays[start];
    	}
    	int mid = start + (end-start)/2;
    	return merge(helper(arrays,start,mid),helper(arrays,mid+1,end));
    }

	private static int[] merge(int[] is, int[] is2) {
		if(is==null||is.length==0){
			return is2;
		}
		if(is2==null||is2.length==0){
			return is;
		}
		int len1=is.length;
		int len2=is2.length;
		int[] result = new int[len1+len2];
		int i=0,j=0,index=0;
		while(i<len1&&j<len2){
			if(is[i]<is2[j]){
				result[index++]=is[i++];
			}else{
				result[index++]=is2[j++];
			}
		}
		if(i<len1){
			for(;i<len1;i++){
				result[index++]=is[i];
			}
		}
		if(j<len2){
			for(;j<len2;j++){
				result[index++]=is2[j];
			}
		}
		return result;
	}
    
    
}
