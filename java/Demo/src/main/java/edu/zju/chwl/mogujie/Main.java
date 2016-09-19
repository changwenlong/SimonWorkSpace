package edu.zju.chwl.mogujie;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int n = in.nextInt();
			int[] ls = new int[n];
			int[] ds = new int[n];
			for(int i=0;i<n;i++){
				ls[i] = in.nextInt();
			}
			int sum = 0;
			for(int i=0;i<n;i++){
				ds[i] = in.nextInt();
				sum+=ds[i];
			}
			Point[] ps = new Point[n];
			for(int i=0;i<n;i++){
				ps[i] = new Point(ls[i],ds[i]);
			}
			Point[] arr = Arrays.copyOf(ps, n);
			Arrays.sort(arr,new Comparator<Point>() {
				@Override
				public int compare(Point o1, Point o2) {
					return (o1.d-o2.d)==0?(o1.l-o2.l):(o1.d-o2.d);
				}
			});
			Arrays.sort(ps,new Comparator<Point>() {
				@Override
				public int compare(Point o1, Point o2) {
					return o1.l-o2.l;
				}
			});
			int l = ps[n-1].l;
			int d = ps[n-1].d;
			int cnt=1;
			int ret = 0;
			for(int i=n-2;i>=0;i--){
				if(ps[i].l==l){
					cnt++;
					d+=ps[i].d;
				}else{
					d+=findMax(arr,l,cnt-1);
					ret = Math.max(ret, d);
					l=ps[i].l;
					d=ps[i].d;
					cnt=1;
				}
			}
			ret = Math.max(ret, d);
			System.out.println(sum-ret);
		}
	}
	
	private static int findMax(Point[] arr, int l, int cnt) {
		int num=0;
		if(cnt==0)
			return 0;
		for(int i=arr.length-1;i>=0;i--){
			if(arr[i].l<l){
				num+=arr[i].d;
				cnt--;
				if(cnt==0)
					break;
			}
		}
		return num;
	}

	public static class Point{
		public int l,d;
		
		public Point(int a,int b){
			this.l=a;
			this.d=b;
		}

		@Override
		public String toString() {
			return "[" + l + "," + d + "]";
		}
	}

}
