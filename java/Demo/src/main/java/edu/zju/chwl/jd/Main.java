package edu.zju.chwl.jd;

import java.util.*;

public class Main {
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        while(in.hasNextInt())
        {
            int n = in.nextInt();
            int m = in.nextInt();
            ArrayList<Integer> nums =new ArrayList<Integer>();
            for(int i=0;i<n;i++){
            	nums.add(in.nextInt());
            }
            Collections.sort(nums);
            ArrayList<Point> list = new ArrayList<Point>();
            for(int i=0;i<m;i++){
            	list.add(new Point(in.nextInt(),in.nextInt()));
            }
            Collections.sort(list,new Comparator<Point>() {
				@Override
				public int compare(Point o1, Point o2) {
					int val = o2.money-o1.money;
					if(val==0){
						return o1.cnt-o2.cnt;
					}
					return val;
				}
			});
            int ret=0;
            boolean[] flags = new boolean[n];
            for(Point p:list){
            	for(int i=0;i<n;i++){
            		int num=nums.get(i);
            		if(p.cnt<=num&&!flags[i]){
            			ret+=p.money;
            			flags[i]=true;
            			i=n;
            		}
            	}
            }
            System.out.println(ret);
        }
        in.close();
    }
    
    static class Point{
    	public Point(int cnt,int num){
    		this.cnt=cnt;
    		this.money=num;
    	}
    	int cnt;
    	int money;
		@Override
		public String toString() {
			return "Point [cnt=" + cnt + ", money=" + money + "]";
		}
    }
}
/*
3 5
2 4 2
1 3
3 5
3 7
5 9
1 10

3 5
2 4 2
1 3
3 5
3 7
5 9
4 5

3 5
2 4 2
2 2
4 4
2 2
2 2
2 2
*/



