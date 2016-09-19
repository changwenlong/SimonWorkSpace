package edu.zju.chwl.coder.c7;

public class Bipartition {
    public double[] getBipartition(Point[] A, Point[] B) {
        double x1=0.0,y1=0.0,x2=0.0,y2=0.0;
        for(int i=0;i<A.length;i++){
            x1+=A[i].x;
            y1+=A[i].y;
            x2+=B[i].x;
            y2+=B[i].y;
        }
        double[] ret=new double[2];
        if(y1==y2){
            ret[0]=0;
            ret[1]=y1;
        }else{
            ret[0]=(y2-y1)/(x2-x1);
            ret[1]=y1-x1*(y2-y1)/(x2-x1);
        }
        ret[1]/=4;
        return ret;
    }
}

class Point {
    public int x;
    public int y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public Point() {
        this.x = 0;
        this.y = 0;
    }
}
