package edu.zju.chwl.array;

public class CountingGenetator {
	//Boolean类型
	public static class Boolean implements Generator<java.lang.Boolean>{
		private boolean flag=false;
		@Override
		public java.lang.Boolean next() {
			flag=!flag;
			return flag;
		}
		
	}
	//Integer类型
	public static class Integer implements Generator<java.lang.Integer>{
		private int index=1;
		@Override
		public java.lang.Integer next() {
			return index++;
		}
		
	}
	static char[] chars=("abcdefghijklmnopqrstuvwxyz" +
			"ABCDEFGHIJKLMNOPQRSTUVWXYZ").toCharArray();
	//Character类型
	public static class Character implements Generator<java.lang.Character>{
		private int index=-1;
		@Override
		public java.lang.Character next() {
			index=(index+1)%chars.length;
			return chars[index];
		}
		
	}
	//String类型
	public static class String implements Generator<java.lang.String>{
		private int length;
		String(){
			this.length=7;
		}
		String(int length){
			this.length=length;
		}
		Generator<java.lang.Character> ch=new Character();
		@Override
		public java.lang.String next() {
			char[] buf=new char[length];
			for(int i=0;i<length;i++){
				buf[i]=ch.next();
			}
//			return Arrays.toString(buf);
			return new java.lang.String(buf);
		}
		
	}

}

interface Generator<T>{
	T next();
}