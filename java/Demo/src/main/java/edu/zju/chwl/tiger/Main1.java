package edu.zju.chwl.tiger;

import java.util.*;

public class Main1 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		TreeMap<Task, Integer> taskMap = new TreeMap<Task,Integer>(new Comparator<Task>(){
			@Override
			public int compare(Task o1, Task o2) {
				return (o1.start-o2.start)!=0?(o1.start-o2.start):(o1.end-o2.end);
			}
			
		});
		TreeMap<Task, Integer> finishedTaskMap = new TreeMap<Task,Integer>(new Comparator<Task>(){
			@Override
			public int compare(Task o1, Task o2) {
				return o1.end-o2.end;
			}
			
		});
		while(in.hasNext()){
			taskMap.clear();
			finishedTaskMap.clear();
			int n = in.nextInt();
			for(int i=0;i<n;i++){
				Task task = new Task(in.nextInt(),in.nextInt());
				Integer num = taskMap.get(task);
				if(num==null){
					taskMap.put(task, 1);
				}else{
					taskMap.put(task, num+1);
				}
			}
			int sum=0;
			for(Task task:taskMap.keySet()){
				for(int i=0;i<taskMap.get(task);i++){
					if(finishedTaskMap.isEmpty()){
						finishedTaskMap.put(task, 1);
						sum++;
					}else{
						Task key = finishedTaskMap.firstKey();
						if(key.end<=task.start){
							if(finishedTaskMap.get(key)==1){
								finishedTaskMap.remove(key);
							}else{
								finishedTaskMap.put(key, finishedTaskMap.get(key)-1);	
							}						
						}else{
							sum++;
						}
						Integer num = finishedTaskMap.get(task);
						if(num==null){
							finishedTaskMap.put(task, 1);
						}else{
							finishedTaskMap.put(task, num+1);
						}
					}
				}
			}
			System.out.println(sum);
		}
	}
	
	static class Task{
		int start,end;

		public Task(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}

		@Override
		public String toString() {
			return "[" + start + ", " + end + "]";
		}		
	}

}
