package edu.zju.chwl.coder.c7;

/**
 * 对二进制表示取反加一实现取相反数
 * 除法即减法
 * 乘法即加法
 * @author chwl
 * @Date 2016年5月17日 下午10:01:57
 */
public class AddSubstitution {
	public int calc(int a, int b, int type) {
	    int res = 0;
	    if(type == 1){
	        int tmp = b;
	    	if(b<0) tmp=(~b)+1;
	        for(int i = 0; i < tmp; i++){
	            res += a;
	        }
	        if(b<0) res=(~res)+1;
	    }else if(type == 0 ){
	    	int tmp=b;
	    	if(b<0) tmp=(~b)+1;
	        int count = 0;
	        while(a > 0&& a >= tmp){
	            a = a + (~tmp) + 1;
	            count++;
	        }
	        res = count;
	        if(b<0) res=(~res)+1;
	    }else{
	        res = a + (~b) + 1;
	    }
	    return res;
	}
}
