package edu.zju.chwl.offer.microsoft;

import org.junit.Test;

public class Main1 {

	@Test
	public void test() {
		System.out.println(findMid(new int[]{0,2,4,6,8,10}));

	}
	
	int partition(int start,int end,int [] arr){
	      int pos = start-1;
	      int value = arr[end];
	      for(int i=start;i<end;i++){
	            if(arr[i]<value){
	               pos++;
	               if(pos!=i){
	                    swap(arr,i,pos);
	               }   
	           }
	      }
	      pos++;
	      swap(arr,pos,end);
	      return pos;
	}

	void swap(int[] arr,int i,int j){
	       int tmp = arr[i];
	       arr[i]=arr[j];
	       arr[j]=tmp;
	}

	int sort(int start,int end,int[] arr){
	      int mid = (arr.length)/2;
	      int index = partition(start,end,arr);
	      if(index==mid){
	               return mid;
	      } else if(index>mid){
	               return sort(start,index-1,arr);
	      } else{
	               return sort(index+1,end,arr);
	      }
	}

	int findMid(int[] arr){
	       int pos = sort(0,arr.length-1,arr);
	       if(arr.length%2==0){
	    	   return (arr[pos]+arr[pos-1])/2;
	       }else{
	    	   return arr[pos];
	       }
	}

}
