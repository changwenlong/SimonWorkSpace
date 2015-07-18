package edu.zju.chwl.clone;

public final class PhoneNumber implements Cloneable,Comparable<PhoneNumber>{

	private final int areaCode;
	private final int prefix;
	private final int lineNumber;
	
	public PhoneNumber(int areaCode,int prefix,int lineNumber){
		this.areaCode=areaCode;
		this.prefix=prefix;
		this.lineNumber=lineNumber;
	}
	
	@Override
	public boolean equals(Object o){
		System.out.println(o+":equals");
		if(o==this){
			return true;
		}
		if(o instanceof PhoneNumber){
			PhoneNumber pn=(PhoneNumber)o;
			return pn.areaCode==this.areaCode
					&& pn.prefix==this.prefix
					&& pn.lineNumber==this.lineNumber;
		}else{
			return false;
		}
	}
	
	
	
	@Override
	public int hashCode() {
		int result=17;
		result=31*result+areaCode;
		result=31*result+prefix;
		result=31*result+lineNumber;
		System.out.println(this+":hashCode");
		return result;
	}

	@Override
	public String toString() {
		return String.format("%3d-%4d%3d", areaCode,prefix,lineNumber);
	}

	public int compareTo(PhoneNumber o) {
		System.out.println(o+":compareTo");
		return this.toString().compareTo(o.toString());
	}

	@Override 
	public PhoneNumber clone(){
		try{
			return (PhoneNumber)super.clone();
		}catch(CloneNotSupportedException e){
			throw new AssertionError();
		}
	}
}
