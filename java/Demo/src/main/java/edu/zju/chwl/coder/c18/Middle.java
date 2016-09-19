package edu.zju.chwl.coder.c18;

import java.util.*;

import org.junit.Test;

public class Middle {
    public int[] getMiddle(int[] A, int n) {
        int[] ret = new int[n];
        for(int i=0;i<n;i++){
            ret[i]=offer(A[i]);
        }
        return ret;
    }
    
    PriorityQueue<Integer> minStack= new PriorityQueue<Integer>();
    PriorityQueue<Integer> maxStack= new PriorityQueue<Integer>(Collections.reverseOrder());
    int count = 0;
    
    public int offer(int n){   
        count++;
        if(count%2==0){
            Integer val = maxStack.peek();
            if(val==null||val<=n){          
            	minStack.offer(n);
            }else{
                minStack.offer(maxStack.poll());
                maxStack.offer(n);
            }
        }else{
            Integer val = minStack.peek();
            if(val==null||val>=n){          
            	maxStack.offer(n);
            }else{
                maxStack.offer(minStack.poll());
                minStack.offer(n);
            }    
        }
        return maxStack.peek();
    }
    
    @Test
    public void test(){
    	int[] arr = getMiddle(new int[]{1,2,3,4,5,6},6);
    	for(int i:arr){
    		System.out.print(i+",");
    	}
    }
}