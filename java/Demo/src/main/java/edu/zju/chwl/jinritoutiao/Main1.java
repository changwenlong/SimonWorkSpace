package edu.zju.chwl.jinritoutiao;

import java.util.*;

import org.junit.Test;

public class Main1 {

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        in.nextLine();
        String[] nums=new String[n];
        for(int i=0;i<n;i++){
        	nums[i]=in.nextLine();
        }
        System.out.println(getMaxSum(nums));
	}	
	
	
	
	public static long getMaxSum(String[] nums){
		boolean[] flag=new boolean[10];
		HashMap<Character, ArrayList<Integer>> map = new HashMap<Character,ArrayList<Integer>>();
		Arrays.fill(flag, true);
		for(String num:nums){
			flag[num.charAt(0)-'A']=false;
			int len = num.length();
			for(int i=len-1;i>=0;i--){
				char ch = num.charAt(i);
				int value = len-1-i;
				ArrayList<Integer> list=map.get(ch);
				if(list==null){
					list = new ArrayList<Integer>();
				}
				list.add(value);
				map.put(ch, list);
			}
		}
		TreeMap<Long,Character> treeMap=new TreeMap<Long,Character>();
		for(Character ch:map.keySet()){
			treeMap.put(getSum(map.get(ch)), ch);//有问题 值相同时会被覆盖
		}
		return 0;
	}

	private static long getSum(ArrayList<Integer> nums) {
		long sum=0;
		if(nums==null){
			return sum;
		}
		for(int num:nums){
			sum+=(int)Math.pow(10, num);
		}
		return sum;
	}
	
	

	@Test
	public void test(){
		System.out.println(getMaxSum(new String[]{"ABC","BCA"}));
	}
}
