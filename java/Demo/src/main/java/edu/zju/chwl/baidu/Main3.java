package edu.zju.chwl.baidu;

import java.util.*;

public class Main3 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int n = in.nextInt();
			ArrayList<Process> list = new ArrayList<Process>();
			int count=0;
			for(int i=0;i<n;i++){
				Integer start = in.nextInt();
				Integer time = in.nextInt();
				list.add(new Process(start,time));
			}
			Collections.sort(list);
			int time=list.get(0).time;
			int start=list.get(0).start;
			int sum=0;
			for(int i=1;i<list.size();i++){
				Process p = list.get(i);
				sum=sum+time+start-p.start;
				time+=p.time;
			}
			System.out.println(String.format("%.4f", (double)sum/list.size()));
		}
			
	}
	
	static class Process implements Comparable<Process>{
		Integer start;
		Integer time;
		public Process(Integer start, Integer time) {
			super();
			this.start = start;
			this.time = time;
		}
		@Override
		public int compareTo(Process o) {
			int cmp = this.start.compareTo(o.start);
			return cmp==0?this.time.compareTo(o.time):cmp;
		}
		@Override
		public String toString() {
			return "Process [start=" + start + ", time=" + time + "]";
		}
		
	}

}
