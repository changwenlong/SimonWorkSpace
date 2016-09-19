package edu.zju.chwl.coder.c11;

import junit.framework.Assert;

import org.junit.Test;

public class Finder {
    public int findElement(int[] A, int n, int x) {
        return find(A,0,n-1,n,x);
    }
    
    private int find(int[] arr,int start,int end,int n,int x){
        int mid = start+(end-start)/2;
        if(arr[mid]==x) return mid;
        if(arr[end]>arr[mid]){
            if(x>arr[mid]&&x<=arr[end]){
                return find(arr,mid+1,end,n,x);
            }else{
                return find(arr,start,mid-1,n,x);
            }
        }else{
            if(x>arr[end]&&x<arr[mid]){
                return find(arr,start,mid-1,n,x);
            }else{
                return find(arr,mid+1,end,n,x);
            }
        }
    }
    
    @Test
	public void test() {
    	Assert.assertEquals(0, findElement(new int[]{6,1,2,3,4,5},6,6));;
    }
}
