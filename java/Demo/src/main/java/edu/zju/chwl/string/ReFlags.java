package edu.zju.chwl.string;

import java.util.regex.*;
/**
 * Pattern Pattern.compiles(String regex,int flag)
 * flag 用来定义匹配规则
 * Pattern.CASE_INSENSITIVE：大小写敏感
 * Pattern.MULTILINE：不是整体匹配，而是以行为单位一行一行匹配
 * @author a590450
 *
 */
public class ReFlags {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pattern p=Pattern.compile("^java",Pattern.CASE_INSENSITIVE|Pattern.MULTILINE);
		Matcher m=p.matcher(
				"java has regex\nJava has regex\n" +
				"JAVA has pretty good regular expression" +
				"Regular expressions are in Java");
		while(m.find()){
			System.out.format("match %s at pos %d-%d\n", m.group(),m.start(),m.end());
		}
	}

}
