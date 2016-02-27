package edu.zju.chwl.leetcode;

/**
 * https://leetcode.com/problems/integer-to-roman/
 * https://leetcode.com/problems/roman-to-integer/
 * 
 * @author chwl
 * @Date 2016年2月27日 下午7:56:23
 */
public class IntegerToRoman {

	public static void main(String[] args) {
		System.out.println(intToRoman(1996));
		System.out.println(romanToInt("MCMXCVI"));

	}

	/*
	 * 1~9: {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
	 * 10~90: {"X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
	 * 100~900: {"C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
	 * 1000~3000: {"M", "MM", "MMM"}.
	 */
	public static String intToRoman(int num) {
		String[] roman = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
		int[] number={1000,900,500,400,100,90,50,40,10,9,5,4,1};
		String result="";
		for(int i=0;i<roman.length;i++){
			while(num>=number[i]){
				num-=number[i];
				result+=roman[i];
			}
		}
		return result;
	}
	
	public static int romanToInt(String s) {
		if(s==null||s.isEmpty()){
			return 0;
		}
		int[] hash=new int[256];
		hash['I']=1;
		hash['V']=5;
		hash['X']=10;
		hash['L']=50;
		hash['C']=100;
		hash['D']=500;
		hash['M']=1000;
		
		char[] charArr=s.toCharArray();
		int result=0;
		int front=hash[charArr[0]];
		
		for(char ch:charArr){
			result+=hash[ch];
			if(hash[ch]>front){
				result=result-2*front;
			}
			front=hash[ch];
		}
		
		return result;
	}

}
