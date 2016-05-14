package edu.zju.chwl.coder.c3;

import java.util.ArrayList;

import org.junit.Test;

public class SetOfStacks {
	
    public ArrayList<ArrayList<Integer>> setOfStacks(int[][] ope, int size) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
        int count=0;
        for(int[] item:ope){
        	if(item[0]==1){
        		int val = item[1];
                int pos=count/size;
        		count++;
        		if(lists.size()<=pos){
        			ArrayList<Integer> list = new ArrayList<Integer>();
        			list.add(val);
        			lists.add(list);
        		}else{
        			lists.get(pos).add(val);
        		}
        	}else{
        		count--;
        		int pos=count/size;
        		int index = count%size;
        		lists.get(pos).remove(index);
        	}
        }
        for(int i=count/size+1;i<lists.size();i++){
        	lists.remove(i);
        }
        return lists;
    }
    
    @Test
	public void test() {
		System.out.println(setOfStacks(new int[][] { { 1, 97868 },
				{ 1, 69995 }, { 1, 28525 }, { 1, 72341 }, { 1, 86916 },
				{ 1, 5966 }, { 2, 58473 }, { 2, 93399 }, { 1, 84955 },
				{ 1, 16420 }, { 1, 96091 }, { 1, 45179 }, { 1, 59472 },
				{ 1, 49594 }, { 1, 67060 }, { 1, 25466 }, { 1, 50357 },
				{ 1, 83509 }, { 1, 39489 }, { 2, 51884 }, { 1, 34140 },
				{ 1, 8981 }, { 1, 50722 }, { 1, 65104 }, { 1, 61130 },
				{ 1, 92187 }, { 2, 2191 }, { 1, 2908 }, { 1, 63673 },
				{ 2, 92805 }, { 1, 29442 } }, 2));
	}
}
