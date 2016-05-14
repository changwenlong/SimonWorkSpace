package edu.zju.chwl.offer.timeandspace;

import org.junit.*;

/**
 * 丑数
 * @author a590450
 * @date 31 Mar 2016 15:02:08
 */
public class UglyNumber {
    public int uglyNumber(int index) {
        if(index<1){
        	return 0;
        }
        int[] f=new int[index];
        f[0]=1;
        int two=0,three=0,five=0;
        for(int i=1;i<index;i++){
        	f[i]=getMin(2*f[two],3*f[three],5*f[five]);
        	if(2*f[two]==f[i]){
        		two++;
        	}
        	if(3*f[three]==f[i]){
        		three++;
        	}
        	if(5*f[five]==f[i]){
        		five++;
        	}
        }
        return f[index-1];
    }

	private int getMin(int i, int j, int k) {
		return Math.min(i, Math.min(j,k));
	}
	
	@Test
	public void test(){
		Assert.assertEquals(8, uglyNumber(7));
	}
}
