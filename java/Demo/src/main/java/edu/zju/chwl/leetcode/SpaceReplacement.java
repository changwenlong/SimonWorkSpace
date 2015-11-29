package edu.zju.chwl.leetcode;

import edu.zju.chwl.util.Tools;

public class SpaceReplacement {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		char[] string="hello world    ".toCharArray();
		replaceBlank(string,11);
		Tools.print(new String(string));
	}

    public static int replaceBlank(char[] string, int length) {
        // Write your code here
    	int len=length;
    	for(int i=0;i<length;i++){
    		if(string[i]==' '){
    			len+=2;
    		}
    	}
    	System.out.println(len);
        int gap=len-length;
        int count=0;
        for(int i=length-1;i>=0;i--){
            if(string[i]==' '){
                string[i+gap-count*2]='0';
                string[i+gap-count*2-1]='2';
                string[i+gap-count*2-2]='%';
                count++;
            }else{
                string[i+gap-count*2]=string[i];
            }
        }
        return len;
    }

}
