package edu.zju.chwl.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;

import edu.zju.chwl.util.Tools;

public class MaxPointsOnALine {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaxPointsOnALine m=new MaxPointsOnALine();
		Point[] points=new Point[4];
		//points[0]=new Point(0,0);
		points[2]=new Point(0,0);
		points[0]=new Point(1,2);
		points[1]=new Point(3,6);
		points[3]=new Point(1,3);
		Tools.print(m.maxPoints(points));
		

	}
	
	/**
	 * key point: suppose the line contains this point.
	 * @param points
	 * @return
	 */
    public int maxPoints(Point[] points) {
        // Write your code here
        if(points==null|| points.length == 0){
            return 0;
        }
        if(points.length==1){
            return 1;
        }
        HashMap<Double,Integer> map=new HashMap<Double,Integer>();
        int max=1;
        for(int i=0;i<points.length-1;i++){
        	map.clear();
        	map.put((double)Integer.MIN_VALUE, 1);
            Point start=points[i];
            int dup=0;
            for(int j=i+1;j<points.length;j++){
                Point end=points[j];
            	if(start.x==end.x&&start.y==end.y){
            		dup++;
            		continue;
            	}
                double key=end.x==start.x?Integer.MAX_VALUE:(double)(end.y-start.y)/(end.x-start.x);
                if(map.get(key)==null){
                    map.put(key,2);
				} else {
					map.put(key, map.get(key) + 1);
				}
            }
            for(int item:map.values()){
            	if(item+dup>max){
            		max=item+dup;
            	}
            }
        }
        return max;
    }    
    
    
    public static int maxGys(int a,int b){
    	if(a%b==0){
    		return b;
    	}else{
    		return maxGys(b,a%b);
    	}
    }
    
    public static int minGbs(int a,int b){
    	return a*b/maxGys(a,b);
    }

}


 class Point {
    int x;
    int y;
    Point() { x = 0; y = 0; }
     Point(int a, int b) { x = a; y = b; }
 }
