package edu.zju.chwl.coder.c18;

import java.util.*;

public class Substr {
    public boolean[] chkSubStr(String[] p, int n, String s) {
        HashMap<Character,ArrayList<Integer>> map = new HashMap<Character,ArrayList<Integer>>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            ArrayList<Integer> list = map.get(ch);
            if(list == null){
                list = new ArrayList<Integer>();
                map.put(ch,list);
            }               
            list.add(i);
        }
        
        boolean[] ret = new boolean[n];
        for(int i=0;i<n;i++){
            ret[i] = isSubStr(map,s,p[i]);
        }
        return ret;
    }
    
    private boolean isSubStr(HashMap<Character,ArrayList<Integer>> map,String s, String str){
        if(str==null||str.isEmpty())
            return false;
        ArrayList<Integer> list = map.get(str.charAt(0));
        if(list==null||list.isEmpty())
            return false;
        for(int index:list){
            if(s.substring(index,Math.min(index+str.length(),s.length())).equals(str))
                return true;
        }
        return false;
    }
}