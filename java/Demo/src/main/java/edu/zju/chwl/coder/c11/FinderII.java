package edu.zju.chwl.coder.c11;

import junit.framework.Assert;

import org.junit.Test;

public class FinderII {
    public int findString(String[] str, int n, String x) {
        return find(str,0,n-1,x);
    }
    
    private int find(String[] str,int start,int end, String x){
    	if(start>end){
    		return -1;
    	}
    	int mid = start+(end-start)/2;
    	if(str[mid].isEmpty()){
    		int leftIndex = find(str,start,mid-1,x);
    		if(leftIndex==-1){
    			return find(str,mid+1,end,x);
    		}else{
    			return leftIndex;
    		}
    	}else{
        	if(str[mid].equals(x)){
        		return mid;
        	}else if(str[mid].compareTo(x)>0){
        		return find(str,start,mid-1,x);
        	}else{
        		return find(str,mid+1,end,x);
        	}
        	
    	}
    }
    
    @Test
	public void test() {
    	Assert.assertEquals(3, findString(new String[]{"a","b","","c","","d"},6,"c"));;
    }
}
