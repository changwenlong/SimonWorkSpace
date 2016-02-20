package edu.zju.chwl.lintcode;

public class TrailingZeros {

    public long trailingZeros(long n) {
        long count=0;
        while(n!=0){
            count+=n/5;
            n/=5;
        }
        return count;
    }
}
