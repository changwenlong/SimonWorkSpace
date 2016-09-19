package edu.zju.chwl.coder.c5;

import org.junit.Test;
/**
 * Integer.bitCount(x); 获取整数x二进制表示中1的个数
 * @author chwl
 * @Date 2016年5月15日 下午4:27:21
 */
public class CloseNumber {
    public int[] getCloseNumber(int x) {
    	int[] nums=new int[2];
        int n = Integer.bitCount(x);
        for(int i=x-1;i>=0;i--){
        	if(Integer.bitCount(i)==n){
        		nums[0]=i;
        		break;
        	}
        }
        for(int i=x+1;;i++){
        	if(Integer.bitCount(i)==n){
        		nums[1]=i;
        		break;
        	}
        }
        return nums;
    }
    
    @Test
    public void test(){
    	System.out.println(getCloseNumber(2));
    }
}
