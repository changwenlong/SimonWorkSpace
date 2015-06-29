package edu.zju.chwl.string;

import java.util.Arrays;

/**
 * string对象的matches、split、replace接受正则表达式形式的参数
 * 这是最简单的使用正则表达式的途径
 * @author chwl
 * @Date 2015年5月30日 下午8:41:47
 */
public class StringRegex {

	public static void main(String[] args) {
		//-?\\d+:匹配0或1个负号 一个或多个数字
		System.out.println("-1234".matches("-?\\d+"));
		//\\W+:匹配一个或多个非单词字母
		System.out.println(Arrays.toString("then,,when you".split("\\W+")));
		System.out.println("then,,when you".replaceAll("\\W+", " ## "));
	}

}
