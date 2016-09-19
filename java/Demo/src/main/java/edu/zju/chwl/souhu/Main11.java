package edu.zju.chwl.souhu;

import java.util.*;

public class Main11{
    public static void main(String[] args){
        int n;
        Scanner scan=new Scanner(System.in);
        while(scan.hasNextInt()){
            n=scan.nextInt();
            mycla cla[]=new mycla[n];
            int k ;
            int a ,b;
            int i ;
            for(i=0;i<n;i++){
                k=scan.nextInt();
                a=scan.nextInt();
                b=scan.nextInt();
                cla[k-1]=new mycla(a, b);
                 
            }
            Arrays.sort(cla,new Comparator<mycla>() {
 
                @Override
                public int compare(mycla o1, mycla o2) {
                    // TODO Auto-generated method stub
                    if(o1.a!=o2.a)
                        return o1.a-o2.a;
                    return o2.b-o1.b;
                }
            });
            int c[]=new int [n];
         
            int dp[]=new int[n];
            for(i=0;i<n;i++){
                c[i]=cla[i].b;
                dp[i]=1;
            }
            int j;
            int max=Integer.MIN_VALUE;
            for(i=1;i<n;i++){
                for(j=0;j<i;j++){
                     
                    if(c[i]>=c[j])
                        dp[i]=dp[j]+1>dp[i]?dp[j]+1:dp[i];
                }
                 
                if(dp[i]>max){
                    max=dp[i];
                     
                     
                }
            }
            System.out.println(max);
        }
    }
}
class mycla{
    int a;
    int b ;
    public mycla(int a,int b) {
        // TODO Auto-generated constructor stub
        this.a=a;
        this.b=b;
    }
}
