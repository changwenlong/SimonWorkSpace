package edu.zju.chwl.offer.timeandspace;

import java.util.Arrays;
import java.util.Comparator;
import org.junit.*;

/**
 * 把数组排成最小的数
 * 
 * 最重要的是确定大小比较规则
 * 
 * mn>nm -> m>n
 * mn<nm -> m<n
 * mn=nm -> m=n
 * 
 * @author a590450
 * @date 31 Mar 2016 14:16:24
 */
public class MinNumber {
    public String printMinNumber(int [] numbers) {
		if(numbers==null||numbers.length==0){
    		return "";
    	}
    	int len = numbers.length;
    	Integer[] nums = new Integer[len];
    	for(int i=0;i<len;i++){
    		nums[i]=numbers[i];
    	}
    	//注意比较器的定义
    	Arrays.sort(nums, new Comparator<Integer>(){
			@Override
			public int compare(Integer o1, Integer o2) {			
				return (""+o1+o2).compareTo(""+o2+o1);
			}    		
    	});
    	StringBuilder sb = new StringBuilder();
    	for(Integer i:nums){
    		sb.append(i);
    	}
    	return sb.toString();
    }
    
    @Test
    public void printMinNumber(){
    	Assert.assertEquals("321323", printMinNumber(new int[]{3,32,321}));
    }
}
