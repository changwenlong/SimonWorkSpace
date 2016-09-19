package edu.zju.chwl.didi;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNextInt()) {
			int n = in.nextInt();
			int m = in.nextInt();
			int p = in.nextInt();
			int[][] nums = new int[n][m];
			for(int i=0;i<n;i++){
				for(int j=0;j<m;j++){
					nums[i][j]=in.nextInt();
				}
			}
			HashMap<String, Boolean> map = new HashMap<String,Boolean>();
			map.put(getKey(0,m-1), true);
			ArrayList<String> list = new ArrayList<String>();
			list.add(getKey(0,m-1));
			getEnergy(0,m-1,nums,n,m,map,list,p);
			if(retList.isEmpty()){
				System.out.println("Can not escape!");
			}else{
				print(retList);
			}			
		}

		in.close();
	}

	private static void print(ArrayList<String> list) {
		for(int i=list.size()-1;i>=0;i--){
			System.out.print(list.get(i));
			if(i!=0){
				System.out.print(",");
			}
		}
		
	}

	private static String getKey(int i, int j) {
		return "["+i+","+j+"]";
	}

	public static ArrayList<String> retList = new ArrayList<String>();
	public static int min = Integer.MIN_VALUE;
	
	private static void getEnergy(int i, int j, int[][] nums, int n, int m, HashMap<String, Boolean> map, ArrayList<String> list, int p) {
		if(i<0||i>=n||j<0||j>=m||nums[i][j]==0||p<0){
			return;
		}
		if(i==0&&j==0){
			if(p>min){
				retList=new ArrayList<String>(list);
				min=p;
			}
			return;
		}
		String key = getKey(i-1,j);
		if(map.get(key)==null){
			list.add(key);
			map.put(key, true);
			getEnergy(i-1,j,nums,n,m,map,list,p);
			list.remove(list.remove(list.size()-1));
			map.remove(key);
		}
		key = getKey(i+1,j);
		if(map.get(key)==null){
			list.add(key);
			map.put(key, true);
			getEnergy(i+1,j,nums,n,m,map,list,p-3);
			list.remove(list.remove(list.size()-1));
			map.remove(key);
		}
		key = getKey(i,j-1);
		if(map.get(key)==null){
			list.add(key);
			map.put(key, true);
			getEnergy(i,j-1,nums,n,m,map,list,p-1);
			list.remove(list.remove(list.size()-1));
			map.remove(key);
		}
		key = getKey(i,j+1);
		if(map.get(key)==null){
			list.add(key);
			map.put(key, true);
			getEnergy(i,j+1,nums,n,m,map,list,p-1);
			list.remove(list.remove(list.size()-1));
			map.remove(key);
		}				

	}

}
/*
 4 4 10
 1 0 0 1
 1 1 0 1
 0 1 1 1
 0 0 1 1
 
  4 4 20
 1 0 0 1
 1 1 0 1
 0 1 1 1
 0 0 1 1
 */
