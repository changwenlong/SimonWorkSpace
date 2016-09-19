package edu.zju.chwl.jd;

import java.util.*;

public class Main1
{
    public static void main(String args[])
    {
        Scanner cin = new Scanner(System.in);
        while(cin.hasNextInt())
        {
        	 int n = cin.nextInt();
             int m = cin.nextInt();
             TreeMap<Integer, Integer> map = new TreeMap<Integer,Integer>();
             for(int i=0;i<m;i++){
            	 map.put(cin.nextInt(), cin.nextInt());
             }
             Iterator<Integer> ite = map.keySet().iterator();
             int d = ite.next();
             int num = map.get(d);
             boolean flag = false;
             int max =d-1+num;
             while(ite.hasNext()){
             	int d1=ite.next();
             	int num1=map.get(d1);
             	if((num1-num)>(d1-d)){
             		flag=true;
             		System.out.println("IMPOSSIBLE");
             	}else{
             		if(num<num1){
             			max =Math.max((d1-(d+num1))/2+num1, max);
             		}else if(num==num1){
             			max=Math.max((d1-d)/2+num, max);
             		}else{
             			max =Math.max((d1-num-d)/2+num, max);
             		}
             	}
             	d=d1;
             	num=num1;
             }
             max=Math.max(n-d+num, max);
             if(!flag){
                 System.out.println(max);
             }
        }
        cin.close();
    }
}