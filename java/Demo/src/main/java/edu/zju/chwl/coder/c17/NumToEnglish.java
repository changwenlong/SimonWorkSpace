package edu.zju.chwl.coder.c17;

import org.junit.Test;

public class NumToEnglish {
	
	public static final String[] s1 = new String[] { "","One", "Two", "Three", "Four", "Five",
			"Six", "Seven", "Eight", "Nine" };
	public static final String[] s2 = new String[] { "Ten","Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen",
			"Sixteen", "Seventeen", "Eighteen", "Nineteen" };
	public static final String[] s3 = new String[] { "Twenty",  "Thirty", "Forty", "Fifty",
			"Sixty", "Seventy", "Eighty", "Ninety" };
	
	public static final String[] unit = new String[]{""," Thousand"," Million"," Billion"};
	private static final Object HUNDRED = "Hundred";
	
	
	public String toString(int x) {
		String s = x+"";
		StringBuilder sb = new StringBuilder();
		int len = s.length();
		int mod = len%3;
		int n = (len-1)/3;
		for(int i=0;i<=n;i++){
			int start = 0;
			int end = 0;
			if(i==0){
				start = 0;
				end = mod==0?3:mod;
			}else{
				int j=i;
				if(mod==0){
					j++;
				}
				start = (j-1)*3+mod;
				end = j*3 +mod;
			}
			String str = toString(s.substring(start,end));
			if(!str.isEmpty())
				sb.append(str).append(unit[n-i]).append(",");
		}
		return sb.substring(0, sb.length()-1);
	}
	
	public String toString(String s){
		Integer num = new Integer(s);
		if(num==0) return "";
		StringBuilder sb = new StringBuilder();
		int a = num/100;
		if(a!=0){
			sb.append(s1[a]).append(" ").append(HUNDRED).append(" ");
		}
		num%=100;
		if(num==0) return sb.toString();
		int b = num/10;
		if(b==0){
			sb.append(s1[num]);
		}else if(b==1){
			sb.append(s2[num%10]);
		}else{
			sb.append(s3[b-2]).append(" ").append(s1[num%10]);
		}
		return sb.toString().trim();
	}
	
	@Test
	public void test(){
		String[] ss = new String[]{"234","204","1","40"};
		for(String s:ss){
			System.out.println(toString(s));
		}
	}
	
	@Test
	public void test1(){
		Integer[] nums = new Integer[]{390051,204,211,22,1000,1000000};
		for(Integer num:nums){
			System.out.println(toString(num));
		}
	}
}
