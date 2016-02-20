package edu.zju.chwl.collection;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SlowMap<K,V> extends AbstractMap<K, V> {
	
	private List<K> keys=new ArrayList<K>();
	private List<V> values=new ArrayList<V>();
	

	@Override
	public V get(Object key) {
		if(!keys.contains(key))
			return null;
		return values.get(keys.indexOf(key));
	}


	@Override
	public V put(K key, V value) {
		V oldValue=get(key);
		if(oldValue!=null){
			values.set(keys.indexOf(key), value);
		}else{
			keys.add(key);
			values.add(value);
		}
		return oldValue;
	}


	@Override
	public Set<java.util.Map.Entry<K, V>> entrySet() {
		Set<Map.Entry<K, V>> set=new HashSet<Map.Entry<K,V>>();
		for(K key : keys){
			set.add(new MapEntry<K,V>(key,values.get(keys.indexOf(key))));
		}
		return set;
	}

	
	public static void main(String[] args) {
		SlowMap<String,String> map=new SlowMap<String,String>();
		map.putAll(new CountryMap());
		System.out.println(map);
		System.out.println(map.keys);
		System.out.println(map.values);
	}
}

class MapEntry<K,V> implements Map.Entry<K, V>{

	private K key;
	private V value;
	MapEntry(K key,V value){
		this.key=key;
		this.value=value;
	}
	@Override
	public K getKey() {
		return this.key;
	}

	@Override
	public V getValue() {
		return this.value;
	}

	@Override
	public V setValue(V value) {
		this.value=value;
		return this.value;
	}
	
	@Override
	public int hashCode() {		
		return ((key==null)?0:key.hashCode())^((value==null)?0:value.hashCode());
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof MapEntry))
			return false;
		@SuppressWarnings("unchecked")
		MapEntry<K,V> me=(MapEntry<K,V>)obj;
		return (key==null?me.getKey()==null:key.equals(me.getKey()))&&
				(value==null?me.getValue()==null:value.equals(me.getValue()));
		
	}
	@Override
	public String toString() {
		return key+"="+value;
	}
	
}
