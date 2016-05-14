package edu.zju.chwl.offer.timeandspace;

import org.junit.*;

/**
 * 求0到n中1的数量
 * @author a590450
 * @date 31 Mar 2016 11:30:25
 */
public class NumberOf1Between1AndN {
	public int numberOf1Between1AndN(int n) {
    	int k=getDigit(n);
    	int[] f = getCounts(k);    	
    	return getNumbers(n,k,f);
    }
	
	public int getNumbers(int n,int k,int[] f){
		if(n<10){
			if(n==0) return 0;
			return 1;
		}
		int sum = f[k-1];
		int pow = (int)Math.pow(10, k-1);
		int m=n/pow;
		int a=n-m*pow;
    	if(m>1){
    		sum+=(m-1)*f[k-1]+pow;
    	}else{
    		sum+=a+1;
    	}
    	//递归调用
    	sum+=getNumbers(a,k-1,f);
    	return sum;
	}

	/**
	 * 求一个数的位数
	 * @param n
	 * @return
	 */
	private int getDigit(int n) {
		int count=1;
		while(n/10!=0){
			count++;
			n/=10;
		}
		return count;
	}
	
	/**
	 * counts[i] 表示0到最大的K位数中包含的1的个数
	 * f[i] 表示所有K位数中包含的1的个数
	 * 动态规划求解
	 * @param k
	 * @return
	 */
	private int[] getCounts(int k) {
		int[] counts = new int[k+1];
		int[] f = new int[k+1];
		counts[1]=f[1]=1;
		int pow=1;
		for(int i=2;i<=k;i++){
			pow*=10;
			f[i]=9*counts[i-1]+pow;
			counts[i]=counts[i-1]+f[i];
		}
		return counts;
	}
	
	@Test
	public void getCounts(){
		int[] counts = getCounts(5);
		for(int i:counts){
			System.out.println(i);
		}
	}
	
	@Test
	public void numberOf1Between1AndN(){
		int[] counts = new int[]{0,1,11,145};
		for(int i:counts){
			System.out.println(numberOf1Between1AndN(i));
		}
	}
	
}
