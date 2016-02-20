package edu.zju.chwl.string;

import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * 演示 split（）
 * String[] split(String input)
 * String[] split(String input,int limit)
 * @author a590450
 *
 */
public class SplitDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String input="i!!try!!to!!be!!a!!java!!ju!!niu";
		Pattern p=Pattern.compile("!!");
		String[] splitArr=p.split(input);
		System.out.println(Arrays.toString(splitArr));
		splitArr=p.split(input,3);
		System.out.println(Arrays.toString(splitArr));
	}

}
