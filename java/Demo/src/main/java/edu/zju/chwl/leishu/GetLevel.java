package edu.zju.chwl.leishu;

import java.util.Set;
import java.util.TreeSet;

public class GetLevel {

	public static void main(String[] args) {
		String str="Fruit{apple{shape,color},orange{color,price},color}";
		String target="color";
		GetLevel.getLevel(str, target);

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
	}
}
