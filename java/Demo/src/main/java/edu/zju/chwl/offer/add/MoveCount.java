package edu.zju.chwl.offer.add;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/**
 * 机器人的运动范围
 * 回溯法
 * @author chwl
 * @Date 2016年4月23日 下午9:13:38
 */
public class MoveCount {

    public int movingCount(int threshold, int rows, int cols)
    {
    	if(rows==0||cols==0||threshold==0){
    		return 0;
    	}
    	boolean[] flags=new boolean[rows*cols];
    	Arrays.fill(flags, false);
    	return movingCount(threshold,rows,cols,0,0,flags);
    }
    
	private int movingCount(int threshold, int rows, int cols, int i, int j, boolean[] flags) {
		int pos=cols*i+j;
		if(getSum(i,j)>threshold||i<0||i>=rows||j<0||j>=cols||flags[pos]){
			return 0;
		}
		flags[pos]=true;
		return 1+movingCount(threshold, rows, cols,i-1,j,flags)+
				movingCount(threshold, rows, cols,i+1,j,flags)+
				movingCount(threshold, rows, cols,i,j-1,flags)+
				movingCount(threshold, rows, cols,i,j+1,flags);
	}

	private int getSum(int i, int j) {
		int sum=0;
		while(i!=0){
			sum+=i%10;
			i=i/10;
		}
		while(j!=0){
			sum+=j%10;
			j=j/10;
		}
		return sum;
	}

    @Test
    public void test(){
		Assert.assertEquals(21,movingCount(5,10,10));
		Assert.assertEquals(79,movingCount(15,100,1));
    }
}
