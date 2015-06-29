package edu.zju.chwl.string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * 正则表达式
 * Pattern&Matcher的用法
 * @author chwl
 * @Date 2015年5月30日 下午10:37:08
 */
public class TestRegularExpression {

	public static void main(String[] args) {
		String[] strs={"abcabccabcccdefabc","abc"};
		//编译正则表达式，生成Pattern对象
		Pattern p=Pattern.compile(strs[1]);
		//匹配字符串，得到Matcher对象
		Matcher m=p.matcher(strs[0]);
		while(m.find()){
			System.out.format("Match \" %s \" at pos %d-%d\n",m.group(),m.start(),m.end()-1);
		}
		//判断是否是完全匹配
		System.out.format("matches method:%s\n",m.matches());
		//判断是否匹配开头
		System.out.format("lookingAt method:%s\n",m.lookingAt());
		//从给定角标开始找 看能否找到
		System.out.format("find method:%s\n",m.find(15));
	}

}
