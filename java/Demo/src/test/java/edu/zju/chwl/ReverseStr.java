package edu.zju.chwl;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class ReverseStr {
	@Test
	public void testGetReverse(){
		System.out.println(getReverse(123456));
	}
	//逆序打印整数（递归）
	public String getReverse(int num){
		String str=num%10+"";
		if(num>=10){
			str+=getReverse(num/10);
		}
		return str;
	}
	
	@Test
	public void testGetReverseStr(){
		System.out.println(getReverseStr("123456"));
	}
	//逆序打印字符串(递归)
	public String getReverseStr(String instr){
		int len=instr.length();
		String str=instr.substring(len-1,len);
		if(len>1){
			str+=getReverseStr(instr.substring(0,len-1));
		}
		return str;
	}
	
	@Test
	public void testRemoveOverlap(){
		int[] intArr=new int[]{5,4,6,1,2,5,3};
		int len=intArr.length-1;
		for(int i=0;i<intArr.length;i++){
			int value=(intArr[i]-1)%len;
			if(intArr[value]>len){
				System.out.println(value+1);
				break;
			}
			intArr[value]+=len;
		}
	}
	
	@Test
	public void testRemoveOverlap1(){
		int[] intArr=new int[]{5,4,6,1,2,5,3};
		for(int i=0;i<intArr.length;i++){
			int value=intArr[i];
			int temp=intArr[value-1];
			if(value!=temp||(value-1)==i){
				intArr[value-1]=intArr[i];
				intArr[i]=temp;
			}else{
				System.out.println(value);
			}
		}
	}
	
	@Test
	public void testRemoveOverlap2(){
		int[] intArr=new int[]{5,4,6,1,2,5,3};
		int temp,k=0;
		for(int i:intArr){
			temp=intArr[i-1];
			intArr[i-1]=i;
			intArr[k++]=temp;
		}
		for(int i=0;i<intArr.length;i++){
			System.out.println(intArr[i]);
		}
	}
	
	//判断相同字符串
	@Test
	public void testSameString(){
		String s1="12ww我是2";
		String s2="12我是ww1";
		Map<Character,Integer> hashMap=new HashMap<Character,Integer>();
		for(int i=0;i<s1.length();i++){
			Character ch=s1.charAt(i);
			Integer value=hashMap.get(ch);
			if(value==null){
				hashMap.put(ch, 1);
			}
			else{
				hashMap.put(ch, value+1);
			}
		}
		for(int i=0;i<s2.length();i++){
			Character ch=s2.charAt(i);
			Integer value=hashMap.get(ch);
			if(value==null){
				System.out.println("not same!");
				return;
			}
			else{
				hashMap.put(ch, value-1);
			}
		}
		
		for(Character ch1:hashMap.keySet()){
			if(hashMap.get(ch1)!=0){
				System.out.println("not same!");
				return;
			}
		}
		System.out.println("same");
	}

}
