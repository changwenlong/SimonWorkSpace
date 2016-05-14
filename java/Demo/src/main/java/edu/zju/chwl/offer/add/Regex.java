package edu.zju.chwl.offer.add;

import org.junit.*;

/**
 * 正则表达式
 * @author chwl
 * @Date 2016年4月16日 下午10:46:40
 */
public class Regex {
    public boolean match(char[] str, char[] pattern)
    {
        if(str==null||pattern==null){
        	return false;
        }
        return isMatch(str,pattern,0,0);
    }

	private boolean isMatch(char[] str, char[] pattern, int i, int j) {
		int sLen=str.length;
		int pLen=pattern.length;
		if(i==sLen||j==pLen){
			if(i==sLen&&j==pLen){
				return true;
			}else if(j==pLen){
				return false;
			}else{
				if(j+2<=pLen&&pattern[j+1]=='*'){
					return isMatch(str, pattern, i, j+2);
				}else{
					return false;
				}
			}
		}
		if(j+2<=pLen&&pattern[j+1]=='*'){
			if(str[i]==pattern[j]||pattern[j]=='.'){
				return isMatch(str, pattern, i, j+2)||isMatch(str, pattern, i+1, j);
			}else{
				return isMatch(str, pattern, i, j+2);
			}
		}else{
			if(str[i]==pattern[j]||pattern[j]=='.'){
				return isMatch(str, pattern, i+1, j+1);
			}else{
				return false;
			}
		}
	}
	
	@Test
	public void isMatch(){
		char[] str = new char[]{'a','a','a'};
		Assert.assertTrue(match(str, new char[]{'a','b','*','a','c','*','a'}));
		Assert.assertTrue(match(str, new char[]{'a','.','a'}));
		Assert.assertTrue(match(new char[]{'a'}, new char[]{'.','*'}));
	}
	
	@Test
	public void notMatch(){
		char[] str = new char[]{'a','a','a'};
		Assert.assertFalse(match(str, new char[]{'a','b','*','a'}));
		Assert.assertFalse(match(str, new char[]{'a','a','.','a'}));
	}
	
	@Test
	public void test(){
		Integer a=1;
		Integer b=2;
		Integer c=3;
		Integer d=3;
		Integer e=321;
		Integer f=321;
		Long g=3L;
		System.out.println(c==d);
		System.out.println(e==f);
		System.out.println(c==(a+b));
		System.out.println(c.equals(a+b));
		System.out.println(g==(a+b));
		System.out.println(g.equals(a+b));
	}
}
