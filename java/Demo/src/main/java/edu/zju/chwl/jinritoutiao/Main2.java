package edu.zju.chwl.jinritoutiao;

import java.util.*;


public class Main2 {

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        long sum=0;
        int count=0;
        TreeMap<Integer,Integer> map = new TreeMap<Integer,Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2.compareTo(o1);
			}
		});
        for(int i=0;i<n;i++){
        	int a=in.nextInt();
        	int l=in.nextInt();
        	if(a==1){
        		sum+=l;
        		count++;
        		add(map,l);
        		System.out.println(isRectangle(map,sum,count));
        	}else{
        		sum-=l;
        		count--;
        		remove(map,l);
        		System.out.println(isRectangle(map,sum,count));
        	}
        }
	}	
	
	private static void remove(TreeMap<Integer, Integer> map, int l) {
		Integer num = map.get(l);
		if(num==1){
			map.remove(l);
		}else{
			map.put(l, num-1);
		}
		
	}

	private static void add(TreeMap<Integer, Integer> map, int l) {
		Integer num = map.get(l);
		if(num==null){
			map.put(l, 1);
		}else{
			map.put(l, num+1);
		}
	}

	private static String isRectangle(TreeMap<Integer,Integer> map, long sum,int count) {
		if(count<3){
			return "No";
		}
		int max=map.firstKey();
		if((sum-max)<=max){
			return "No";
		}else{
			return "Yes";
		}
	}
}
