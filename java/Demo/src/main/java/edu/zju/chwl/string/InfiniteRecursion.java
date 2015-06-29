package edu.zju.chwl.string;
/*无意识递归*/
public class InfiniteRecursion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InfiniteRecursion ir=new InfiniteRecursion();
		System.out.println(ir);
	}

	/**会出现无限递归 
	 * + this 会调用 toString方法
	 * 解决办法是调用Object的toString方法
	 * 或者，不重写toString方法
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "address:"+this;
	}

}
