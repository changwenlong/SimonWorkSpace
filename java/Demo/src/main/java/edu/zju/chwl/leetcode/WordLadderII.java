package edu.zju.chwl.leetcode;

import java.util.*;

/**
 * https://leetcode.com/problems/word-ladder-ii/
 * 
 * BFS (TLE) 验证两个字符串是否只有一个字符不同时， 1.若采用遍历wordList的方法 时间复杂度 O(n*n)
 * 2.若采用主动改变字符串，然后看wordList中是否包含，此时的时间复杂度是O(n), 注意：HashSet 的contains方法
 * 时间复杂度是O(1) TreeSet 的contains方法 时间复杂度为O(logn)
 * 
 * 效率仍旧很低，需借鉴
 * 
 * 怀疑保存中间结果，很费时，也就是line 65
 * 
 * @author chwl
 * @Date 2016年3月12日 下午9:54:18
 */
public class WordLadderII {

	public static void main(String[] args) {
		System.out.println(new WordLadderII().findLadders(
				"red",
				"tax",
				new HashSet<String>(Arrays.asList(new String[] { "ted","tex","red","tax","tad","den","rex","pee"}))));

	}

	public List<List<String>> findLadders(String beginWord, String endWord,
			Set<String> wordList) {
		List<List<String>> lists = new ArrayList<List<String>>();
		List<List<String>> results = new ArrayList<List<String>>();
		List<String> list = new ArrayList<String>();
		list.add(beginWord);
		lists.add(list);
		if (beginWord.equals(endWord)) {
			return lists;
		}
		Queue<String> q = new LinkedList<String>();
		q.offer(beginWord);
		boolean flag=true;
		while (!q.isEmpty()&&flag) {
			wordList.removeAll(q);
			int size = q.size();
			for (int i = 0; i < size; i++) {
				String word = q.poll();
				list = lists.remove(0);
				char[] charArr = word.toCharArray();
				for (int j = 0; j < word.length(); j++) {
					char tmpChar = charArr[j];
					for (int k = 0; k < 26; k++) {
						charArr[j] = (char) (k + 'a');
						String str = new String(charArr);
						if (str.equals(endWord)) {
							list.add(endWord);
							results.add(new ArrayList<String>(list));
							flag = false;
							continue;
						}
						if (wordList.contains(str)) {
							q.offer(str);
							list.add(str);
							lists.add(new ArrayList<String>(list));
							list.remove(list.size()-1);
						}
					}
					charArr[j] = tmpChar;
				}
			}
		}
		return results;
	}

}
