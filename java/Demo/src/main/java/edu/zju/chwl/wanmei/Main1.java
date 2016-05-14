package edu.zju.chwl.wanmei;

import java.util.*;

public class Main1
{
    public static void main(String args[])
    {
        Scanner cin = new Scanner(System.in);
        while(cin.hasNextLine())
        {

            ArrayList<Integer> list = new ArrayList<Integer>();
            String line= cin.nextLine();
            String[] nums=line.split(" ");
            boolean flag=true;
            for(String num:nums){
            	if(!num.matches("\\d+|-\\d+")){
            		flag=false;
            		break;
            	}
            	list.add(Integer.valueOf(num));
            }
            
            if(!flag||list.isEmpty()){
            	System.out.println("error");
            }else{
            	getNums(list);
            	System.out.println();
            }
            	
        }
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
