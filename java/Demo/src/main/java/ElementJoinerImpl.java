import java.util.*;

public class ElementJoinerImpl implements  ElementJoiner{
	
	public ElementJoinerImpl(){
		
	}

	public <T>  String join(T[] ts, String delimeter) {
		String result="";
		for(T t:ts){
			result+=t.toString()+delimeter;
		}
		return result.substring(0,result.length()-delimeter.length());
	}

	public <T> String join(Collection<T> ts, String delimeter) {
		String result="";
		for(T t:ts){
			result+=t.toString()+delimeter;
		}
		return result.substring(0,result.length()-delimeter.length());
	}

	public static void main(String[] args){
		ElementJoinerImpl ee=new ElementJoinerImpl();
		System.out.println(ee.join(new Integer[]{1,2,3}," | "));;
	}
}

interface ElementJoiner{
	public <T> String join(T[] ts,String delimeter);
	public <T> String join(Collection<T> ts,String delimeter);
}