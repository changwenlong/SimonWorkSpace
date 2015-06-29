package edu.zju.chwl.string;
/**
 * String.format能够生成格式化的String对象
 * @author chwl
 * @Date 2015年5月30日 下午8:38:17
 */
public class StringFormat {

	public static void main(String[] args) {
		int a=9,b=8;
		String formatStr=String.format("%d+%d=%d", a,b,a+b);
		System.out.println(formatStr);
		String str=a+"+"+b+"="+(a+b);
		System.out.println(str);
	}

}
