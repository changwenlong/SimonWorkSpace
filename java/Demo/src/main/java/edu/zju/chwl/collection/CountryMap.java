package edu.zju.chwl.collection;

import java.util.*;

public class CountryMap extends AbstractMap<String, String> {
	//作为存储Map的数据结构
	String[][] data={{"USA","NewYork"},{"China","Beijing"}};

	@Override
	public Set<Map.Entry<String, String>> entrySet() {
		return new EntrySet();
	}
	
	class Entry implements Map.Entry<String, String>{
		int index;
		Entry(int index){
			this.index=index;
		}
		@Override
		public String getKey() {
			return data[index][0];
		}

		@Override
		public String getValue() {
			return data[index][1];
		}

		@Override
		public String setValue(String value) {
			throw new UnsupportedOperationException();
		}
		
	}
	
	class EntrySet extends AbstractSet<Map.Entry<String, String>>{

		@Override
		public Iterator<Map.Entry<String, String>> iterator() {
			return new Iterator<Map.Entry<String, String>>(){
				
				Entry entry=new Entry(-1);
				@Override
				public boolean hasNext() {
					return entry.index<size()-1;
				}

				@Override
				public Map.Entry<String, String> next() {
					// TODO Auto-generated method stub
					entry.index++;
					return entry;
				}

				@Override
				public void remove() {
					throw new UnsupportedOperationException();					
				}
				
			};
			
				
		}
		

		@Override
		public int size() {
			return data.length;
		}
		
	}
	
	public static void main(String[] args){
		Map<String,String> countryMap=new CountryMap();
		for(Map.Entry<String, String> countryItem:countryMap.entrySet()){
			System.out.println(countryItem.getKey()+" : "+countryItem.getValue());
		}
	}

}
