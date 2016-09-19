package edu.zju.chwl.souhu;

import java.util.*;

public class Main1 {
	
	static class People{
		int w,h;

		public People(int w, int h) {
			super();
			this.w = w;
			this.h = h;
		}

		@Override
		public String toString() {
			return "People [w=" + w + ", h=" + h + "]";
		}
		
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int n=in.nextInt();
			People[] ps = new People[n];
			for(int i=0;i<n;i++){
				int num = in.nextInt();
				ps[num-1]=new People(in.nextInt(),in.nextInt());
			}
			Arrays.sort(ps, new Comparator<People>(){
				@Override
				public int compare(People o1, People o2) {
					if((o2.w-o1.w)==0){
						return o1.h-o2.h;
					}
					return o2.w-o1.w;
				}
				
			});
			int[] dp = new int[n];
			Arrays.fill(dp, 1);
			int max=1;
			for(int i=1;i<n;i++){
				for(int j=0;j<i;j++){
					if(ps[i].h<=ps[j].h){
						dp[i] =Math.max(dp[i],dp[j]+1);
					}
				}
				max=Math.max(max, dp[i]);
			}
			System.out.println(max);
		}

	}
}
