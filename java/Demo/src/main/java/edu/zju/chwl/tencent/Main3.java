package edu.zju.chwl.tencent;

import java.util.*;

public class Main3 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int n=in.nextInt();
			int[] nums=new int[n];
			for(int i=0;i<n;i++){
				nums[i]=in.nextInt();
			}
			Arrays.sort(nums);
			int minCount=1;
			int min = nums[1]-nums[0];
			int continus=min==0?1:0;
			int pos = 1;
			for(int i=2;i<n;i++){
				int value = nums[i]-nums[i-1];
				if(value<min){
					if(value==0){
						pos=i;
						continus=1;
					}
					minCount=1;
					min=value;
				}else if(value==min){
					if(min==0&&i==pos+1){
						pos=i;
						continus++;
						minCount+=continus;
					}else{
						minCount++;
						continus=1;
						pos=i;
					}
				}
			}
			int a=1;
			int firstDup=1;
			while(a<n&&nums[a]==nums[a-1]){
				firstDup++;
				a++;
			}
			a=n-2;
			int lastDup=1;
			while(a>=0&&nums[a]==nums[a+1]){
				lastDup++;
				a--;
			}
			int maxCount=firstDup*lastDup;
			System.out.println(minCount+" "+maxCount);
		}

	}

}
