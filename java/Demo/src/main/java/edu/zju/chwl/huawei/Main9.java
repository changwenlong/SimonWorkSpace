package edu.zju.chwl.huawei;

import java.util.*;
public class Main9 {	
	static class Poker implements Comparable<Poker>{
		String type;
		Integer num;
		
		public Poker(String type, Integer num) {
			super();
			this.type = type;
			this.num = num;
		}

		@Override
		public int compareTo(Poker o) {
			if(this.type.equals(o.type)){
				return this.num.compareTo(o.num);
			}else{
				if(this.type.equals("za")){
					return 1;
				}
				if(o.type.equals("za")){
					return -1;
				}
				return 0;
			}
		}
		
	}
	
	public static void main(String[] args) {
		String[] types=new String[]{"","ge","","san","za","shun"};
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		map.put("3", 3);
		map.put("4", 4);
		map.put("5", 5);
		map.put("6", 6);
		map.put("7", 7);
		map.put("8", 8);
		map.put("9", 9);
		map.put("10", 10);
		map.put("J", 11);
		map.put("Q", 12);
		map.put("K", 13);
		map.put("A", 14);
		map.put("2", 15);
		map.put("joker", 16);
		map.put("JOKER", 17);
		Scanner in = new Scanner(System.in);
		String line = in.nextLine();
		String[] strs=line.split("-");
		String[] str1=strs[0].split(" ");
		String[] str2=strs[1].split(" ");
		Poker p1=getPoker(types,map,str1);		
		Poker p2=getPoker(types, map, str2);
		int res=p1.compareTo(p2);
		if(res<0){
			System.out.println(strs[1]);
		}else if(res>0){
			System.out.println(strs[0]);
		}else{
			System.out.println("ERROR");
		}
		
	}

	private static Poker getPoker(String[] types, HashMap<String, Integer> map,
			String[] str1) {
		Poker p1;
		if(str1.length!=2){
			p1=new Poker(types[str1.length],map.get(str1[0]));
		}else{
			if(str1[0].equals("joker")){
				p1=new Poker("za",map.get(str1[0]));
			}else{
				p1=new Poker("dui",map.get(str1[0]));
			}
		}
		return p1;
	}
}
