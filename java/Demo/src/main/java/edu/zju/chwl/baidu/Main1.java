package edu.zju.chwl.baidu;

import java.util.*;

public class Main1 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int n = in.nextInt();
			ArrayList<Process> list = new ArrayList<Process>();
			HashMap<Character, Integer> headMap = new HashMap<Character,Integer>();
			HashMap<Character, Integer> tailMap = new HashMap<Character,Integer>();
			int count=0;
			for(int i=0;i<n;i++){
				String str = in.next();
				Character start=str.charAt(0);
				Character end = str.charAt(str.length()-1);
				Integer a = tailMap.get(start);
				boolean aFlag=false;
				boolean bFlag=false;
				if(a==null){
					aFlag=true;
				}else{
					tailMap.put(start, a-1);
				}
				Integer b = tailMap.get(end);
				if(b==null){
					bFlag=true;
				}else{
					headMap.put(end, b-1);
				}
				if(aFlag){
					headMap.put(start, 1);
				}
				if(bFlag){
					tailMap.put(end, 1);
				}
			}
			int sum=0;
			for(Integer item:headMap.values()){
				sum+=item;
			}
			for(Integer item:tailMap.values()){
				sum+=item;
			}
			if(sum==2){
				System.out.println("Yes");
			}else{
				System.out.println("No");
			}
		}
			
	}
	

}
