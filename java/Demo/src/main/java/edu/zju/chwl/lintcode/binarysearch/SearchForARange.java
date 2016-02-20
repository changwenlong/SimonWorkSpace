package edu.zju.chwl.lintcode.binarysearch;

import java.util.ArrayList;

public class SearchForARange {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> A=new ArrayList<Integer>();		
		A.add(5);
		A.add(7);
		A.add(7);
		A.add(8);
		A.add(8);
		A.add(10);
		System.out.println(searchRange(A,6));
	}

    public static ArrayList<Integer> searchRange(ArrayList<Integer> A, int target) {
    	ArrayList<Integer> list=new ArrayList<Integer>();
    	int a=-1;
    	int b=-1;
        for(int i=0;i<A.size();i++){
        	if(target<A.get(i)){
        		break;
        	}
            if(target==A.get(i)){
            	if(a==-1){
                	a=i;
                	b=i;
            	}else{
            		b++;
            	}
            }
        }
        list.add(a);
        list.add(b);
        return list;
    }
}
