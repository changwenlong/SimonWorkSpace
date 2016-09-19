package edu.zju.chwl.mogujie;

import java.util.*;

public class Main1 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int n = in.nextInt();
			int[] arr = new int[n];
			for(int i=0;i<n;i++){
				arr[i] = in.nextInt();
			}
			System.out.println(moveCnt(arr,n));
		}
	}

	private static int moveCnt(int[] arr, int n) {
		if(n==1)
			return 0;
		int cnt=0;
		for(int i=1;i<n;i++){
			int tmp = arr[i];
			boolean flag=true;
			for(int j=i-1;j>=0;j--){
				if(arr[j]<=tmp){
					flag=false;
					arr[j+1]=tmp;
					break;
				}
				arr[j+1]=arr[j];
				cnt++;
			}
			if(flag)
				arr[0]=tmp;
		}
		return cnt;
	}

}
