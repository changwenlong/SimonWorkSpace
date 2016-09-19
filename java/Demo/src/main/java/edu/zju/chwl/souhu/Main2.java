package edu.zju.chwl.souhu;

import java.util.*;

public class Main2 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			String s1 = in.next();
			String s2 = in.next();
			s1=getString(s1);
			s2=getString(s2);
			if(compareSan(s1, s2)!=-2){//比较三个
				System.out.println(compareSan(s1, s2));
			}else if(compareSun(s1, s2)!=-2){//比较顺子
				System.out.println(compareSun(s1, s2));
			}else if(compareDui(s1, s2)!=-2){//比较对
				System.out.println(compareDui(s1, s2));
			}else {if(s1.compareTo(s2)==0){//比较个子
				System.out.println(0);
			}else if(s1.compareTo(s2)>0){
				System.out.println(1);
			}else if(s1.compareTo(s2)<0){
				System.out.println(-1);
			}}
		}

	}

	private static int compareDui(String s1, String s2) {
		if(s1.charAt(0)-s1.charAt(1)==0||s1.charAt(1)-s1.charAt(2)==0){
			if(s2.charAt(0)-s2.charAt(1)==0||s2.charAt(1)-s2.charAt(2)==0){
				String a = "";
				if(s1.charAt(0)==s1.charAt(1)){
					a=""+s1.charAt(0)+s1.charAt(2);
				}else{
					a=""+s1.charAt(1)+s1.charAt(0);
				}
				String b = "";
				if(s2.charAt(0)==s2.charAt(1)){
					b=""+s2.charAt(0)+s2.charAt(2);
				}else{
					b=""+s2.charAt(1)+s2.charAt(0);
				}
				int temp=a.compareTo(b);
				if(temp==0){
					return 0;
				}else{
					return temp/Math.abs(temp);
				}
			}else{
				return 1;
			}
		}else if(s2.charAt(0)-s2.charAt(1)==0||s2.charAt(1)-s2.charAt(2)==0){
			return compareDui(s2,s1)*-1;
		}
		return -2;
		
	}

	private static int compareSun(String s1, String s2) {
		if(s1.charAt(0)-s1.charAt(2)==-2){
			if(s2.charAt(0)-s2.charAt(2)==-2){
				if((s1.charAt(0)-s2.charAt(0))==0){
					return 0;
				}else if((s1.charAt(0)-s2.charAt(0))>0){
					return 1;
				}else{
					return -1;					
				}
			}else{
				return 1;
			}
		}else if(s2.charAt(0)-s2.charAt(2)==-2){
			return compareSun(s2,s1)*-1;
		}
		return -2;
	}

	private static int compareSan(String s1, String s2) {
		if(s1.charAt(0)-s1.charAt(2)==0){
			if(s2.charAt(0)-s2.charAt(2)==0){
				if((s1.charAt(0)-s2.charAt(0))==0){
					return 0;
				}else if((s1.charAt(0)-s2.charAt(0))>0){
					return 1;
				}else{
					return -1;					
				}
			}else{
				return 1;
			}
		}else if(s2.charAt(0)-s2.charAt(2)==0){
			return compareSan(s2,s1)*-1;
		}
		return -2;
	}

	private static String getString(String s1) {
		Character[] chs =new Character[3];
		int count=0;
		for(int i=3;i<s1.length();i++){
			chs[count++]='i';
		}
		for(char ch:s1.toCharArray()){
			if(ch>='2'&&ch<='9'){
				chs[count++]=(char)(ch-'2'+'a');
			}else if(ch=='J'){
				chs[count++]='j';
			}else if(ch=='Q'){
				chs[count++]='k';
			}else if(ch=='K'){
				chs[count++]='l';
			}else if(ch=='A'){
				chs[count++]='m';
			}
		}
		Arrays.sort(chs, Collections.reverseOrder());
		String ret="";
		for(int i=0;i<3;i++){
			ret+=chs[i];
		}
		return ret;
	}
}
