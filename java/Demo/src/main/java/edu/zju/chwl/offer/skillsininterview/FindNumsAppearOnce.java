package edu.zju.chwl.offer.skillsininterview;

import org.junit.*;

//数组中只出现一次的数字
public class FindNumsAppearOnce {
	
    public void findNumsAppearOnce(int [] array,int num1[] , int num2[]) {
    	if(array==null||array.length<=1){
    		return;
    	}
    	int num = getPos(eor(array));
    	int a=0,b=0;
    	for(int item:array){
    		if((num^item)==(num+item)){
    			a=a^item;
    		}else{
    			b=b^item;
    		}
    	}
    	num1[0]=a;
    	num2[0]=b;
    }
    
    private int eor(int[] array){
    	if(array==null||array.length==0){
    		return 0;
    	}
    	int result = 0;
    	for(int item:array){
    		result = result^item;
    	}
    	return result;
    }
    
    private int getPos(int num){
    	int a =1;
    	while((num^a)==(num+a)){
    		a=a<<1;
    	}
    	return a;
    }
    
    @Test
    public void test(){
    	int[] array = new int[]{2,4,3,6,3,2,5,5};
    	int[] a = new int[1];
    	int[] b = new int[1];
    	findNumsAppearOnce(array,a,b);
    	System.out.println(a[0]+"  "+b[0]);
    }
}
