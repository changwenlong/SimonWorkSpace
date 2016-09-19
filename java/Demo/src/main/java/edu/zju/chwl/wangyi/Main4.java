package edu.zju.chwl.wangyi;

import java.util.Scanner;

public class Main4 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int n = in.nextInt();
			int m = in.nextInt();
			int k = in.nextInt();
			int[][] nums = new int[n][m];
			for(int i=0;i<k;i++){
				nums[in.nextInt()-1][in.nextInt()-1]++;
			}
			int[] sums = new int[400];
			int count=0;
			int nSize = n<3?1:n-2;
			int mSize = m<3?1:m-2;
			for(int i=0;i<nSize;i++){
				for(int j=0;j<mSize;j++){
					sums[count++]=getSum(nums,i,j,n,m);
				}
			}
			int max = sums[0];
			for(int i=0;i<count;i++){
				for(int j=i+1;j<count;j++){
					max=Math.max(max, getNum(nums,i,j,sums,m,n));
				}
			}
			System.out.println(max);
		}

	}
	
	/**
	 * 获取最多蘑菇并去重
	 * @param nums
	 * @param i
	 * @param j
	 * @param sums
	 * @param n
	 * @param m
	 * @return
	 */
	private static int getNum(int[][] nums, int i, int j, int[] sums, int n,int m) {
		int nSize = n<3?1:n-2;
		int a = Math.min(2+i/nSize,m-1);
		int b = Math.min(i%nSize+2,n-1);
		int c=j/nSize;
		int d=j%nSize;
		int dup=0;
		if(Math.abs(a-c)>4||Math.abs(b-d)>4){
			return sums[i]+sums[j];
		}
		for(int i1=c;i1<=a;i1++){
			for(int j1=d;j1<=b;j1++){
				if(nums[i1][j1]==1)
					dup++;
			}
		}
		return sums[i]+sums[j]-dup;
	}

	private static int getSum(int[][] nums, int row, int col,int n,int m) {
		int sum=0;
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++ ){
				if(row+i>n-1||col+j>m-1) continue;
				if(nums[row+i][col+j]>0)
					sum++;
			}
		}
		return sum;
	}

}
