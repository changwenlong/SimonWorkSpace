package edu.zju.chwl.lintcode.datastructure;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * http://www.lintcode.com/zh-cn/problem/lru-cache/
 * @author chwl
 * @Date 2016年3月6日 下午4:18:15
 */
@SuppressWarnings("serial")
public class LRUCache extends LinkedHashMap<Integer, Integer>{

	private int capacity;
    public LRUCache(int capacity) {
        super(16,0.75f,true);
    	this.capacity=capacity;
    }

    // @return an integer
    public int get(int key) {
    	Integer value = super.get(key);
        return value==null?-1:value;
    }

    // @param key, an integer
    // @param value, an integer
    // @return nothing
    public void set(int key, int value) {
    	super.put(key, value);
    }
    
    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer,Integer> eldest) {
        return this.size() > capacity;
    }
    
    public static void main(String[] args) {
    	LRUCache lru=new LRUCache(2);
    	lru.set(2, 1);
		lru.set(1, 1);
		System.out.println(lru.get(2));
		lru.set(4, 1);
		System.out.println(lru.get(1));
		System.out.println(lru.get(2));
	}
}
