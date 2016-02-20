package edu.zju.chwl.leishu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		List<String> destList=new ArrayList<String>();
		List<String> searchList=new ArrayList<String>();
		int a=0;
        while(in.hasNext()) {
        	a++;
        	if(a%2==1){
        		destList.add(in.nextLine());
        	}else{
        		searchList.add(in.nextLine());
        	}        	        	
        }
        int index=0;
        for(String str:destList){
        	Main.getLevel(str, searchList.get(index++));
        	System.out.println();
        }
        
	}
	public static void getLevel(String str,String target){
		int curLevel=1;
		int fromIndex=0;
		int targetIndex=-1;
		Set<Integer> set=new TreeSet<Integer>();
		while((targetIndex=str.indexOf(target, fromIndex))!=-1){
			for(int i=fromIndex;i<targetIndex;i++){
				if(str.charAt(i)=='{'){
					curLevel++;
				}else if(str.charAt(i)=='}'){
					curLevel--;
				}				
			}
			fromIndex=targetIndex+target.length();
			set.add(curLevel);
		}
		int count=0;
		for(int item:set){
			if(count++!=0){
				System.out.print(",");
			}
			System.out.print(item);
		}
		if(set.isEmpty()){
			System.out.println(-1);
		}
	}

}
