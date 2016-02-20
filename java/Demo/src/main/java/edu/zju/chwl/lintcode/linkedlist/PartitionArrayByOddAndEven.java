package edu.zju.chwl.lintcode.linkedlist;

public class PartitionArrayByOddAndEven {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public void partitionArray(int[] nums) {
    	if(nums==null||nums.length==0){
    		return;
    	}
    	int len=nums.length;
        int pos=1;
        int size=1;
        while(size<=len){
        	int empty=pos;
        	int emptyPos;
        	if(empty%2==1){
        		
        	}else{
        		emptyPos=empty*2;
        	}
        }
    }

}
