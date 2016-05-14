package edu.zju.chwl.offer.add;

import java.util.*;
import org.junit.*;;

/**
 * 滑动窗口的最大值
 * 
 * 栈+队列
 * @author chwl
 * @Date 2016年4月23日 下午5:19:02
 */
public class MaxInWindows {
	
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
    	ArrayList<Integer> list = new ArrayList<Integer>();
        if(num==null||num.length==0||size<1||size>num.length){
        	return list;
        }
        Deque<Integer> q = new LinkedList<Integer>();
        for(int i=0;i<size;i++){
        	while(!q.isEmpty()){
        		if(num[i]>num[q.getLast()]){//和队尾比
        			q.removeLast();
        		}else{
        			break;
        		}
        	}
        	q.add(i);//插入队尾
        }
        list.add(num[q.getFirst()]);//取队头
        for(int i=size;i<num.length;i++){
        	if(i==(q.getFirst()+size)){//保持窗口大小
        		q.removeFirst();
        	}
        	while(!q.isEmpty()){
        		if(num[i]>num[q.getLast()]){//和队尾比
        			q.removeLast();
        		}else{
        			break;
        		}
        	}
        	q.add(i);//插入队尾
        	list.add(num[q.getFirst()]);
        }
        return list;
    }
    
    @Test
    public void test(){
    	Assert.assertEquals("[4, 4, 6, 6, 6, 5]",maxInWindows(new int[]{2,3,4,2,6,2,5,1},3).toString());
    }
}
