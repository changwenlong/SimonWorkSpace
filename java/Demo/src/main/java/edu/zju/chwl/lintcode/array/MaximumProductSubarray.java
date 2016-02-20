package edu.zju.chwl.lintcode.array;

import java.util.ArrayList;
import java.util.HashMap;

import edu.zju.chwl.util.Tools;

public class MaximumProductSubarray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//int[] nums=new int[]{2,-9,3,-2,4,0,3,4,5,-1,3,9,0,3,3,5};
		int[] nums=new int[]{-2};
		Tools.print(new MaximumProductSubarray().maxProduct(nums));
	}
	
    public int maxProduct(int[] nums) {
    	if(nums==null||nums.length==0){
    		return 0;
    	}
    	ArrayList<ArrayList<Integer>> listList = new ArrayList<ArrayList<Integer>>();
    	ArrayList<Integer> sumList = new ArrayList<Integer>();
    	ArrayList<Integer> countList=new ArrayList<Integer>();
    	int count=0;
    	int sum=1;
    	boolean flag=false;
    	for(int item:nums){
    		if(item<=0){
    			if(sum!=1){
    				sumList.add(sum);
    				sum=1;
    			}
    			if(item==0){
    				if(sumList!=null&&!sumList.isEmpty()){
    					listList.add(sumList);
    					sumList=new ArrayList<Integer>();
    					countList.add(count);
    					count=0;
    				}
    			}else{
    				sumList.add(item);
    				count++;
    			}
    		}else{
    			flag=true;
    			sum*=item;
    		}
    	}
    	if(sum!=1){
			sumList.add(sum);
		}
    	if(sumList!=null&&!sumList.isEmpty()){
			listList.add(sumList);
			countList.add(count);
		}
    	System.out.println(listList);
    	System.out.println(countList);
    	int result=nums[0];
    	for(int i=0;i<listList.size();i++){
    		int max=getMax(listList.get(i),countList.get(i));
    		result=result>max?result:max;
    	}
    	if(result<0&&flag){
    		return 1;
    	}else{
    		return result;
    	}
    }

	private int getMax(ArrayList<Integer> list, Integer num) {
		if(list.size()==1){
			return list.get(0);
		}
		int head=1;
		int tail=1;
		int product=1;
		int count=0;
		for(int item:list){
			product*=item;
			if(item<0){
				count++;
				if(count==1){
					head=product;
				}
				if(count==num){
					tail=product/item;
				}
			}
		}
		head=product/head;
		if(num%2==0){
			System.out.println(product);
			return product;
		}else{
			System.out.println(head+":"+tail);
			return head>tail?head:tail;
		}
		
	}

}
