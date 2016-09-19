package edu.zju.chwl.wangyi2;

import java.util.*;

public class Main1 {

	static int sum = 0,add = 1,mut = 1;;

	public static void main(String[] args) {
			Scanner in = new Scanner(System.in);
			while (in.hasNext()) {
				sum = 0;
				add = 1;
				mut = 1;
				int n = in.nextInt();
				if (n <= 0) {
					System.out.println(0);
					continue;
				}
				int[] arr = new int[n];
				int num = 0;
				for (int i = 0; i < n; i++) {
					arr[i] = in.nextInt();
					if (arr[i] == 1) {
						num++;
					}
				}
				Arrays.sort(arr);
				if (n == 0 || arr[0] > 1) {
					System.out.println(0);
					continue;
				}
				int loc = n;
				for (int i = 1; i < n; i++) {
					add += arr[i];
					mut *= arr[i];
					if (add <= mut) {
						loc = i;
						add -= arr[i];
						mut /= arr[i];
						break;
					}
				}
				sum += add - mut;
				canAdded(0, arr, num, loc, new ArrayList<Integer>());
				System.out.println(sum);
			}
			in.close();

	}
	
	private static void canAdded(int ret, int[] arr, int start, int n, ArrayList<Integer> list) {
			if (start >= n) {
				return;
			}
			for (int i = start; i < n; i++) {
			    ret+=arr[i];
				if(!list.contains(ret)){
					list.add(ret);
				}
				sum+=(add-ret-(mut/ret));
				canAdded(ret, arr, i + 1, n,list);
			}
	}


}
