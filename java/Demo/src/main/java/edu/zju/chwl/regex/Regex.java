package edu.zju.chwl.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * http://www.cnblogs.com/ITtangtang/archive/2012/05/01/2477563.html
 * @author chwl
 * @Date 2016年2月28日 下午11:34:17
 */
public class Regex {

	public static void main(String[] args) {
		matches();
		replace();
	}
	
	public static void matches(){
		Pattern pattern = Pattern.compile("\\d{3,5}");
		Matcher matcher = pattern.matcher("123-34345-234-00");
		
		//Matcher.matches 匹配整个字符串
		System.out.println(matcher.matches());
		
		matcher.reset();
		
		//Matcher.find 匹配子字符串 
		while(matcher.find()){
			System.out.println(matcher.group());
			//System.out.println("start:"+matcher.start()+",end:"+matcher.end());
		}
		
		//matcher.lookingAt 匹配第一个子字符串
		if(matcher.lookingAt()){			
			System.out.println(matcher.group());
			System.out.println("start:"+matcher.start()+",end:"+matcher.end());		
		}
	}
	
	public static void replace(){
		Pattern pattern = Pattern.compile("java",Pattern.CASE_INSENSITIVE);
		String s = "java Java jAva ILoveJavA youHateJAVA adsdsfd";
		Matcher matcher = pattern.matcher(s);

		//存放字符串
        StringBuffer  buf = new StringBuffer();
        //计数奇偶数
        int i  = 0;
		while(matcher.find()){
			//System.out.println(s.substring(matcher.regionStart(),matcher.end()));
			i++;
            if(i%2 == 0){
            	matcher.appendReplacement(buf, "java");
            }else{
            	matcher.appendReplacement(buf, "JAVA");
            }
		}
		matcher.appendTail(buf);
		System.out.println(buf);
	}

}
