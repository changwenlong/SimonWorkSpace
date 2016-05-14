package edu.zju.chwl.leetcode;

import java.util.*;

/**
 * https://leetcode.com/problems/word-ladder/
 * 
 * BFS
 * (TLE) 验证两个字符串是否只有一个字符不同时，
 * 1.若采用遍历wordList的方法 时间复杂度 O(n*n)
 * 2.若采用主动改变字符串，然后看wordList中是否包含，此时的时间复杂度是O(n), 
 * 注意：HashSet 的contains方法 时间复杂度是O(1)
 * TreeSet 的contains方法 时间复杂度为O(logn)
 * 
 * @author chwl
 * @Date 2016年3月12日 下午9:54:18
 */
public class WordLadder {

	public static void main(String[] args) {
		System.out.println(new WordLadder().ladderLength(
				"hit",
				"cog",
				new HashSet<String>(Arrays
						.asList(new String[] { "hot","dot","dog","lot","log" }))));

	}

	public int ladderLength(String beginWord, String endWord,
			Set<String> wordList) {
		if (beginWord.equals(endWord)) {
			return 1;
		}
		Queue<String> q = new LinkedList<String>();
		q.offer(beginWord);
		int len = 1;
		while (!q.isEmpty()) {
			len++;
			int size = q.size();
			for (int i = 0; i < size; i++) {
				String word = q.poll();
				char[] charArr = word.toCharArray();
				for (int j = 0; j < word.length(); j++) {
					char tmpChar = charArr[j];
					for (int k = 0; k < 26; k++) {
						charArr[j] = (char) (k + 'a');
						String str = new String(charArr);
						if (str.equals(endWord)) {
							return len;
						}
						if (wordList.contains(str)) {
							q.offer(str);
							wordList.remove(str);
						}
					}
					charArr[j] = tmpChar;
				}
			}
		}
		return 0;
	}

}
