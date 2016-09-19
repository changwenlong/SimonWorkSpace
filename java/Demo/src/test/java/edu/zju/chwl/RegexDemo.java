package edu.zju.chwl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class RegexDemo {

	@Test
	public void test() {
		String a="/*123\n */111";
		System.out.println(a.startsWith("/*"));
		String b = "//123";
		System.out.println(b.startsWith("//"));
	}
	
	@Test
	public void testRegex() {
		String regex="[\\d]+";
		Pattern pattern = Pattern.compile(regex);
		String str = "我30你40他50";
		Matcher matcher = pattern.matcher(str);
		int ret = 0;
		while(matcher.find()){
			int num = Integer.parseInt(str.substring(matcher.start(),matcher.end()));
			ret+=num;
		}
		System.out.println(ret);
	}

}
