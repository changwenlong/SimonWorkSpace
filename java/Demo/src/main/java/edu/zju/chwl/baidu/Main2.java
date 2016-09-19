package edu.zju.chwl.baidu;

import java.util.*;

public class Main2 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int n = in.nextInt();
			int m=in.nextInt();
			LinkedList<Integer> q = new LinkedList<Integer>();
			int count=0;
			for(int i=0;i<m;i++){
				Integer num = in.nextInt();
				if(q.isEmpty()){
					q.offer(num);
					count++;
				}else if(!q.contains(num)){
					count++;
					if(q.size()>=n){
						q.poll();
					}
					q.offer(num);
				}
			}
			System.out.println(count);
		}
			
	}

}
