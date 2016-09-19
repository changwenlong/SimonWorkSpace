package edu.zju.chwl.jd;

import java.util.*;
import java.util.Map.Entry;


public class Main2 {
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        while(in.hasNextInt())
        {
            int n = in.nextInt();
            int m = in.nextInt();
            ArrayList<Integer> list = new ArrayList<Integer>();
            for(int i=0;i<n;i++){
            	list.add(in.nextInt());
            }
			Collections.sort(list);
			
            HashMap<String, Integer> map = new HashMap<String,Integer>();
            for(int i=0;i<m;i++){
            	String key = in.next();
            	Integer cnt = map.get(key);
            	if(cnt==null){
            		map.put(key, 1);
            	}else{
            		map.put(key, cnt+1);
            	}
            }
            ArrayList<Entry<String, Integer>> goods = new ArrayList<Entry<String,Integer>>(map.entrySet());
			Collections.sort(goods,new Comparator<Entry<String,Integer>>(){
				@Override
				public int compare(Entry<String, Integer> o1,
						Entry<String, Integer> o2) {
					return o2.getValue()-o1.getValue();
				}
            	
            });
			
			int min =0;
			int max =0;
			int pos=0;
			int pos1=list.size()-1;
			for(Entry<String, Integer> entry:goods){
				Integer val = entry.getValue();
				min+=(val*list.get(pos++));
				max+=(val*list.get(pos1--));
			}
			System.out.println(min+" "+max);
        }
        in.close();
    }
}
/*
5 3
4 2 1 10 5
apple
orange
mango
6 5
3 5 1 6 8 1
peach
grapefruit
banana
orange
orange
*/



