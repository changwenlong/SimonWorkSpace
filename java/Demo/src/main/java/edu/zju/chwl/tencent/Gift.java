package edu.zju.chwl.tencent;


import org.junit.Test;

public class Gift {
    public int getValue(int[] gifts, int n) {
        int count = 1;
        int num = gifts[0];
        for(int i=1;i<n;i++){
        	if(gifts[i]==num){
        		count++;
        	}else{
        		if(count==1){
        			num = gifts[i];
        		}else{
        			count--;
        		}
        	}
        }
        int a=0;
        for(int i:gifts){
        	if(i==num){
        		a++;
        	}
        }
        if(a>n/2){
        	return num;
        }
        return 0;
    }
    
    @Test
    public void test(){
    	System.out.println(getValue(new int[]{1,2,3,2,2},5));
    }
}