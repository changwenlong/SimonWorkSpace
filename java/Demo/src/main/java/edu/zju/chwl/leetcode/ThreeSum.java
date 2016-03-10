package edu.zju.chwl.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/3sum/
 * o(n)
 * 
 * @author chwl
 * @Date 2016年2月28日 上午11:04:05
 */
public class ThreeSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(threeSum(new int[]{-1,0,1,2,-1,-4}));
	}
	
    public static List<List<Integer>> threeSum(int[] nums) {
        if(nums==null||nums.length<3){
        	return Collections.emptyList();
        }
        Arrays.sort(nums);
        List<List<Integer>> arrayList = new ArrayList<List<Integer>>();
        int len = nums.length;
        for(int i=0;i<len;i++){
        	if(i>0&&nums[i]==nums[i-1]){
        		continue;
        	}
        	int right=len-1;
        	for(int j=i+1;j<right;j++){
        		if(j>i+1&&nums[j]==nums[j-1]){
        			continue;
        		}
        		while(right>j){
        			int sum = nums[i]+nums[j]+nums[right];
        			if(sum<=0){
        				if(sum==0){
            				arrayList.add(Arrays.asList(new Integer[]{nums[i],nums[j],nums[right]}));
        				}
        				break;
        			}
        			right--;
        		}
        	}
        }
        
        return arrayList;
        
    }

}
