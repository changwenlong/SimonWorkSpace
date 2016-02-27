package edu.zju.chwl.leetcode;

import java.util.Arrays;

public class ZigZagConversion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(convert("PAYPALISHIRING", 3));
	}
	
    public static String convert(String s, int numRows) {
        if(s==null||s.isEmpty()){
            return "";
        }
        if(numRows==1){
            return s;
        }
        int len=s.length();
        int m = len/(2*(numRows-1))*(numRows-1);
        int mod=len%(2*(numRows-1));
        if(mod<=numRows){
            m+=1;
        }else{
            m=m+1+mod%numRows;
        }
        char[][] result=new char[numRows][m];
        for(int i=0;i<numRows;i++){
        	Arrays.fill(result[i], ' ');
        }
        int[][] directions={{1,0},{-1,1}};
        int dire=0,x=0,y=0;
        for(int i=0;i<len;i++){
            result[x][y]= s.charAt(i);
            if(x==0){
                dire=0;
            }
            if(x==numRows-1){
                dire=1;
            }
            x+=directions[dire][0];
            y+=directions[dire][1];
        }
        String str="";
        for(int i=0;i<numRows;i++){
            for(int j=0;j<m;j++){
            	if(result[i][j]!=' ')
            		str+=result[i][j];
            }
        }
        return str;
    }

}
