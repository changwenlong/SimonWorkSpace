package edu.zju.chwl.leetcode;

/**
 * https://leetcode.com/problems/string-to-integer-atoi/
 * @author a590450
 * @date 24 Feb 2016 17:28:29
 */
public class StringToInteger {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(myAtoi("   +0 123"));
		System.out.println(myAtoi("-123"));
		System.out.println(myAtoi("+123"));
		System.out.println(myAtoi("+"));
		System.out.println(myAtoi("+-2"));
		System.out.println(myAtoi("  -0012a42"));
		System.out.println(myAtoi("     +004500"));
		System.out.println("9223372036854775809");
		//"9223372036854775809"
		System.out.println(Long.MAX_VALUE);
	}
	
	public static int myAtoi(String str) {
        if(str==null||str.isEmpty()){
            return 0;
        }
        long res = 0L;
        int signal=1;
        char[] arr = str.toCharArray();
        int i=0;
        while(arr[i]==' '){
        	i++;
        }
        if(arr[i]=='-'){
        	signal=-1;
        	i++;
        }else if(arr[i]=='+'){
        	i++;
        }
        
        for(;i<arr.length;i++){
        	if(arr[i]>'9'||arr[i]<'0'){
        		break;
        	}
        	res=res*10+signal*(arr[i]-'0');
        	if(res>Integer.MAX_VALUE){
            	return Integer.MAX_VALUE;
            }else if(res<Integer.MIN_VALUE){
            	return Integer.MIN_VALUE;
            }
        }
        return (int)res;
        
        
    }
}
