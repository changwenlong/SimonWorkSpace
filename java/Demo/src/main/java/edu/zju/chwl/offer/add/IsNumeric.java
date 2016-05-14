package edu.zju.chwl.offer.add;

import org.junit.Assert;
import org.junit.Test;

public class IsNumeric {
    public boolean isNumeric(char[] str) {
    	if(str==null||str.length==0){
    		return false;
    	}
    	if(str[0]=='+'||str[0]=='-'){
    		return isNumeric(str,1);
    	}
    	return isNumeric(str,0);
    }

	private boolean isNumeric(char[] str, int pos) {
		int dotPos=-1;
		int ePos=-1;
		for(int i=pos;i<str.length;i++){
			if(!isValid(str[i])){
				return false;
			}
			if(str[i]>='0'&&str[i]<='9'){
				continue;
			}else if(str[i]=='.'){
				if(ePos!=-1||dotPos!=-1){//.出现在e之后,出现重复的.
					return false;
				}
				dotPos=i;
			}else if(str[i]=='e'||str[i]=='E'){
				if(ePos!=-1||i==pos||str[i-1]=='.'||i==str.length-1){//e在最前或最后,出现重复的.
					return false;
				}
				if(str[i+1]=='+'||str[i+1]=='-'){//e后紧跟+ -,且+ - 不能当结尾
					if(i+1==str.length-1){
						return false;
					}else{
						i++;
					}
				}
				ePos=i;
			}
		}
		return true;
	}
	
	private boolean isValid(char ch){
		if((ch>='0'&&ch<=9)||ch=='.'||ch=='e'||ch=='E'){
			return true;
		}
		return false;
	}
	
	@Test
	public void isNumric(){
		Assert.assertTrue(isNumeric(new char[]{'+','1','0','0'}));
		Assert.assertTrue(isNumeric(new char[]{'5','e','2'}));
		Assert.assertTrue(isNumeric(new char[]{'-','1','2','3'}));
		Assert.assertTrue(isNumeric(new char[]{'-','.','1','2','3'}));
		Assert.assertTrue(isNumeric(new char[]{'-','1','E','-','1','6'}));
	}
	
	@Test
	public void notNumric(){
		Assert.assertFalse(isNumeric(new char[]{'1','2','e'}));
		Assert.assertFalse(isNumeric(new char[]{'1','a','3','.','1','4'}));
		Assert.assertFalse(isNumeric(new char[]{'1','.','2','.','3'}));
		Assert.assertFalse(isNumeric(new char[]{'+','-','5'}));
		Assert.assertFalse(isNumeric(new char[]{'1','2','e','+','4','.','1','3'}));
	}
	
}
