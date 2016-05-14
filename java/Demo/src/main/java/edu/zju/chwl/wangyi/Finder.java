package edu.zju.chwl.wangyi;

import org.junit.Test;

/**
 * http://www.nowcoder.com/question/next?pid=1429468&qid=44579&tid=2876312
 * 
 * 快排的partition还是要整理一下
 * 
 * @author chwl
 * @Date 2016年3月30日 上午12:52:45
 */
public class Finder {

	public int findKth(int[] a, int n, int K) {
		return find(a, 0, n - 1, n - K);
	}

	private int find(int[] a, int start, int end, int k){
		if(start==end){
			return a[start];
		}
		int small = partition(a, start, end);
		if (k == small) {
			return a[k];
		} else if (k > small) {
			return find(a, small + 1, end, k);
		} else {
			return find(a, start, small - 1, k);
		}
	}
	
	private int partition(int[] a, int start, int end) {
		int small=start-1;
		for(int i=start;i<end;i++){
			if(a[i]<a[end]){
				small++;
				if(i!=small){
					swap(a,small,i);
				}
			}
		}
		small++;
		swap(a,small,end);
		return small;
	}

	private void swap(int[] a, int small, int i) {
		int temp=a[i];
		a[i]=a[small];
		a[small]=temp;		
	}

	@Test
	public void test() {
		for(int i=0;i<49;i++){
			System.out.println(findKth(new int[] { 1332802, 1177178, 1514891,
					871248, 753214, 123866, 1615405, 328656, 1540395, 968891,
					1884022, 252932, 1034406, 1455178, 821713, 486232, 860175,
					1896237, 852300, 566715, 1285209, 1845742, 883142, 259266,
					520911, 1844960, 218188, 1528217, 332380, 261485, 1111670,
					16920, 1249664, 1199799, 1959818, 1546744, 1904944, 51047,
					1176397, 190970, 48715, 349690, 673887, 1648782, 1010556,
					1165786, 937247, 986578, 798663 }, 49, i+1));
		}
	}

}
