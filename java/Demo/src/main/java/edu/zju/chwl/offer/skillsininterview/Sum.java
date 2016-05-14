package edu.zju.chwl.offer.skillsininterview;

//两个数的和
public class Sum {

	public int sum(int a,int b){
		int c=(a&b)<<1;
		int d=a^b;
		if((c&d)==0){
			return c|d;
		}else{
			return sum(c,d);
		}
	}
}
