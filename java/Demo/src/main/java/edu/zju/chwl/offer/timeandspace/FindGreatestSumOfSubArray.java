package edu.zju.chwl.offer.timeandspace;

/**
 * 连续字数组最大和
 * 动态规划
 * f(n) 以array[n]结尾的最大子数组和
 * f(0)=array[0]
 * max{f(1)...f(n)}
 * @author a590450
 * @date 30 Mar 2016 16:09:31
 */
public class FindGreatestSumOfSubArray {
	public int findGreatestSumOfSubArray(int[] array) {
		if(array==null||array.length==0){
			return 0;
		}
		int len = array.length;
		int[] f=new int[len];
		f[0]=array[0];
		int max = array[0];
		for(int i=1;i<len;i++){
			if(f[i-1]<0){
				f[i]=array[i];
			}else{
				f[i]=f[i-1]+array[i];
			}
			max=max>f[i]?max:f[i];
		}
		return max;
	}
}
