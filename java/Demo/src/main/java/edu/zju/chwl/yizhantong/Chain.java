package edu.zju.chwl.yizhantong;

import java.util.Arrays;

import org.junit.Test;

public class Chain {
    public int findK(int n) {
        if(n<5){
        	return 0;
        }
        int gap=(n-3)/2;
        int[] nums=new int[n];
        Arrays.fill(nums, -1);
        getK(nums,0,0,gap,n);
        return max;
    }
    
	public int findK1(int n) {
		if (n % 3 == 0) {
			return (n - 1) / 2;
		} else {
			return n - (n - 1) / 2;
		}
	}


	int max=Integer.MIN_VALUE;
    
    private void getK(int[] nums, int start, int count, int gap, int n) {
		if(start==n){
			count++;
			max=max>count?max:count;
			return;
		}
		if(nums[start]==1){
			getK(nums,start+1,count,gap,n);
		}
		if(nums[start]==-1){
			int pos1 = (start+gap)%n;
			int pos2 = (start+n-gap)%n;
			if(nums[pos1]!=0&&nums[pos2]!=0){
				nums[start]=0;
				nums[pos1]=1;
				nums[pos2]=1;
				getK(nums,start+1,count+1,gap,n);
			}else{
				nums[start]=1;
				getK(nums,start+1,count,gap,n);
			}
		}				
	}
    
	@Test
	public void test(){
		/*for(int i=7;i<1000;i=i+2){
			int value1 = findK1(i);
			int value2 = findK(i);
			if(value1!=value2){
				System.out.println(i+" findK:"+value2+";findK1:"+value1);
			}
		}*/
		System.out.println(findK(145));
	}
}
