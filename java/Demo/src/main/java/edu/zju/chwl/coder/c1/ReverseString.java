package edu.zju.chwl.coder.c1;

public class ReverseString {
    public String reverseString(String str) {
        if(str==null||str.isEmpty()){
            return str;
        }
        int len=str.length();
        char[] arr=str.toCharArray();
        for(int i=0;i<len/2;i++){
            swap(arr,i,len-1-i);
        }
        return new String(arr);
    }
    
    public void swap(char[] arr,int i,int j){
        char temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
