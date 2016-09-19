package edu.zju.chwl.coder.c11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

import org.junit.Test;

public class SortString {
	
	class MyString{
		String str;
		MyString(String str){
			this.str=str;
		}
		@Override
		public int hashCode() {
			return 1;
		}
		@Override
		public boolean equals(Object obj) {
			char[] charArr1 = ((MyString)obj).str.toCharArray();
			Arrays.sort(charArr1);
			String str1 = new String(charArr1);
			char[] charArr2 = this.str.toCharArray();
			Arrays.sort(charArr2);
			String str2 = new String(charArr2);
			return str1.equals(str2);
		}
	}
	
	public ArrayList<String> sortStrings1(String[] str, int n) {
		Arrays.sort(str);//自然序排序
		MyString[] myStr =new MyString[n];
		for(int i=0;i<n;i++){
			myStr[i]=new MyString(str[i]);
		}
		HashSet<MyString> hashSet = new LinkedHashSet<MyString>(Arrays.asList(myStr));//自定义类重写hashCode 和equals去重
		ArrayList<String> list = new ArrayList<String>();
		for(MyString s:hashSet){
			list.add(s.str);
		}
		return list;
	}
	
	public ArrayList<String> sortStrings(String[] str, int n) {
		Arrays.sort(str);//自然序排序
		Comparator<String> cmp = new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				char[] charArr1 = o1.toCharArray();
				Arrays.sort(charArr1);
				String str1 = new String(charArr1);
				char[] charArr2 = o2.toCharArray();
				Arrays.sort(charArr2);
				String str2 = new String(charArr2);
				return str1.compareTo(str2);
			}
		};
		TreeSet<String> treeSet = new TreeSet<String>(cmp);//能去重 但排序已变
		for (String s : str) {
			treeSet.add(s);
		}
		ArrayList<String> list = new ArrayList<String>(treeSet);
		Collections.sort(list);
		return list;
	}

	@Test
	public void test() {
		ArrayList<String> sortStrings = sortStrings1(new String[] { "emmaldzsvjggzfoda",
				"skmjhsm", "zjwmkgufsvwrwyvrhk", "vyksgrwwjmwrhzfvuk",
				"wfszrykvjrmuwhkvgw", "kwrwuwjvksyvhmrzfg", "kom", "mko",
				"mko", "nezrxmdjgjqexmqz", "gjmqdrzqzjeemxxn",
				"qqxedgjjmrznmxez", "xxgmjezerjnqmzdq", "vwcmmngdsvzx",
				"xvmdvwscgnmz", "msnvvczxdgwm", "izmvzrhltsiubcukc",
				"cslnzuenr", "rznulsenc", "lnsnucrez", "gkyfvvni", "gikvvynf",
				"ivkfyvng", "vygfvikn", "nwxkeyhnvniquhpapw",
				"wnhyknvanhepwquxip", "rrpujexoukmmrnmpdzcf", "ksirghrnjx",
				"ixrhgkrnjs", "kup", "kpu", "kpu", "emnetqjwnfwi", "qpozvklf",
				"qpvkolfz", "flpkvoqz", "zlkpvfoq", "zldjqciktnevrkb",
				"vklqjdrktcebizn", "ntrqkvebiljczkd", "nkktcebjirqvldz",
				"mytegbucud", "gbtcyuemud", "gctmuedybu", "ahgeomesgcehvk",
				"oamshhecevggek", "gmcekevoehsahg", "gvgeacmheeoksh", "ma",
				"am", "am", "wxdyddyrenzsylfwx", "syedwdylxrwfyxzdn",
				"dwsddyelxywrxyfnz", "rdrrfuowxukryfmli", "qdjzmdobajs",
				"ymysuotfxpboc", "awzccscrkozbhygrkvv", "ovrgybhswrczzkcacvk",
				"zcrwkyhrzkgacvsocbv", "vzwgzosrkvkcrcybahc", "ftytv", "ttvyf",
				"tfyvt", "vtytf", "pggunxuyduy", "qijygauutkt", "aytqutkugji",
				"itjutqugaky", "nfoenumvnmannkkhmueo", "ounmkhknefvemnmannou",
				"eonmenfkhmuaonnnumvk", "mvnouemekonfamnnnhku", "a" }, 74);
		System.out.println(sortStrings);
		System.out.println(sortStrings.size());
	}
}
