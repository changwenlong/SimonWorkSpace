package edu.zju.chwl.string;

import java.util.regex.*;

/**
 * 替�?��?作，边匹�?边替�?�
 * Matcher.appendReplacement(StringBuffer sbuf,String replacement)
 * @author a590450
 *
 */
public class TheReplacements {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//用�?��?存替�?��?�的字符串
		StringBuffer sbuf=new StringBuffer();
		Pattern p= Pattern.compile("[aeiou]");
		Matcher m=p.matcher("i wanna be a java ju niu");
		while(m.find()){
			m.appendReplacement(sbuf, m.group().toUpperCase());
		}
		System.out.println(sbuf);

	}

}
