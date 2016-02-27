package edu.zju.chwl.leetcode;


/**
 * https://leetcode.com/problems/container-with-most-water/
 * 
 * @author chwl
 * @Date 2016年2月27日 下午7:19:39
 */
public class ContainerWithMostWater {

	public static void main(String[] args) {
		System.out.println(maxArea(new int[]{3,4,1,5,2}));
		System.out.println(maxArea(new int[]{4,1,5,2}));
	}
	
	public static int maxArea(int[] height) {
        if(height==null||height.length<=1){
        	return 0;
        }
        int max=0;
        int[] indexes = new int[height.length];
        int pos=0;
        indexes[pos++]=0;
        for(int i=1;i<height.length;i++){
        	if(height[i]<=height[indexes[pos-1]]){
        		for(int item:indexes){
        			if(height[item]>=height[i]){
        				int area=(i-item)*height[i];
        				max=max>area?max:area;
        				break;
        			}else{
        				int area=(i-item)*height[item];
        				max=max>area?max:area;
        			}
        		}
        	}else{
        		indexes[pos++]=i;
        	}
        }
    	int right=indexes[pos-1];
    	for(int i=0;i<pos;i++){
			int area=(right-indexes[i])*height[indexes[i]];
			max=max>area?max:area;
		}
        
        return max;
    }

}
