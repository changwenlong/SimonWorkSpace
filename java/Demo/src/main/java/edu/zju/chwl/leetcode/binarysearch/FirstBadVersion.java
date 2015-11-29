package edu.zju.chwl.leetcode.binarysearch;

import edu.zju.chwl.util.Tools;

public class FirstBadVersion {

	public static void main(String[] args){
		Tools.print(findFirstBadVersion(5));
	}
	
    public static int findFirstBadVersion(int n) {
        // write your code here
    	if(n<1){
    		return -1;
    	}
    	int start=1,end=n;
    	while(start+1<end){
    		int mid=start+(end-start)/2;
    		boolean midFlag=VersionControl.isBadVersion(mid);
    		if(midFlag){
    			end=mid;
    		}else{
    			start=mid;
    		}
    	}
    	if(VersionControl.isBadVersion(start)){
    		return start;
    	}
    	if(VersionControl.isBadVersion(end)){
    		return end;
    	}
    	return -1;
    }
}

class VersionControl{
	public static boolean isBadVersion(int n){
		if(n<6&&n>0){
			return false;
		}else{
			return true;
		}
	}
	
}
