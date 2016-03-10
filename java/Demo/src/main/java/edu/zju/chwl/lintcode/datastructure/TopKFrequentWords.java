package edu.zju.chwl.lintcode.datastructure;

import java.util.HashMap;
import java.util.Map;

/**
 * http://www.lintcode.com/en/problem/top-k-frequent-words/
 * 
 * hashMap+最大堆算法
 * 
 * @author a590450
 * @date 1 Mar 2016 14:27:45
 */
public class TopKFrequentWords {

	public static void main(String[] args) {
		String[] strs = new String[] {"ba","fe","bd","bf","fe","ae",
				"ae","ed","ef","ab","cd","ac","cf","af","ed","ef","fb",
				"ba","dc","ca","cb","ca","bc","bf","ae","ec","fa","ac",
				"bd","af","fa","dc","cb","ed","db","fa","cb","fe","ab",
				"bd","eb","af","ad","cd","bf","bc","cd","fd","de","fc",
				"ef","bc","ca","fe","ac","ac","cb","eb","ca","fa","bf",
				"ed","cb","ef","be","de","da","bc","ad","cf","ef","fd",
				"ce","be","df","bf","fd","ef","ab","ef"};
		/*strs=new String[]{"yes","lint","code","yes","code","baby",
				"you","baby","chrome","safari","lint","code","body","lint","code"};*/
		String[] ss = topKFrequentWords(strs, 3);
		for (String item : ss) {
			System.out.println(item);
		}

	}

	public static String[] topKFrequentWords(String[] words, int k) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (String s : words) {
			Integer value = map.get(s);
			if (value != null) {
				map.put(s, value + 1);
			} else {
				map.put(s, 1);
			}
		}
		System.out.println(map);
		@SuppressWarnings("unchecked")
		Map.Entry<String, Integer>[] entryArr = map.entrySet().toArray(
				new Map.Entry[0]);
		String[] ss = getTopK(entryArr, k);
		return ss;
	}

	//最大堆调整算法
	public static String[] getTopK(Map.Entry<String, Integer>[] entryArr, int k) {
		if (entryArr == null || entryArr.length < k) {
			return new String[0];
		}
		int len = entryArr.length - 1;
		String[] result = new String[k];
		int count = 0;
		while (count < k) {
			int pos = len;
			while (pos != 0) {
				int index = (pos - 1) / 2;
				if (entryCompare(entryArr[pos],entryArr[index])>0) {
					Map.Entry<String, Integer> tmp = entryArr[pos];
					entryArr[pos] = entryArr[index];
					entryArr[index] = tmp;
				}
				pos--;
			}
			result[count++] = entryArr[0].getKey();
			entryArr[0]=entryArr[len--];
		}
		return result;
	}

	public static int entryCompare(Map.Entry<String, Integer> entry,
			Map.Entry<String, Integer> entry2) {
		int c = entry.getValue().compareTo(entry2.getValue());
		if(c==0){
			c=entry2.getKey().compareTo(entry.getKey());
		}
		return c;
	}
	
	

}
