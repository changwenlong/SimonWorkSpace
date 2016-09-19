package edu.zju.chwl.huawei;

import java.util.*;
import java.util.Map.Entry;

public class Main8 {	
	static class Fault{
		String filename;
		String name;
		int line;
		Fault(String filename,int line){
			this.name=filename;
			this.line=line;
			int start = name.length()-16;
			start=start<0?0:start;
			this.filename=name.substring(start);
		}
		
		@Override
		public int hashCode(){
			return name.hashCode()+line*31;
		}
		
		@Override
		public boolean equals(Object o) {
			Fault fau=(Fault) o;
			return (fau.name.equals(this.name)&&fau.line==this.line);
		}
		
		@Override
		public String toString(){
			return filename+" "+line;
		}
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		LinkedHashMap<Fault, Integer> map = new LinkedHashMap<Fault,Integer>();
		while(in.hasNext()){
			String name=in.next();
			int line=in.nextInt();
			String[] strs=name.split("\\\\");
			String filename =strs[strs.length-1];
			Fault fault = new Fault(filename,line);
			Integer count = map.get(fault);
			if(count==null){
				map.put(fault, 1);
			}else{
				map.put(fault, count+1);
			}
		}
		Set<Entry<Fault, Integer>> entrySet = map.entrySet();
		ArrayList<Entry<Fault, Integer>> list = new ArrayList<Map.Entry<Fault, Integer>>(entrySet);
		Collections.sort(list, new Comparator<Map.Entry<Fault, Integer>>(){
			@Override
			public int compare(Entry<Fault, Integer> o1,
					Entry<Fault, Integer> o2) {
				return o2.getValue().compareTo(o1.getValue());
			}			
		});
		for(int i=0;i<8&&i<list.size();i++){
			Entry<Fault, Integer> entry = list.get(i);
			System.out.println(entry.getKey()+" "+entry.getValue());
		}
	}
}
