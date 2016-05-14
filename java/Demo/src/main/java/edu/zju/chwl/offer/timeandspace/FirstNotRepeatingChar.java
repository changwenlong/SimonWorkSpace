package edu.zju.chwl.offer.timeandspace;

import java.util.Arrays;

public class FirstNotRepeatingChar {
    public int firstNotRepeatingChar(String str) {
        if(str==null||str.length()==0){
        	return -1;
        }
        int[] counts = new int[256];
        Arrays.fill(counts, 0);
        int len = str.length();
        int result = -1;
        for(int i=0;i<len;i++){
        	counts[str.charAt(i)]++;
        }
        for(int i=0;i<len;i++){
        	if(counts[str.charAt(i)]==1){
        		result=i;
        		break;
        	}
        }
        return result;
    }
}
