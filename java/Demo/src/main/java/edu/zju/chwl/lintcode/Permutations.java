package edu.zju.chwl.lintcode;

import java.util.*;

public class Permutations {
	public static void main(String[] args){
		ArrayList<Integer> list=new ArrayList<Integer>();
		list.add(1);
		list.add(1);
		list.add(2);
		ArrayList<ArrayList<Integer>> resultList=permute(list);
		System.out.print(resultList);
	}
	
    public static ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> nums) {
        // write your code here
    	ArrayList<ArrayList<Integer>> resultList=new ArrayList<ArrayList<Integer>>();
    	if(nums==null){
    		return resultList;
    	}
    	if(nums.size()==1){
    		resultList.add(nums);
    		return resultList;
    	}
    	int first=nums.get(0);
    	nums.remove(0);
    	for(ArrayList<Integer> item:permute(nums)){
    		for(int i=0;i<=item.size();i++){
    			if(i==0||first!=item.get(i-1)){
        			@SuppressWarnings("unchecked")
					ArrayList<Integer> tempItem=(ArrayList<Integer>) item.clone();
        			tempItem.add(i,first);
        			resultList.add(tempItem);
    			}
    		}
    	}
    	HashSet<ArrayList<Integer>> resultSet=new HashSet<ArrayList<Integer>>(resultList);
    	return new ArrayList<ArrayList<Integer>>(resultSet);
    }
    
}
