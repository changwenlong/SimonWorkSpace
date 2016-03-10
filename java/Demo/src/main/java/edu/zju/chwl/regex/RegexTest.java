package edu.zju.chwl.regex;

import static org.junit.Assert.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class RegexTest {

	@Test
	public void test() {
		//贪婪型
		Pattern p1 = Pattern.compile("a*a");
		//勉强型
		Pattern p2 = Pattern.compile("a*?a");
		//占有型 必须全字符串匹配
		Pattern p3 = Pattern.compile("a*+a");
		String s="aaa";
		assertTrue(p1.matcher(s).matches());
		assertTrue(p2.matcher(s).matches());
		assertFalse(p3.matcher(s).matches());
	}
	
	@Test
	public void maxMatch(){
		Pattern p1 = Pattern.compile("<.*>");
		Matcher matcher = p1.matcher("<tr>aaa</tr>");
		while(matcher.find()){
			assertEquals("<tr>aaa</tr>", matcher.group());
		}
	}
	
	@Test
	public void minMatch(){
		Pattern p1 = Pattern.compile("<.*?>");
		Matcher matcher = p1.matcher("<tr>aaa</tr>");
		while(matcher.find()){
			System.out.println(matcher.group());
		}		
	}

}
