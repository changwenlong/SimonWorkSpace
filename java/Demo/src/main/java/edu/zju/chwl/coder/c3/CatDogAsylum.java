package edu.zju.chwl.coder.c3;

import java.util.ArrayList;

import org.junit.Test;

public class CatDogAsylum {
    public ArrayList<Integer> asylum(int[][] ope) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        ArrayList<Integer> home = new ArrayList<Integer>();
        for(int[] item:ope){
        	if(item[0]==1){
        		home.add(item[1]);
        	}else{
        		if(item[1]==0&&!home.isEmpty()){
        			list.add(home.remove(0));
        		}
        		if(item[1]==1){
        			for(int i=0;i<home.size();i++){
        				if(home.get(i)>0){
        					list.add(home.remove(i));
        					break;
        				}
        			}
        		}
        		if(item[1]==-1){
        			for(int i=0;i<home.size();i++){
        				if(home.get(i)<0){
        					list.add(home.remove(i));
        					break;
        				}
        			}
        		}
        	}
        }
        return list;
    }
    
	@Test
	public void test() {
		System.out.println(asylum(new int[][]{ {1,1},{1,-1},{2,0},{2,-1} }));
	}
}
