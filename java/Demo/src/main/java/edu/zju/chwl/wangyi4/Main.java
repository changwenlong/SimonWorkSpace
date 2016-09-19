package edu.zju.chwl.wangyi4;

import java.util.*;

public class Main {

	private static int ret;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNextInt()) {
			ret=0;
			int n = in.nextInt();
			getNum(n);
			System.out.println(ret);
		}

		in.close();
	}

	private static char[] getNum(int n) {
		String sb = new String();
		dfs(sb,0,n);
		return null;
	}

	private static void dfs(String sb, int start, int n) {
		if(start==n){
			ret++;
			return;
		}
		for(char i='A';i<'D';i++){
			if(start>1&&isNotBlack(sb.charAt(start-1),sb.charAt(start-2),i)){
				continue;
			}
			sb+=i;
			dfs(sb,start+1,n);
			sb=sb.substring(0, sb.length()-1);
		}
		
	}

	private static boolean isNotBlack(char charAt, char charAt2, char i) {
		HashSet<Character> set = new HashSet<Character>();
		set.add(charAt);
		set.add(charAt2);
		set.add(i);
		return set.size()==3;
	}

}
/*
 2
 3
 */
