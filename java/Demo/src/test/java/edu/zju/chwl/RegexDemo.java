package edu.zju.chwl;

import org.junit.Test;

public class RegexDemo {

	@Test
	public void test() {
		String a="/*123\n */111";
		System.out.println(a.startsWith("/*"));
		String b = "//123";
		System.out.println(b.startsWith("//"));
	}

}
