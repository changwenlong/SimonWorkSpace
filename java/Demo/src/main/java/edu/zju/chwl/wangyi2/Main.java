package edu.zju.chwl.wangyi2;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] arr = new int[n];
		HashMap<Integer, Boolean> map = new HashMap<Integer,Boolean>();
		HashMap<Integer, Boolean> coundMap = new HashMap<Integer,Boolean>();
		for (int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
			map.put(arr[i],true);
		}
		Arrays.sort(arr);
		int ret = 0;
		canAdded(0, arr, 0, n,coundMap);
		while (true) {
			ret++;			
			if(map.get(ret)!=null||coundMap.get(ret)!=null){
				continue;	
			} else{
				System.out.println(ret);
				return;
			}
			
		}
	}

	private static void canAdded(int ret, int[] arr, int start, int n, HashMap<Integer, Boolean> coundMap) {
		if (start >= n) {
			return;
		}
		for (int i = start; i < n; i++) {
			if(i!=start&&arr[i]==arr[i-1]){
				continue;
			}
			int val = ret+arr[i];
			coundMap.put(val,true);
			canAdded(val, arr, i + 1, n,coundMap);
		}
	}
}
