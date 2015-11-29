package edu.zju.chwl.lintcode.dp;

public class JumpGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new JumpGame().canJump(new int[]{2,3,1,1,4}));
		System.out.println(new JumpGame().canJump(new int[]{3,2,1,0,4}));
	}

    public boolean canJump(int[] A) {
    	int len =A.length;
    	int[] f=new int[len-1];
    	for(int i=0;i<len-1;i++){
    		f[i]=i+A[i];
    	}
    	int max=Integer.MIN_VALUE;
    	for(int i=0;i<len-1;i++){
    		max=max>f[i]?max:f[i];
    		if(i>=max){
    			return false;
    		}
    	}
        return max>=(len-1);
    }
}
