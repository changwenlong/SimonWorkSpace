package edu.zju.chwl.wanmei;

import org.junit.Test;

import java.util.*;

public class Main
{
    public static void main(String args[])
    {
        /*Scanner cin = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<Integer>();
        while(cin.hasNext())
        {
            String line= cin.nextLine();
            String[] nums=line.split(" ");
            for(String num:nums){
            	if(!num.matches("\\d+|-\\d+")){
            		System.out.println("error");
            		return;
            	}
            	list.add(Integer.valueOf(num));
            }
        }*/
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	list.add(2);
    	list.add(1);
    	list.add(0);
        if(list.isEmpty()){
        	System.out.println("error");
    		return;
        }
        getNums(list);
    }
    
    private static void getNums(ArrayList<Integer> list) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		int max=0;
		ArrayList<Integer> retVal=null;
		int size = list.size();
		for(int i=0;i<size;i++){
			ArrayList<Integer> ss = new ArrayList<Integer>();
			ss.add(list.get(i));
			res.add(ss);
			int num=list.get(i);
			for(int j=0;j<i;j++){
				if(num>=list.get(j)){
					ArrayList<Integer> arrayList = new ArrayList<Integer>(res.get(j));
					arrayList.add(num);
					if(res.get(i).size()<=arrayList.size()){
						if(arrayList.size()>=max){
							max=arrayList.size();
							retVal = arrayList;
						}
						res.set(i,arrayList);
					}
					
				}
			}
		}
		if(retVal==null){
			retVal=res.get(0);
		}
		for(int i=0;i<retVal.size();i++){
			if(i>0){
				System.out.print(" ");
			}
			System.out.print(retVal.get(i));
		}
	}
}
