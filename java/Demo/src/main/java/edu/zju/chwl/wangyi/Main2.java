package edu.zju.chwl.wangyi;

import java.util.Scanner;

public class Main2 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int r = in.nextInt();
			int count=0;
			Point[] ps= new Point[4];
			for(int i=0;i<4;i++){
				ps[i]=new Point(in.nextInt(),in.nextInt());
			}
			for(int i=0;i<3;i++){
				if(r*r>=ps[i].dis(ps[3])){
					count++;
				}
			}
			System.out.println(count+"x");
		}

	}
	
	static class Point{
		int x,y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
		public int dis(Point p){
			return (p.x-this.x)*(p.x-this.x)+(p.y-this.y)*(p.y-this.y);
		}
	}

}
