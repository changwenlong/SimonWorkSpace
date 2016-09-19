package edu.zju.chwl.coder.c5;

public class Transform {
    public int calcCost(int A, int B) {
        return Integer.bitCount(A^B);
    }
}
