package edu.zju.chwl.offer.add;

import org.junit.*;

public class Duplicate {
	
    public boolean duplicate(int numbers[],int length,int [] duplication) {
    	if(length<2){
    		return false;
    	}
    	int pos=0;
    	int value=numbers[0];
    	numbers[0] = -1;
    	while(pos<length){
    		if(value==-1){
    			while(numbers[pos]==pos){
    				pos++;
        			if(pos>=length){	
        				return false;
        			}
    			}
				value=numbers[pos];
				numbers[pos]=-1;    
    		}
    		int temp = numbers[value];
    		if(temp==value){
    			duplication[0]=value;
    			return true;
    		}
    		numbers[value] = value;
    		value = temp;
    	}
    	return false;
    }
    
    //不要想着一气呵成，一步步交换，思路清晰，不易出错
    public boolean duplicate1(int numbers[],int length,int [] duplication) {
    	if(length<2){
    		return false;
    	}
    	for(int i=0;i<length;i++){
    		while(numbers[i]!=i){
    			if(numbers[i]==numbers[numbers[i]]){
    				duplication[0]=numbers[i];
    				return true;
    			}
    			swap(numbers,i,numbers[i]);
    		}
    	}
    	return false;
    }
    
    private void swap(int[] numbers, int i, int j) {
		int temp = numbers[i];
		numbers[i]=numbers[j];
		numbers[j]=temp;
		
	}

	@Test
    public void test(){
    	int[] duplication = new int[1];
		Assert.assertEquals(true, duplicate1(new int[]{2,3, 1,0,2,5,3},7,duplication));
		Assert.assertEquals(2,duplication[0]);
    }
    
    @Test
    public void testFalse(){
    	int[] duplication = new int[1];
		Assert.assertEquals(false, duplicate1(new int[]{2,3, 1,0,5,4,6},7,duplication));
		//Assert.assertEquals(2,duplication[0]);
    }
}
