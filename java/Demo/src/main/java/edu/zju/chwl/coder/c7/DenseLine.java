package edu.zju.chwl.coder.c7;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class DenseLine {
    public double[] getLine(Point[] p, int n) {
    	if(n<2){
    		return null;
    	}
        int res=0;
        Slope slope=null;
        Point point=null;
        HashMap<Slope, Integer> map = null;
        for(int i=1;i<n;i++){
        	map=new HashMap<Slope,Integer>();
        	int dup=0;
        	for(int j=0;j<i;j++){
        		if(p[i].x==p[j].x&&p[i].y==p[j].y){
        			dup++;
        			continue;
        		}
        		Slope key = new Slope(p[i],p[j]);
				Integer value=map.get(key);
        		if(value==null){
        			map.put(key, 1);
        		}else{
        			map.put(key, value+1);
        		}
        	}
        	int max=0;
        	Slope s=null;
            Point pp=null;
        	for(Map.Entry<Slope, Integer> entry:map.entrySet()){
        		if(entry.getValue()>max){
        			s=entry.getKey();
        			pp=p[i];
        			max=entry.getValue();
        		}
        	}
        	if((max+dup+1)>res){
        		slope=s;
        		point=pp;
        		res=max+dup+1;
        	}
        }
        if(slope==null){
        	return null;
        }else{
        	double b = (double)slope.y/slope.x;
			double d = point.y-b*point.x;
			return new double[]{b,d};
        }
    }
    
    //穿过最多点的直线穿过的点数
    public int getCount(Point[] p, int n){
    	if(n<3){
    		return n;
    	}
        int res=0;
        HashMap<Slope, Integer> map = null;
        for(int i=1;i<n;i++){
        	map=new HashMap<Slope,Integer>();
        	int dup=0;
        	for(int j=0;j<i;j++){
        		if(p[i].x==p[j].x&&p[i].y==p[j].y){
        			dup++;
        			continue;
        		}
        		Slope slope = new Slope(p[i],p[j]);
				Integer value=map.get(slope);
        		if(value==null){
        			map.put(slope, 1);
        		}else{
        			map.put(slope, value+1);
        		}
        	}
        	int max=0;
        	for(Integer item:map.values()){
        		max=Math.max(max, item);
        	}
        	res=Math.max(max+dup+1, res);
        }
        return res;
    }
    
    @Test
    public void test(){
    	System.out.println(2%0);
    }
}

//斜率
class Slope{
	int x;
	int y;
	Slope(Point p1,Point p2){
		int a=p2.x-p1.x;
		int b=p2.y-p1.y;
		if(a==0){
			x=0; y=1;
		}else if(b==0){
			x=1; y=0;
		}else{
			int c=gcd(a,b);
			this.x=a/c;
			this.y=b/c;
		}
	}
	
	@Override
	public int hashCode(){
		return x*31+y;
	}
	
	@Override
	public boolean equals(Object obj){
		if(obj==this) return true;
		if(obj instanceof Slope){
			Slope line=(Slope)obj;
			if(x==line.x&&y==line.y){
				return true;
			}
		}
		return false;
	}
	
	int gcd(int a,int b){
		return b==0?a:gcd(b,a%b);
	}
}

