package edu.zju.chwl.offer.skillsininterview;

import java.util.NoSuchElementException;

import org.junit.*;

/**
 * 查找有序数列中k出现的次数
 * @author chwl
 * @Date 2016年4月1日 下午10:36:27
 */
public class GetNumberOfK {
    public int getNumberOfK(int [] array , int k) {
    	if(array==null||array.length==0){
    		return 0;
    	}
    	int start = binarySearchFirst(array,k);
    	int end = binarySearchLast(array,k);
		return end-start;
    }
    
    //寻找数k的插入位置，值相等时插在前面	
    private int binarySearchFirst(int[] array,int k){
    	if(array==null||array.length==0){
    		return -1;
    	}
    	int start=0,end=array.length-1;
    	while(start<end){
    		int mid = (end-start)/2+start;
    		if(array[mid]>=k){
    			end = mid;
    		}else{
    			start=mid+1;
    		}
    	}
    	if(start==array.length-1&&k>array[start]){
    		start++;
    	}
    	return start;   
    }
    
    //寻找数k的插入位置，值相等时插在后面
    private int binarySearchLast(int[] array,int k){
    	if(array==null||array.length==0){
    		return -1;
    	}
    	int start=0,end=array.length-1;
    	while(start<end){
    		int mid = (end-start)/2+start;
    		if(array[mid]>k){
    			end = mid;
    		}else{
    			start=mid+1;
    		}
    	}
    	if(start==array.length-1&&k>=array[start]){
    		start++;
    	}
    	return start;    		
    }
    
    //二分查找
    private boolean binarySearch(int[] array,int k){
    	if(array==null||array.length==0){
    		return false;
    	}
    	int start=0,end=array.length-1;
    	while(start<end){
    		int mid = (end-start)/2+start;
    		if(array[mid]==k){
    			return true;
    		}else if(array[mid]>k){
    			end = mid;
    		}else{
    			start=mid+1;
    		}
    	}
    	if(array[start]==k){
    		return true;
    	}
    	return false;    		
    }
    
    //找最后一个小于K的数
    private int searchLast(int[] array,int k){
    	if(array==null||array.length==0){
    		return -1;
    	}
    	int start=0,end=array.length-1;
    	while(start<end){
    		int mid = (end-start)/2+start;
    		if(array[mid]>=k){
    			end = mid;
    		}else{
    			start=mid+1;
    		}
    	}
    	if(start==array.length-1&&k>array[start]){
    		start++;
    	}
    	if(start==0){
    		throw new NoSuchElementException();
    	}
    	return array[start-1];
    }
    
    //找第一个大于K的数
    private int searchFirst(int[] array,int k){
    	if(array==null||array.length==0){
    		return -1;
    	}
    	int start=0,end=array.length-1;
    	while(start<end){
    		int mid = (end-start)/2+start;
    		if(array[mid]>k){
    			end = mid;
    		}else{
    			start=mid+1;
    		}
    	}
    	if(start==array.length-1&&k>=array[start]){
    		start++;
    	}
    	if(start==array.length){
    		throw new NoSuchElementException();
    	}
    	return array[start];
    }
    
    @Test
    public void getNumberOfK(){
    	int[] array = new int[]{1,2,3,3,3,3,4,5};
    	Assert.assertEquals(0, getNumberOfK(array,0));
    	Assert.assertEquals(1, getNumberOfK(array,1));
    	Assert.assertEquals(1, getNumberOfK(array,2));
    	Assert.assertEquals(4, getNumberOfK(array,3));
    	Assert.assertEquals(1, getNumberOfK(array,4));
    	Assert.assertEquals(1, getNumberOfK(array,5));
    	Assert.assertEquals(0, getNumberOfK(array,6));
    }
    
    @Test
    public void binarySearch(){
    	int[] array = new int[]{1,2,3,3,3,3,4,5};
    	Assert.assertEquals(false, binarySearch(array,0));
    	Assert.assertEquals(true, binarySearch(array,1));
    	Assert.assertEquals(true, binarySearch(array,2));
    	Assert.assertEquals(true, binarySearch(array,3));
    	Assert.assertEquals(true, binarySearch(array,4));
    	Assert.assertEquals(true, binarySearch(array,5));
    	Assert.assertEquals(false, binarySearch(array,6));
    }
    
    @Test
    public void searchLast(){
    	int[] array = new int[]{1,2,3,3,3,3,5};
    	//Assert.assertEquals(false, searchLast(array,0)); NoSuchElementException
    	//Assert.assertEquals(true, searchLast(array,1)); NoSuchElementException
    	Assert.assertEquals(1, searchLast(array,2));
    	Assert.assertEquals(2, searchLast(array,3));
    	Assert.assertEquals(3, searchLast(array,4));
    	Assert.assertEquals(3, searchLast(array,5));
    	Assert.assertEquals(5, searchLast(array,6));
    }
    
    @Test
    public void searchFirst(){
    	int[] array = new int[]{1,2,3,3,3,3,5};
    	Assert.assertEquals(1, searchFirst(array,0));
    	Assert.assertEquals(2, searchFirst(array,1));
    	Assert.assertEquals(3, searchFirst(array,2));
    	Assert.assertEquals(5, searchFirst(array,3));
    	Assert.assertEquals(5, searchFirst(array,4));
    	//Assert.assertEquals(3, searchFirst(array,5)); NoSuchElementException
    	//Assert.assertEquals(5, searchFirst(array,6)); NoSuchElementException
    }
}
