package edu.zju.chwl.lintcode.dp;

import java.util.HashSet;
import java.util.Set;

import edu.zju.chwl.util.Tools;

public class WordBreak {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> dict=new HashSet<String>();
		dict.add("lint");
		dict.add("code");
		Tools.print(new WordBreak().wordBreak("lintcode",dict));
	}
	
    public boolean wordBreak(String s, Set<String> dict) {
        // write your code here 
    	if(s==null||s.length()==0){
    		return true;
    	}
    	int maxLength = getMaxLength(dict);
    	int len=s.length();
    	boolean[] results=new boolean[len+1];
    	results[0]=true;
    	for(int i=1;i<=len;i++){
    		for(int j=i-1;j>=0&&(i-j<= maxLength);j--){
    			if(results[j]&&dict.contains(s.substring(j,i))){
        			results[i]=true;
        			break;
    			}
    		}
    	}
    	return results[len];
    }
    
    private int getMaxLength(Set<String> dict) {
        int maxLength = 0;
        for (String word : dict) {
            maxLength = Math.max(maxLength, word.length());
        }
        return maxLength;
    }

}
