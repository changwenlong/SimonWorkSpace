package edu.zju.chwl.yizhantong;

import java.util.*;

import org.junit.Test;

public class Transform {
	
    StringBuilder sb = new StringBuilder();
    
    public String trans(String s, int n) {
        if(s==null||s.length()==0){
        	return s;
        }
        int end = -1;
        int start = -1;
        for(int i=n-1;i>=0;i--){
        	if(s.charAt(i)==' '){
        		if(end!=-1){
        			start=i+1;
        			appendAndTrans(s,start,end);
        		}
        		sb.append(" ");
        		end =-1;
        	}else{
        		if(end!=-1){
        			continue;
        		}else{
        			end=i;
        		}
        	}
        }
        if(s.charAt(0)!=' '){
        	appendAndTrans(s,0,end);
        }
        return sb.toString();
    }

	private void appendAndTrans(String s, int start, int end) {
		int num='a'-'A';
		for(int i=start;i<=end;i++){
			char ch = s.charAt(i);
			if(ch>='a'){
				sb.append((char)(ch-num));
			}else{
				sb.append((char)(ch+num));
			}
		}
	}
	
	@Test
	public void test(){
		System.out.println(trans("This is a sample ",17));
	}

}
