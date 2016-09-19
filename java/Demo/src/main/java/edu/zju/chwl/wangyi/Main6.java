package edu.zju.chwl.wangyi;

import java.util.*;

public class Main6 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int n = in.nextInt();
			int s = in.nextInt();
			int l = in.nextInt();
			int per = (l+1)/(s+1);
			if(per%13==0){
				per--;
			}
			int mod = n%per;
			int num = n/per;
			if(mod==0){
				System.out.println(num);
			}else{
				num++;
				if(mod%13==0&&((mod+1==per)||num==1)){
					num++;
				}
				System.out.println(num);
			}
		}

	}

}
