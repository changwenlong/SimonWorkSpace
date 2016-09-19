package edu.zju.chwl.coder.c9;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.Test;

public class Permutation {
	//字符串长度小于11 可以用位图表示
    public ArrayList<String> getPermutation(String A) {
        ArrayList<String> list = new ArrayList<String>();
        int len=A.length();
        int bit=(1<<len)-1;
        permutation(list,new StringBuilder(),A,bit);
        Collections.sort(list, Collections.reverseOrder());
        return list;
    }

	private void permutation(ArrayList<String> list,
			StringBuilder sb, String str, int bit) {
		if(sb.length()==str.length()){
			list.add(sb.toString());
		}
		for(int i=0;i<str.length();i++){
			if(((1<<i)&bit)==0) continue;
			sb.append(str.charAt(i));
			permutation(list, sb, str, bit&(~(1<<i)));
			sb.setLength(sb.length()-1);
		}
		
	}
	
	@Test
	public void test(){
		System.out.println(getPermutation("ABC"));
	}
}
