package edu.zju.chwl.offer.add;

import org.junit.*;

public class Multiply {
    public int[] multiply(int[] A) {
    	if(A==null||A.length==0){
    		return A;
    	}
    	int len=A.length;
    	int[] C=new int[len];
    	C[0]=1;
    	for(int i=1;i<len;i++){
    		C[i]=A[i-1]*C[i-1];
    	}
    	int[] D=new int[len];
    	D[len-1]=1;
    	for(int i=len-2;i>=0;i--){
    		D[i]=D[i+1]*A[i+1];
    	}
    	int[] B =new int[len];
    	for(int i=0;i<len;i++){
    		B[i]=C[i]*D[i];
    	}
    	return B;
    }
    
    @Test
    public void test(){
    	multiply(new int[]{1,2,3,4,5});
    }
    
}
