
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1="hello";
		String s2=" world";
		String s3="hello world";
		String s4=s1+s2;
		System.out.println(s3==s4);
		s4=(s1+s2).intern();
		System.out.println(s3==s4);
	}

}
