package edu.zju.chwl.tencent;

import java.util.*;

public class Main1 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			String str=in.next();
			int len = str.length();
			System.out.println(len-getLongestCommonLen(str,len));;
		}

	}

	private static int getLongestCommonLen(String str1,int n) {
		String str2 = getReverseStr(str1,n);
		int[][] dp = new int[n+1][n+1];
		if(str1.charAt(0)==str2.charAt(0)){
			dp[1][1]=1;
		}
		for(int i=1;i<=n;i++){
			for(int j=1;j<=n;j++){
				if(str1.charAt(i-1)==str2.charAt(j-1)){
					dp[i][j]=dp[i-1][j-1]+1;
				}else{
					dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		return dp[n][n];
	}

	private static String getReverseStr(String str1, int n) {
		StringBuilder sb = new StringBuilder();
		for(int i=n-1;i>=0;i--){
			sb.append(str1.charAt(i));
		}
		return sb.toString();
	}
}
