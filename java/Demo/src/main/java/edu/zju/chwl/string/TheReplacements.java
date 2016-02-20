package edu.zju.chwl.string;

import java.util.regex.*;

/**
 * æ›¿æ?¢æ“?ä½œï¼Œè¾¹åŒ¹é…?è¾¹æ›¿æ?¢
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
		//ç”¨æ?¥ä¿?å­˜æ›¿æ?¢å?Žçš„å­—ç¬¦ä¸²
		StringBuffer sbuf=new StringBuffer();
		Pattern p= Pattern.compile("[aeiou]");
		Matcher m=p.matcher("i wanna be a java ju niu");
		while(m.find()){
			m.appendReplacement(sbuf, m.group().toUpperCase());
		}
		System.out.println(sbuf);

	}

}
