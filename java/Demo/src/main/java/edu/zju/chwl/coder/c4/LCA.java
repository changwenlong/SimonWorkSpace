package edu.zju.chwl.coder.c4;

public class LCA {
    public int getLCA(int a, int b) {
        return getLCA(1,a,b);
    }

	private int getLCA(int i, int a, int b) {
		if(i>a&&i>b){
			return -1;
		}
		if(i==a||i==b){
			return i;
		}
		int left=getLCA(2*i,a,b);
		int right=getLCA(2*i+1,a,b);
		if(left!=-1&&right!=-1){
			return i;
		}
		if(left!=-1){
			return left;
		}
		if(right!=-1){
			return right;
		}
		return -1;
	}
    
    
}
