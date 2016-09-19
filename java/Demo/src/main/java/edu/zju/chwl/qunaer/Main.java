package edu.zju.chwl.qunaer;

import java.util.*;

import org.junit.Test;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public String formatString(String A, int n, char[] arg, int m) {
    	int cnt=0;
        while(A.indexOf("%s")!=-1){
        	A=A.replaceFirst("%s", arg[cnt++]+"");
        }
        for(int i=cnt;i<m;i++){
        	A+=arg[i];
        }
        return A;
    }
    
    @Test
    public void testFormatString(){
    	System.out.println(formatString("A%sC%sE", 7, new char[]{'B','D','F'}, 3));
    }
    
    @Test
    public void testChkBlood(){
    	System.out.println(chkBlood("A","B"));
    }
    
    public String[] chkBlood(String father, String mother) {
        return getChildBlood(transBlood(father),transBlood(mother));
    }
    
    private String[] getChildBlood(String[] father, String[] mother) {
    	TreeSet<String> set = new TreeSet<String>();
		for(int i=0;i<2;i++){
			for(int j=0;j<2;j++){
				set.add(plusBlood(father[i],mother[j]));
			}
		}
		
		return set.toArray(new String[0]);
	}

	private String[] transBlood(String blood) {
		if(blood.length()==1){
			return new String[]{blood,"O"};
		}
		return new String[]{blood.charAt(0)+"",blood.charAt(1)+""};
	}

	public String plusBlood(String a,String b){
    	if("O".equals(a)){
    		return b;
    	}else if("O".equals(b)){
    		return a;
    	}else if(a.equals(b)){
    		return a;
    	}else{
    		return "AB";
    	}
    }
	
    public boolean chkLegal1(String A) {
    	Stack<Character> stack = new Stack<Character>();
        for(int i=0;i<A.length();i++){
        	char ch = A.charAt(i);
        	if(ch=='{'||ch=='['||ch=='('){
        		stack.push(ch);
        	}else if(ch=='}'||ch==']'||ch==')'){
        		if(stack.isEmpty())
        			return false;
        		Character popCh = stack.pop();
        		if((ch=='}'&&popCh!='{')||(ch==']'&&popCh!='[')||(ch==')'&&popCh!='(')){
        			return false;
        		}
        	}
        }
        if(stack.isEmpty())
        	return false;
        return true;
    }
    
    public boolean chkLegal(String A) {
    	HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        for(int i=0;i<A.length();i++){
        	char ch = A.charAt(i);
        	if(ch=='{'||ch=='['||ch=='('){
        		Integer cnt = map.get(ch);
        		cnt = cnt==null?1:cnt+1;
        		map.put(ch,cnt);
        		
        	}else if(ch=='}'||ch==']'||ch==')'){
        		ch = ch=='}'?'{':ch;
        		ch = ch==']'?'[':ch;
        		ch = ch==')'?'(':ch;
        		Integer cnt = map.get(ch);
        		cnt = cnt==null?-1:cnt-1;
        		map.put(ch,cnt);
        	}
        }
        for(int item:map.values()){
        	if(item!=0)
        		return false;
        }
        return true;
    }
    
    @Test
    public void testChkLegal() {
    	System.out.println(chkLegal("[a+b*(5-4)]*{x+b+b*({1+2)}}"));
    	System.out.println(chkLegal("[a+b*(5-4)]*{x+b+b*(({1+2)}}"));
    }
    
    public int[] containKeyword(String[] A, int n, String[] keys, int m) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i=0;i<n;i++){
        	for(int j=0;j<m;j++){
        		if(A[i].contains(keys[j])){
        			list.add(i);
        			break;
        		}
        	}
        }
        if(list.isEmpty())
        	return new int[]{-1};
        int[] ret = new int[list.size()];
        for(int i=0;i<list.size();i++){
        	ret[i]=list.get(i);
        }
        return ret;
    }
    
    @Test
    public void testContainKeyword(){
    	containKeyword(new String[]{"nowcoder","hello","now"},3,new String[]{"coder","now"},2);
    }
    
    public int chooseLine(int[] stops, int[] period, int[] interval, int n, int s) {
        int min = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
        	int num = (5+period[i])*stops[i]+5+(int)Math.ceil(((double)s)/interval[i])*interval[i];
        	min = Math.min(min, num);
        }
        return min;
    }
    
    @Test
    public void testChooseLine(){
    	int num = chooseLine(new int[]{13,15,26,7,27,3,30},new int[]{1,2,1,2,2,2,1},new int[]{5,1,4,3,2,1,4},7,10);
    	System.out.println(num);
    }

}
